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
package de.madana.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;



// TODO: Auto-generated Javadoc
/**
 * The Class DC_A_SocketCommunication.
 */
public abstract class DC_A_SocketCommunication implements Runnable
{
	
	/** The o socket. */
	protected Socket oSocket;
	
	/** The out. */
	protected PrintWriter out;
	
	/** The in. */
	protected BufferedReader in;
	
	/**
	 * Instantiates a new d C A socket communication.
	 *
	 * @param oDestSocket the o dest socket
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public DC_A_SocketCommunication(Socket oDestSocket) throws IOException
	{
		oSocket = oDestSocket;
		out = new PrintWriter(oSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(oSocket.getInputStream()));

	}
	
	/**
	 * Gets the remote address.
	 *
	 * @return the remote address
	 */
	public String getRemoteAddress() 
	{
		return oSocket.getRemoteSocketAddress().toString();
	}
	
	/**
	 * Gets the command.
	 *
	 * @param strMessage the str message
	 * @return the command
	 */
	protected String getCommand(String strMessage)
	{
		return strMessage.substring(0, strMessage.indexOf("|"));
	}
	
	/**
	 * Gets the command text.
	 *
	 * @param strMessage the str message
	 * @return the command text
	 */
	protected String getCommandText(String strMessage)
	{
		return strMessage.substring(strMessage.indexOf("|")+1, strMessage.length());
	}
	
	/**
	 * Send command.
	 *
	 * @param strCommand the str command
	 * @param strParams the str params
	 * @return the string
	 * @throws Exception the exception
	 */
	protected synchronized String sendCommand(String strCommand, String strParams) throws Exception
	{

		out.println(strCommand+"|"+strParams);
		out.flush();
		String strOutput=in.readLine();
		if(strOutput.startsWith("ACK|"))
		{
			return strOutput;
		}
		if(strOutput.startsWith("NACK|"))
		{
			throw new Exception(strOutput);

		}


		return null;
	}

	/**
	 * Gets the action.
	 *
	 * @param strInput the str input
	 * @return the action
	 */
	protected  String getAction(String strInput)
	{
		return "Unbekannter Befehl";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run()
	{
		Thread.currentThread().setName(oSocket.getRemoteSocketAddress().toString());
		System.out.println("SocketCommuncation für " + Thread.currentThread().getName() + " erfolgreich initialisiert");
		String strInput = null;
		String strOutput = null;

		while(oSocket.isConnected())
		{
			try
			{
				if(in.ready())
				{
					in.mark(2000);
					strInput=in.readLine();	
					if(strInput.startsWith("ACK")|strInput.startsWith("NACK"))
					{
						in.reset();

					}
					else
					{
						System.out.println(Thread.currentThread().getName() + ": Eingabe: " + strInput);

						strOutput=getAction(strInput);
						if(strOutput!=null)
						{
							System.out.println(Thread.currentThread().getName() + ": Ausgabe: " +strOutput);

							out.println(strOutput);
							out.flush();
						}
					}
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			catch (IOException ioEx)
			{
				System.out.println( Thread.currentThread().getName() +" "+ ioEx.getMessage());
				setSessionCancelled();
			}	
		}
		setSessionCancelled();

	}
	
	/**
	 * Sets the session cancelled.
	 */
	protected  void setSessionCancelled() 
	{
		System.out.println(Thread.currentThread().getName() + " beendet!");


	}

}
