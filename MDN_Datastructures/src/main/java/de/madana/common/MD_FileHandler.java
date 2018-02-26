package de.madana.common;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class MD_FileHandler 
{
	  /**
     * Read the file and returns the byte array
     * @param file
     * @return the bytes of the file
     */
    private byte[] readFile(String file) {
        ByteArrayOutputStream bos = null;
        try {
            File f = new File(file);
            FileInputStream fis = new FileInputStream(f);
            byte[] buffer = new byte[1024];
            bos = new ByteArrayOutputStream();
            for (int len; (len = fis.read(buffer)) != -1;) {
                bos.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e2) {
            System.err.println(e2.getMessage());
        }
        return bos != null ? bos.toByteArray() : null;
    }
    public static void copyFile(File in, File out) throws IOException { 
        FileChannel inChannel = null; 
        FileChannel outChannel = null; 
        try { 
            inChannel = new FileInputStream(in).getChannel(); 
            outChannel = new FileOutputStream(out).getChannel(); 
            inChannel.transferTo(0, inChannel.size(), outChannel); 
        } catch (IOException e) { 
            throw e; 
        } finally { 
            try { 
                if (inChannel != null) 
                    inChannel.close(); 
                if (outChannel != null) 
                    outChannel.close(); 
            } catch (IOException e) {} 
        } 
    }
    public static void writeToFile(String path, byte[] key) throws IOException {
		File f = new File(path);
		f.getParentFile().mkdirs();

		FileOutputStream fos = new FileOutputStream(f);
		fos.write(key);
		fos.flush();
		fos.close();
	}
    public static void writeToFile(String path, String text) throws IOException
    {
    	BufferedWriter writer = null;
    	try
    	{
    	    writer = new BufferedWriter( new FileWriter( path));
    	    writer.write( text);

    	}
    	finally
    	{
    	    try
    	    {
    	        if ( writer != null)
    	        writer.close( );
    	    }
    	    catch ( IOException e)
    	    {
    	    }
    	}
    }
}
