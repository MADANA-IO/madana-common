/**
 * 
 */
package de.madana.common.datastructures;

// TODO: Auto-generated Javadoc
/**
 * The Class MDN_SimpleUserProfile.
 *
 * @author J.-Fabian Wenisch
 */
public class MDN_SimpleUserProfile extends MDN_A_UserObject implements Comparable<MDN_SimpleUserProfile>
{
	 
 	/** The points. */
 	String points;
		
		/**
		 * Gets the points.
		 *
		 * @return the points
		 */
		public String getPoints() 
		{
			return points;
		}
		
		/**
		 * Sets the points.
		 *
		 * @param points the new points
		 */
		public void setPoints(String points) {
			this.points = points;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		   public int compareTo(MDN_SimpleUserProfile another) {
		      return Integer.valueOf(another.points).compareTo(Integer.valueOf(points));
		   }
}
