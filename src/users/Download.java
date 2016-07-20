package users;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Download extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public Download() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{			  
		Execute.pull();
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		String filename = "kkj";   
		String filepath = "/home/krunal/programs/test1/test/";   
		response.setContentType("APPLICATION/OCTET-STREAM");   
		response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");   

		FileInputStream fileInputStream = new FileInputStream(filepath + filename);  

		int i;   
		while ((i=fileInputStream.read()) != -1)
		{  
			out.write(i);   
		}   
		fileInputStream.close();   
		out.close();   
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	}

}
