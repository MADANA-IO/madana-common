package de.digiclothes.server.socketimpl;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author Jean
 *
 */
public class DC_ServerSocket implements Runnable
{
	public static String strClientVersion = "0.9a";
	public static String strUpdateUrl = "http://update.digiclothes.de/";

	ExecutorService executor = Executors.newCachedThreadPool();
	ServerSocket serverSocket = null;
	/**
	 * Klasse zur Erstellung einen neuen Sockets, der benutzt wird um ClientVerbindungen anzunehmen
	 * @param iPort - der Port auf dem der Socket geöffnet werden soll
	 * @author Jean
	 */
	public DC_ServerSocket(int iPort)
	{
		System.out.println("Running in cmdmode");	
		try
		{
			serverSocket = new ServerSocket(iPort);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("Binden an Port "+iPort+" schlug fehl: " + e.getMessage());
			System.exit(-1);
		}	
	}

	@Override
	public void run() 
	{
		System.out.println ("ServerSocket - accepting:"+serverSocket.getLocalPort());
		
		/**
		 * Endlosschleife
		 */
		while (true)
		{
				
			try
			{

				Socket clientSocket = serverSocket.accept();

				//Wenn die Anfrage da ist, dann wird ein Thread gestartet, der 
				//die weitere Verarbeitung �bernimmt.
				try
				{
					DC_ClientHandler oNewClientHandler =new DC_ClientHandler(clientSocket);
					executor.execute(oNewClientHandler);			
				}
				catch(Exception e)
				{
					System.out.println (e.toString());
					
				}
				System.out.println ("ServerSocket - Thread started, next client please...");
			}
			catch (IOException e)
			{
				System.out.println (e.toString());
				try 
				{
					Thread.sleep(10000);
				} catch (InterruptedException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					serverSocket.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}

		}
		
	}
} 