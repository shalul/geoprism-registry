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

import java.util.Iterator;
import java.util.List;

import com.runwaysdk.query.OIterator;

public class ListIterator<T> implements OIterator<T>
{

  private List<T>     list;

  private Iterator<T> it;

  public ListIterator(List<T> list)
  {
    this.list = list;
    this.it = list.iterator();
  }

  @Override
  public Iterator<T> iterator()
  {
    return this.list.iterator();
  }

  @Override
  public T next()
  {
    return this.it.next();
  }

  @Override
  public void remove()
  {
    this.it.remove();
  }

  @Override
  public boolean hasNext()
  {
    return this.it.hasNext();
  }

  @Override
  public void close()
  {
  }

  @Override
  public List<T> getAll()
  {
    return this.list;
  }

}
