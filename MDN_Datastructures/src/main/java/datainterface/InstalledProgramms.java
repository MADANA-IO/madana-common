package datainterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InstalledProgramms 
{
	public static void main(String[] args) throws IOException {

		List <MDN_DataObject> oObjs = new ArrayList<MDN_DataObject>();
		readValues(oObjs, "DisplayName", true);
		readValues(oObjs, "DisplayVersion", false);
		readValues(oObjs, "Publisher", false);
		readValues(oObjs, "InstallDate", false);
		System.out.println();

	}

	private static void readValues( List <MDN_DataObject> oObjs, String strKey, boolean bInit) throws IOException
	{
		String command = "powershell.exe  Get-ItemProperty HKLM:\\Software\\Wow6432Node\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\* | Select-Object "+strKey;
		// Executing the command
		Process powerShellProcess = Runtime.getRuntime().exec(command);
		// Getting the results
		powerShellProcess.getOutputStream().close();
		String line;
		System.out.println("Standard Output:");
		int i= 0;
		BufferedReader stdout = new BufferedReader(new InputStreamReader(
				powerShellProcess.getInputStream()));
		while ((line = stdout.readLine()) != null)
		{
			if(bInit)
				oObjs.add(new MDN_DataObject());
			oObjs.get(i).addEntry(strKey, line);
			i++;
		}
		stdout.close();
		System.out.println("Standard Error:");
		BufferedReader stderr = new BufferedReader(new InputStreamReader(
				powerShellProcess.getErrorStream()));
		while ((line = stderr.readLine()) != null) {
			System.out.println(line);
		}
		stderr.close();
		System.out.println("Done");
	}
}
