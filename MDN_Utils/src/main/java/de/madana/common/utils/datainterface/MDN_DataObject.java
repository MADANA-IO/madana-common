/*******************************************************************************
 * Copyright (C) 2018 MADANA
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * @organization:MADANA
 * @author:Jean-Fabian Wenisch
 * @contact:dev@madana.io
 ******************************************************************************/
package de.madana.common.utils.datainterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

// TODO: Auto-generated Javadoc
/**
 * The Class MDN_DataObject.
 */
public class MDN_DataObject 
{
	
	/** The map. */
	private Map<String, String> map = new HashMap<String, String>();
	
	/**
	 * Adds the entry.
	 *
	 * @param strKey the str key
	 * @param strValue the str value
	 */
	public void addEntry(String strKey, String strValue)
	{
		map.put(strKey, strValue);
	}
	
	/**
	 * Gets the entry.
	 *
	 * @param strKey the str key
	 * @return the entry
	 */
	public String getEntry(String strKey)
	{
		return map.get(strKey);
	}
	
	/**
	 * Gets the keys.
	 *
	 * @return the keys
	 */
	public List<String> getKeys()
	{
		List <String> oKeyList = new ArrayList<String>();
		  for (Entry<String, String> entry : map.entrySet()) {
		        oKeyList.add(entry.getKey());
		    }
		  return oKeyList;
	}
}
