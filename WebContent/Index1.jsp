<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
   <ul>
   <%! String arr[]=new String[10];
   File folder = new File("data/");
   File[] listOfFiles = folder.listFiles();   
   %>
   <%
   	for (int i = 0; i < listOfFiles.length; i++) 
   	{
   		if (listOfFiles[i].isFile()) 
   		{
   		    %> <li> <% out.println(listOfFiles[i]); %> </li> <% 
   		} 
   		else if (listOfFiles[i].isDirectory())
   		{
   			//System.out.println("Directory " + listOfFiles[i].getName());
   		}
   	}
   %>
      
   </ul>
</div>>
</body>
</html>