package de.digiclothes.server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import de.digiclothes.server.socketimpl.DC_ServerSocket;
import de.madana.common.database.DC_SQLConnector;

public class ServerSocketTests 
{
	static DC_SQLConnector oDatabaseConnector;
	static ExecutorService executor ;
	public static void main(String[] args) 
	{
		System.out.println("Initialisiere System...");
		executor=Executors.newCachedThreadPool();
		System.out.println("Initialisiere Datenbankverbindung...");
		oDatabaseConnector = new DC_SQLConnector();
		oDatabaseConnector.connect(false);
		System.out.println("Initialisiere SocketServer...");
		
		DC_ServerSocket oSocket = new DC_ServerSocket(13013);
		Thread oServerThread = new Thread(oSocket);
		oServerThread.setName("SOCKETSERVER");
		Thread SessionThread = new Thread(new DC_ServerSessionManager());
		SessionThread.setName("SESSIONMANAGER");
		executor.execute(SessionThread);
		executor.execute(oServerThread);
		while(oServerThread.isAlive())
		{
			
		}
	}

}
