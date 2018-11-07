/**
 * Copyright (c) 2015 TerraFrame, Inc. All rights reserved.
 *
 * This file is part of Runway SDK(tm).
 *
 * Runway SDK(tm) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * Runway SDK(tm) is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Runway SDK(tm).  If not, see <http://www.gnu.org/licenses/>.
 */
package net.geoprism;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import com.runwaysdk.mvc.JsonConfiguration;

public class ExcludeConfiguration implements JsonConfiguration
{
  private Set<String> attributeNames;

  private Class<?>    clazz;

  public ExcludeConfiguration(Class<?> clazz, String... attributeNames)
  {
    this.clazz = clazz;
    this.attributeNames = new TreeSet<String>(Arrays.asList(attributeNames));
  }

  @Override
  public boolean supports(Class<?> clazz)
  {
    return this.clazz.isAssignableFrom(clazz);
  }

  @Override
  public boolean exclude(String name)
  {
    return this.attributeNames.contains(name);
  }
}
