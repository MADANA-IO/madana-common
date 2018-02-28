package datainterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MDN_DataObject 
{
	private Map<String, String> map = new HashMap<String, String>();
	
	public void addEntry(String strKey, String strValue)
	{
		map.put(strKey, strValue);
	}
	
	public String getEntry(String strKey)
	{
		return map.get(strKey);
	}
	public List<String> getKeys()
	{
		List <String> oKeyList = new ArrayList<String>();
		  for (Entry<String, String> entry : map.entrySet()) {
		        oKeyList.add(entry.getKey());
		    }
		  return oKeyList;
	}
}
