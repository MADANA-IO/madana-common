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
package datainterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class InstalledProgramms.
 */
public class InstalledProgramms 
{
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {

		List <MDN_DataObject> oObjs = new ArrayList<MDN_DataObject>();
		readValues(oObjs, "DisplayName", true);
		readValues(oObjs, "DisplayVersion", false);
		readValues(oObjs, "Publisher", false);
		readValues(oObjs, "InstallDate", false);
		System.out.println();

	}

	/**
	 * Read values.
	 *
	 * @param oObjs the o objs
	 * @param strKey the str key
	 * @param bInit the b init
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
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
