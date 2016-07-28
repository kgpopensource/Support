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

public class FileBrowser extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public FileBrowser() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{			  
	   
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String filename=request.getParameter("hide");
	    String filepath = "/home/krunal/programs/test1/test/"+filename;
	    //System.out.println(filepath);
	    request.setAttribute("path", filepath);
	    request.getRequestDispatcher("/browser.jsp").forward(request,response);
	    
	}
}
