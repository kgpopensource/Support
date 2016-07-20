package users;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import org.apache.tomcat.jni.File;

public class Execute 
{
    public Execute()
    {
    	
    }
    
    public static void push()
    {
    	try 
    	{
			//Process p = new ProcessBuilder().start(); new String[] { "/bin/bash", "-c", ""}

    		Runtime runtime = Runtime.getRuntime();
    		Process process = runtime.exec("/home/krunal/workspace/Support/src/users/push.sh");
    		int exitValue = process.waitFor();
    		System.out.println("exit value: " + exitValue);
    		BufferedReader buf = new BufferedReader(new InputStreamReader(process.getInputStream()));
    		String line = "";
    		while ((line = buf.readLine()) != null) 
    		{
    			System.out.println("exec response: " + line);               
    		}
            
		}
    	catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	catch (IOException e)
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
    public static void pull()
    {
    	try 
    	{
    		Runtime runtime = Runtime.getRuntime();
    		Process process = runtime.exec("/home/krunal/workspace/Support/src/users/pull.sh");
    		int exitValue = process.waitFor();
    		System.out.println("exit value: " + exitValue);
    		BufferedReader buf = new BufferedReader(new InputStreamReader(process.getInputStream()));
    		String line = "";
    		while ((line = buf.readLine()) != null) 
    		{
    			System.out.println("exec response: " + line);               
    		}
			
		}
    	catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	catch (IOException e)
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
}
