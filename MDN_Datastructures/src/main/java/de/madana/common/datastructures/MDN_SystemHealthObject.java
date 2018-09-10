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
package de.madana.common.datastructures;


public class MDN_SystemHealthObject
{

private String activeusercount;
private String usercount;
private String rankingPointsSum;
private String rankingupdate;
private String feedUpdate;
private String useractionupdate;
private String databaseconnection;
private String startup;
public String getRankingPointsSum() {
	return rankingPointsSum;
}
public void setRankingPointsSum(String rankingPointsSum) {
	this.rankingPointsSum = rankingPointsSum;
}
public String getActiveusercount() {
	return activeusercount;
}
public void setActiveusercount(String activeusercount) {
	this.activeusercount = activeusercount;
}
public String getUsercount() {
	return usercount;
}
public void setUsercount(String usercount) {
	this.usercount = usercount;
}
public String getRankingupdate() {
	return rankingupdate;
}
public void setRankingupdate(String rankingupdate) {
	this.rankingupdate = rankingupdate;
}
public String getFeedUpdate() {
	return feedUpdate;
}
public void setFeedUpdate(String feedUpdate) {
	this.feedUpdate = feedUpdate;
}
public String getUseractionupdate() {
	return useractionupdate;
}
public void setUseractionupdate(String useractionupdate) {
	this.useractionupdate = useractionupdate;
}
public String getDatabaseconnection() {
	return databaseconnection;
}
public void setDatabaseconnection(String databaseconnection) {
	this.databaseconnection = databaseconnection;
}
public String getStartup() {
	return startup;
}
public void setStartup(String startup) {
	this.startup = startup;
}



}
