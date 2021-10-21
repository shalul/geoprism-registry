package net.geoprism.registry.business;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

import org.commongeoregistry.adapter.dataaccess.LocalizedValue;
import org.commongeoregistry.adapter.metadata.AttributeCharacterType;
import org.commongeoregistry.adapter.metadata.AttributeType;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.JsonObject;
import com.runwaysdk.session.Request;
import com.runwaysdk.system.scheduler.AllJobStatus;
import com.runwaysdk.system.scheduler.ExecutionContext;
import com.runwaysdk.system.scheduler.MockScheduler;

import net.geoprism.data.importer.BasicColumnFunction;
import net.geoprism.registry.ProgrammaticType;
import net.geoprism.registry.etl.DataImportJob;
import net.geoprism.registry.etl.FormatSpecificImporterFactory.FormatImporterType;
import net.geoprism.registry.etl.ImportHistory;
import net.geoprism.registry.etl.ImportStage;
import net.geoprism.registry.etl.NullImportProgressListener;
import net.geoprism.registry.etl.ObjectImporterFactory.ObjectImportType;
import net.geoprism.registry.etl.upload.ImportConfiguration;
import net.geoprism.registry.etl.upload.ImportConfiguration.ImportStrategy;
import net.geoprism.registry.etl.upload.ProgrammaticObjectImportConfiguration;
import net.geoprism.registry.etl.upload.ProgrammaticObjectImporter;
import net.geoprism.registry.etl.upload.ProgrammaticObjectRecordedErrorException;
import net.geoprism.registry.excel.MapFeatureRow;
import net.geoprism.registry.io.Location;
import net.geoprism.registry.io.ParentCodeException;
import net.geoprism.registry.io.ParentMatchStrategy;
import net.geoprism.registry.model.ProgrammaticObject;
import net.geoprism.registry.model.ServerGeoObjectType;
import net.geoprism.registry.model.ServerHierarchyType;
import net.geoprism.registry.model.graph.VertexServerGeoObject;
import net.geoprism.registry.service.ExcelService;
import net.geoprism.registry.test.FastTestDataset;
import net.geoprism.registry.test.TestDataSet;

public class ProgrammaticObjectImporterTest
{
  private static FastTestDataset  testData;

  private static ProgrammaticType type;

  private static AttributeType    attributeType;

  @BeforeClass
  public static void setUpClass()
  {
    testData = FastTestDataset.newTestData();
    testData.setUpMetadata();
    testData.setUpInstanceData();

    setUpClassInRequest();
  }

  @Request
  private static void setUpClassInRequest()
  {
    String code = "TEST_PROG";
    String orgCode = FastTestDataset.ORG_CGOV.getCode();
    String label = "Test Prog";

    JsonObject object = new JsonObject();
    object.addProperty(ProgrammaticType.CODE, code);
    object.addProperty(ProgrammaticType.ORGANIZATION, orgCode);
    object.add(ProgrammaticType.DISPLAYLABEL, new LocalizedValue(label).toJSON());

    type = ProgrammaticType.apply(object);

    attributeType = type.createAttributeType(new AttributeCharacterType("testCharacter", new LocalizedValue("Test Character"), new LocalizedValue("Test True"), false, false, false));
  }

  @AfterClass
  public static void cleanUpClass()
  {
    cleanUpClassInRequest();

    if (testData != null)
    {
      testData.tearDownInstanceData();
      testData.tearDownMetadata();
    }
  }

  @Request
  private static void cleanUpClassInRequest()
  {
    if (type != null)
    {
      type.delete();
    }
  }

  @Test
  @Request
  public void testImportValue() throws InterruptedException
  {
    String value = "Test Text";
    String rowAttribute = "Bad";

    HashMap<String, Object> row = new HashMap<String, Object>();
    row.put(rowAttribute, value);

    ProgrammaticObjectImportConfiguration configuration = new ProgrammaticObjectImportConfiguration();
    configuration.setImportStrategy(ImportStrategy.NEW_ONLY);
    configuration.setType(type);
    configuration.setDate(FastTestDataset.DEFAULT_END_TIME_DATE);
    configuration.setCopyBlank(false);
    configuration.setFunction(attributeType.getName(), new BasicColumnFunction(rowAttribute));

    ProgrammaticObjectImporter importer = new ProgrammaticObjectImporter(configuration, new NullImportProgressListener());
    importer.importRow(new MapFeatureRow(row));

    ProgrammaticObject result = ProgrammaticObject.get(type, attributeType.getName(), value);

    try
    {
      Assert.assertNotNull(result);
    }
    finally
    {
      result.delete();
    }
  }

  @Test
  @Request
  public void testSetGeoObject() throws InterruptedException
  {
    ServerHierarchyType hierarchy = FastTestDataset.HIER_ADMIN.getServerObject();
    ServerGeoObjectType got = FastTestDataset.DISTRICT.getServerObject();

    String value = "Test Text";
    String rowAttribute = "Bad";
    String geoAttribute = "Geo Object";

    HashMap<String, Object> row = new HashMap<String, Object>();
    row.put(rowAttribute, value);
    row.put(geoAttribute, FastTestDataset.DIST_CENTRAL.getCode());

    ProgrammaticObjectImportConfiguration configuration = new ProgrammaticObjectImportConfiguration();
    configuration.setImportStrategy(ImportStrategy.NEW_ONLY);
    configuration.setType(type);
    configuration.setHierarchy(hierarchy);
    configuration.setDate(FastTestDataset.DEFAULT_END_TIME_DATE);
    configuration.setCopyBlank(false);
    configuration.setFunction(attributeType.getName(), new BasicColumnFunction(rowAttribute));
    configuration.addLocation(new Location(got, hierarchy, new BasicColumnFunction(geoAttribute), ParentMatchStrategy.CODE));

    ProgrammaticObjectImporter importer = new ProgrammaticObjectImporter(configuration, new NullImportProgressListener());
    importer.importRow(new MapFeatureRow(row));

    ProgrammaticObject result = ProgrammaticObject.get(type, attributeType.getName(), value);

    try
    {
      Assert.assertNotNull(result);

      VertexServerGeoObject geoObject = result.getGeoObject();

      Assert.assertNotNull(geoObject);
      Assert.assertEquals(FastTestDataset.DIST_CENTRAL.getCode(), geoObject.getCode());
      Assert.assertEquals(got.getCode(), geoObject.getType().getCode());
    }
    finally
    {
      if (result != null)
      {
        result.delete();
      }
    }
  }

  @Test
  @Request
  public void testUnknownGeoObject() throws InterruptedException
  {
    ServerHierarchyType hierarchy = FastTestDataset.HIER_ADMIN.getServerObject();
    ServerGeoObjectType got = FastTestDataset.DISTRICT.getServerObject();

    String value = "Test Text";
    String rowAttribute = "Bad";
    String geoAttribute = "Geo Object";

    HashMap<String, Object> row = new HashMap<String, Object>();
    row.put(rowAttribute, value);
    row.put(geoAttribute, "Blarg");

    ProgrammaticObjectImportConfiguration configuration = new ProgrammaticObjectImportConfiguration();
    configuration.setImportStrategy(ImportStrategy.NEW_ONLY);
    configuration.setType(type);
    configuration.setHierarchy(hierarchy);
    configuration.setDate(FastTestDataset.DEFAULT_END_TIME_DATE);
    configuration.setCopyBlank(false);
    configuration.setFunction(attributeType.getName(), new BasicColumnFunction(rowAttribute));
    configuration.addLocation(new Location(got, hierarchy, new BasicColumnFunction(geoAttribute), ParentMatchStrategy.CODE));

    ProgrammaticObjectImporter importer = new ProgrammaticObjectImporter(configuration, new NullImportProgressListener());
    importer.importRow(new MapFeatureRow(row));

    ProgrammaticObject result = ProgrammaticObject.get(type, attributeType.getName(), value);

    try
    {
      Assert.assertNull(result);

      LinkedList<ProgrammaticObjectRecordedErrorException> exceptions = configuration.getExceptions();

      Assert.assertEquals(1, exceptions.size());

      ProgrammaticObjectRecordedErrorException exception = exceptions.get(0);
      Throwable error = exception.getError();

      Assert.assertTrue(error instanceof ParentCodeException);

      ParentCodeException ex = (ParentCodeException) error;
      Assert.assertEquals("Blarg", ex.getParentCode());
      Assert.assertEquals(got.getCode(), ex.getParentType());
    }
    finally
    {
      if (result != null)
      {
        result.delete();
      }
    }
  }

  @Test
  @Request
  public void testImportSpreadsheet() throws Throwable
  {
    InputStream istream = this.getClass().getResourceAsStream("/programmatic-spreadsheet.xlsx");

    Assert.assertNotNull(istream);

    ExcelService service = new ExcelService();

    JSONObject json = this.getTestConfiguration(istream, service, ImportStrategy.NEW_AND_UPDATE);

    ProgrammaticObjectImportConfiguration config = (ProgrammaticObjectImportConfiguration) ImportConfiguration.build(json.toString(), true);
    config.setHierarchy(FastTestDataset.HIER_ADMIN.getServerObject());

    ImportHistory hist = mockImport(config);
    Assert.assertTrue(hist.getStatus().get(0).equals(AllJobStatus.SUCCESS));

    hist = ImportHistory.get(hist.getOid());
    Assert.assertEquals(new Long(2), hist.getWorkTotal());
    Assert.assertEquals(new Long(2), hist.getWorkProgress());
    Assert.assertEquals(new Long(2), hist.getImportedRecords());
    Assert.assertEquals(ImportStage.COMPLETE, hist.getStage().get(0));

    Assert.assertNotNull(ProgrammaticObject.get(type, attributeType.getName(), "0001"));
    Assert.assertNotNull(ProgrammaticObject.get(type, attributeType.getName(), "0002"));
  }

  private JSONObject getTestConfiguration(InputStream istream, ExcelService service, ImportStrategy strategy)
  {
    JSONObject result = service.getProgrammaticTypeConfiguration(type.getCode(), TestDataSet.DEFAULT_END_TIME_DATE, "programmatic-spreadsheet.xlsx", istream, strategy, false);
    JSONObject type = result.getJSONObject(ProgrammaticObjectImportConfiguration.TYPE);
    JSONArray attributes = type.getJSONArray(ProgrammaticType.JSON_ATTRIBUTES);

    for (int i = 0; i < attributes.length(); i++)
    {
      JSONObject attribute = attributes.getJSONObject(i);

      String attributeName = attribute.getString(AttributeType.JSON_CODE);

      if (attributeName.equals(attributeType.getName()))
      {
        attribute.put(ProgrammaticObjectImportConfiguration.TARGET, "Code");
      }
    }

    result.put(ImportConfiguration.FORMAT_TYPE, FormatImporterType.EXCEL);
    result.put(ImportConfiguration.OBJECT_TYPE, ObjectImportType.PROGRAMMATIC_OBJECT);
    result.put(ImportConfiguration.IMPORT_STRATEGY, strategy);

    return result;
  }

  private ImportHistory mockImport(ProgrammaticObjectImportConfiguration config) throws Throwable
  {
    if (config.getDate() == null)
    {
      config.setDate(new Date());
    }

    config.setImportStrategy(ImportStrategy.NEW_AND_UPDATE);

    DataImportJob job = new DataImportJob();
    job.apply();
    ImportHistory hist = (ImportHistory) job.createNewHistory();

    config.setHistoryId(hist.getOid());
    config.setJobId(job.getOid());

    ProgrammaticType type = config.getType();

    hist.appLock();
    hist.setImportFileId(config.getVaultFileId());
    hist.setConfigJson(config.toJSON().toString());
    hist.setOrganization(type.getOrganization());
    hist.setGeoObjectTypeCode(type.getCode());
    hist.apply();

    ExecutionContext context = MockScheduler.executeJob(job, hist);

    hist = (ImportHistory) context.getHistory();
    return hist;
  }

}
