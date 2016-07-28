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
	    String filepath = "/home/krunal/programs/test1/test/";
	    
	    if(select.equals("pull"))
	    {
	      	System.out.println("pull");
			Execute.pull();
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
			out.flush();
			out.close();
	     }
	     else if(select.equals("push"))
	     {
	    	System.out.println("push");
	    	Execute.push();
	    	request.setAttribute("response", "pushed the file");    
			request.getRequestDispatcher("/index.jsp").forward(request,response);
	     } 
	    
	   
	}
}
