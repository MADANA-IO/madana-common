/**
 * 
 */
package de.madana.common.datastructures;

/**
 * @author J.-Fabian Wenisch
 *
 */
public class MDN_SimpleUserProfile extends MDN_A_UserObject implements Comparable<MDN_SimpleUserProfile>
{
	 String points;
		public String getPoints() 
		{
			return points;
		}
		public void setPoints(String points) {
			this.points = points;
		}
		
		@Override
		   public int compareTo(MDN_SimpleUserProfile another) {
		      return Integer.valueOf(another.points).compareTo(Integer.valueOf(points));
		   }
}
