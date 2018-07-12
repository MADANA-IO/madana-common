

package de.madana.common.datastructures;


public class MDN_SystemHealthObject {

private String activeUserCount;
private String userCount;
private String rankingUpdate;
private String feedUpdate;
private String userActionUpdate;
private String databaseConnection;
private String startup;

public String getActiveUserCount() {
return activeUserCount;
}

public void setActiveUserCount(String activeUserCount) {
this.activeUserCount = activeUserCount;
}

public String getUserCount() {
return userCount;
}

public void setUserCount(String userCount) {
this.userCount = userCount;
}

public String getRankingUpdate() {
return rankingUpdate;
}

public void setRankingUpdate(String rankingUpdate) {
this.rankingUpdate = rankingUpdate;
}

public String getFeedUpdate() {
return feedUpdate;
}

public void setFeedUpdate(String feedUpdate) {
this.feedUpdate = feedUpdate;
}

public String getUserActionUpdate() {
return userActionUpdate;
}

public void setUserActionUpdate(String userActionUpdate) {
this.userActionUpdate = userActionUpdate;
}

public String getDatabaseConnection() {
return databaseConnection;
}

public void setDatabaseConnection(String databaseConnection) {
this.databaseConnection = databaseConnection;
}

public String getStartup() {
return startup;
}

public void setStartup(String startup) {
this.startup = startup;
}

}