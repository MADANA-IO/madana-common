package de.madana.connector.system;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fazecast.jSerialComm.SerialPort;

/**
 * Hilfsklasse um Befehle an die serielle Schnittstelle zu schicken
 * @author Jean
 *
 */
public class DC_SerialPortHandler 
{


	public static List<String> getPortNames()
	{
		List<String> oPortNames = new ArrayList<String>();
		SerialPort[] oPorts = SerialPort.getCommPorts();
		for(int i=0; i < oPorts.length;i++)
		{
			SerialPort oCurrentPort = oPorts[i];
			oPortNames.add(oCurrentPort.getSystemPortName());
		}
		return oPortNames;
	}

	public static byte[] sendCommand(SerialPort oAntenna, byte[] bBuf) throws InterruptedException, IOException
	{
//		oAntenna.setComPortParameters(115200, 8, 1, 0);
		oAntenna.writeBytes(bBuf, bBuf.length);
		oAntenna.getOutputStream().flush();
		System.out.println("Befehl erfolgreich an "+oAntenna.getSystemPortName()+ " gesendet");

		while(oAntenna.bytesAvailable()==0)
		{
			Thread.sleep(60);
		}
		
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		byte[] data = new byte[oAntenna.bytesAvailable()];
		int iRead = oAntenna.getInputStream().read(data, 0, data.length);
		buffer.write(data, 0, iRead);

		buffer.flush();

		return buffer.toByteArray();
	}
}
