/**
 * Copyright (c) 2022 TerraFrame, Inc. All rights reserved.
 *
 * This file is part of Geoprism Registry(tm).
 *
 * Geoprism Registry(tm) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * Geoprism Registry(tm) is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Geoprism Registry(tm).  If not, see <http://www.gnu.org/licenses/>.
 */
package net.geoprism.registry.test;

import org.commongeoregistry.adapter.RegistryAdapter;
import org.commongeoregistry.adapter.metadata.MetadataCache;
import org.springframework.stereotype.Component;

import net.geoprism.registry.service.ServiceFactory;

@Component
public class TestRegistryAdapter extends RegistryAdapter
{
  private static final long serialVersionUID = -433764579483802366L;

  public TestRegistryAdapter()
  {
    super(new TestRegistryIdService());
  }
  
  @Override
  public MetadataCache getMetadataCache()
  {
    return ServiceFactory.getAdapter().getMetadataCache();
  }
  
  
}