package users;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.util.URI;
import com.sun.xml.internal.ws.Closeable;

public class Download extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public Download() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{			  
		/*String filepath = "/home/krunal/programs/test1/test/";
		File folder=new File(filepath);
		String zipfile="/home/krunal/programs/test1/test/allfiles.zip";
		//Execute.pull();
		File files[]=folder.listFiles();
		
		try 
		{
			FileOutputStream fos = new FileOutputStream(zipfile);
			ZipOutputStream zos = new ZipOutputStream(fos);
			
			for(File f:files)
			{
				if(f.isDirectory())
				{}
				else
				{
					addToZipFile(f,f.getName(), zos);
				}
			}
			zos.close();
			fos.close();

		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}	
				
		response.setContentType("text/html");  

		PrintWriter out = response.getWriter();  

		response.setContentType("APPLICATION/OCTET-STREAM");   
		response.setHeader("Content-Disposition","attachment; filename=\"" + "allfiles.zip" + "\"");   

		FileInputStream fileInputStream = new FileInputStream(zipfile);  

		int i;   
		while ((i=fileInputStream.read()) != -1)
		{  
			out.write(i);   
		}

		fileInputStream.close();   
		out.close();
		
		File zi=new File("/home/krunal/programs/test1/test/allfiles.zip");
		
		if(zi.delete())
		{
			System.out.println(zi.getName() + " is deleted!");
		}else{
			System.out.println("Delete operation is failed.");
		}*/
        System.out.println(request.getParameter("hid"));		
	}
	
	public static void addToZipFile(File f,String fileName, ZipOutputStream zos) throws FileNotFoundException, IOException 
	{

		System.out.println("Writing '" + fileName + "' to zip file");

		FileInputStream fis = new FileInputStream(f);
		ZipEntry zipEntry = new ZipEntry(fileName);
		zos.putNextEntry(zipEntry);

		byte[] bytes = new byte[1024];
		int length;
		
		while ((length = fis.read(bytes)) >= 0) 
		{
			zos.write(bytes, 0, length);
		}

		zos.closeEntry();
		fis.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String filepath=request.getParameter("hide1");
	    String filename = request.getParameter("hide2");
	    
		response.setContentType("text/html");  

		PrintWriter out = response.getWriter();  

		response.setContentType("APPLICATION/OCTET-STREAM");   
		response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");   
		
		FileInputStream fileInputStream = new FileInputStream(filepath+"/"+filename);  

		int i;   
		while ((i=fileInputStream.read()) != -1)
		{  
			out.write(i);   
		}

		fileInputStream.close();
		
		out.flush();
		out.close();
	}
}
