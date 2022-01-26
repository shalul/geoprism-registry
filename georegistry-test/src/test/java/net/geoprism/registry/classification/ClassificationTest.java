package net.geoprism.registry.classification;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.runwaysdk.session.Request;

import net.geoprism.registry.model.Classification;
import net.geoprism.registry.model.ClassificationType;
import net.geoprism.registry.view.Page;

public class ClassificationTest
{
  private static String             PARENT_CODE = "PARENT_OBJ";

  private static String             CHILD_CODE  = "CHILD_OBJ";

  private static ClassificationType type;

  @BeforeClass
  public static void setUpClass()
  {
    setUpClassInRequest();
  }

  @Request
  private static void setUpClassInRequest()
  {
    type = ClassificationType.apply(ClassificationTypeTest.createMock());
  }

  @AfterClass
  public static void cleanUpClass()
  {
    cleanUpClassInRequest();
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
  public void testBasicCreate()
  {
    Classification object = Classification.newInstance(type);
    object.setCode(PARENT_CODE);
    object.apply(null);

    try
    {
      Assert.assertNotNull(object.getVertex().getRID());
    }
    finally
    {
      object.delete();
    }
  }

  @Test
  @Request
  public void testGetByCode()
  {
    Classification object = Classification.newInstance(type);
    object.setCode(PARENT_CODE);
    object.apply(null);

    try
    {
      Classification result = Classification.get(type, object.getCode());

      Assert.assertEquals(object.getOid(), result.getOid());
    }
    finally
    {
      object.delete();
    }
  }

  @Test
  @Request
  public void testAddGetChild()
  {
    Classification parent = Classification.newInstance(type);
    parent.setCode(PARENT_CODE);
    parent.apply(null);

    try
    {
      Classification child = Classification.newInstance(type);
      child.setCode(CHILD_CODE);
      child.apply(null);

      try
      {
        parent.addChild(child);

        Page<Classification> children = parent.getChildren(20, 1);

        Assert.assertEquals(Long.valueOf(1), children.getCount());

        Classification result = children.getResults().get(0);

        Assert.assertEquals(child.getOid(), result.getOid());
      }
      finally
      {
        child.delete();
      }
    }
    finally
    {
      parent.delete();
    }
  }

  @Test
  @Request
  public void testAddGetChildApplyWithParent()
  {
    Classification parent = Classification.newInstance(type);
    parent.setCode(PARENT_CODE);
    parent.apply(null);

    try
    {
      Classification child = Classification.newInstance(type);
      child.setCode(CHILD_CODE);
      child.apply(parent);

      try
      {
        Page<Classification> children = parent.getChildren(20, 1);

        Assert.assertEquals(Long.valueOf(1), children.getCount());

        Classification result = children.getResults().get(0);

        Assert.assertEquals(child.getOid(), result.getOid());
      }
      finally
      {
        child.delete();
      }
    }
    finally
    {
      parent.delete();
    }
  }

  @Test
  @Request
  public void testRemoveParent()
  {
    Classification parent = Classification.newInstance(type);
    parent.setCode(PARENT_CODE);
    parent.apply(null);

    try
    {
      Classification child = Classification.newInstance(type);
      child.setCode(CHILD_CODE);
      child.apply(null);

      try
      {
        child.addParent(parent);

        Assert.assertEquals(1, child.getParents().size());

        child.removeParent(parent);

        Assert.assertEquals(0, child.getParents().size());
      }
      finally
      {
        child.delete();
      }
    }
    finally
    {
      parent.delete();
    }
  }

  @Test
  @Request
  public void testRemoveChild()
  {
    Classification parent = Classification.newInstance(type);
    parent.setCode(PARENT_CODE);
    parent.apply(null);

    try
    {
      Classification child = Classification.newInstance(type);
      child.setCode(CHILD_CODE);
      child.apply(null);

      try
      {
        parent.addChild(child);

        Assert.assertEquals(Long.valueOf(1), parent.getChildren().getCount());

        parent.removeChild(child);

        Assert.assertEquals(Long.valueOf(0), parent.getChildren().getCount());
      }
      finally
      {
        child.delete();
      }
    }
    finally
    {
      parent.delete();
    }
  }

  @Test
  @Request
  public void testAddGetParent()
  {
    Classification parent = Classification.newInstance(type);
    parent.setCode(PARENT_CODE);
    parent.apply(null);

    try
    {
      Classification child = Classification.newInstance(type);
      child.setCode(CHILD_CODE);
      child.apply(null);

      try
      {
        child.addParent(parent);

        List<Classification> parents = child.getParents();

        Assert.assertEquals(1, parents.size());

        Classification result = parents.get(0);

        Assert.assertEquals(parent.getOid(), result.getOid());
      }
      finally
      {
        child.delete();
      }
    }
    finally
    {
      parent.delete();
    }
  }

}
