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

public class FileUtil extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public FileUtil() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{			  
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String select=request.getParameter("sel");
		String filename=request.getParameter("hide");
	    System.out.println(select+" "+filename);
	    
	    if(select.equals("pull and download"))
	    {
	    	pull_download(request,response,filename);
	    	request.setAttribute("response", "file pulled ");
	    }
	    else if (select.equals("push"))
	    {
	    	request.setAttribute("response", "file pushed");
	    	push();
	    }
		
		request.getRequestDispatcher("/index.jsp").forward(request,response);
	}
	
	
	public void pull_download(HttpServletRequest request, HttpServletResponse response, String filename) throws ServletException, IOException
	{
		Execute.pull1();
		String filepath = "/home/krunal/programs/test1/test/";
		response.setContentType("text/html");  

		PrintWriter out = response.getWriter();  

		response.setContentType("APPLICATION/OCTET-STREAM");   
		response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");   

		FileInputStream fileInputStream = new FileInputStream(filepath+filename);  

		int i;   
		while ((i=fileInputStream.read()) != -1)
		{  
			out.write(i);   
		}

		fileInputStream.close();   
		out.close(); 		
	}
	
	public void push()
	{
		Execute.push1();
	}
}
