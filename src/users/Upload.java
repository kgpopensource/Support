package users;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.*;
 
import javax.servlet.ServletConfig;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;

public class Upload extends HttpServlet 
{
	private boolean isMultipart;
	   private String filePath;
	   private int maxFileSize = 5000 * 1024;
	   private int maxMemSize = 1024 * 1024;
	   private File file ;
	   
	   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException 
	   {
		  
	      isMultipart = ServletFileUpload.isMultipartContent(request);
	       
	      response.setContentType("text/html");
	      java.io.PrintWriter out = response.getWriter( );
	      
	      if( !isMultipart )
	      {
	         out.println("<html>");
	         out.println("<head>");
	         out.println("<title>Servlet upload</title>");  
	         out.println("</head>");
	         out.println("<body>");
	         out.println("<p>No file uploaded</p>"); 
	         out.println("</body>");
	         out.println("</html>");
	         return;
	      }
	      DiskFileItemFactory factory = new DiskFileItemFactory();
	      // maximum size that will be stored in memory
	      factory.setSizeThreshold(maxMemSize);
	      // Location to save data that is larger than maxMemSize.
	      factory.setRepository(new File("/Home/data/"));

	      // Create a new file upload handler
	      ServletFileUpload upload = new ServletFileUpload(factory);
	      // maximum file size to be uploaded.

	      try
	      { 
	      // Parse the request to get file items.
	      List fileItems = upload.parseRequest(request);
		
	      // Process the uploaded file items
	      Iterator i = fileItems.iterator();
 
	      while ( i.hasNext () ) 
	      {
	    	  FileItem fi = (FileItem)i.next();
	    	  if ( !fi.isFormField () )	
	    	  {
	    		  // Get the uploaded file parameters
	    		  String fieldName = fi.getFieldName();
	    		  String fileName = fi.getName();
	    		  String contentType = fi.getContentType();
	    		  boolean isInMemory = fi.isInMemory();
	    		  long sizeInBytes = fi.getSize();
	    		  // Write the file
	    		  if( fileName.lastIndexOf("\\") >= 0 )
	    		  {
	    			  file = new File( filePath + 
	    					  fileName.substring( fileName.lastIndexOf("\\"))) ;
	    		  }
	    		  else
	    		  {
	    			  file = new File( filePath + 
	    					  fileName.substring(fileName.lastIndexOf("\\")+1)) ;
	    		  }
	    		  fi.write( file );
	    	  }
	    	  else
	    	  {
	    	      if (fi.getFieldName().equals("hidn") )
	    	      {
	    	          String value = fi.getString();
	    	          filePath=value;

	    	 	      filePath=filePath + "/";
	    	 	      
	    	 	      System.out.println(filePath);
	    	           // Do something with the value
	    	      }
	    	  }
	      }
	          
	      Execute.push();
	      
	      }
	      catch(Exception ex) 
	      {
	    	  System.out.println(ex);
	      }
	       
		  request.getRequestDispatcher("/browser.jsp").forward(request,response);	  
	   }
	   
	   public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, java.io.IOException 
	   {
	        
	        throw new ServletException("GET method used with " +
	                getClass( ).getName( )+": POST method required.");
	   } 
}
