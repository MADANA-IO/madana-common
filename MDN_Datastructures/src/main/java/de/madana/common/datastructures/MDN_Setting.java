/**
 * 
 */
package de.madana.common.datastructures;

/**
 * @author J.-Fabian Wenisch
 *
 */
public class MDN_Setting 
{
	String id;
	String name;
	String description;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String toString()
	{
		return name;
	}
}
