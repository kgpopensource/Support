<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload</title>
</head>
<body>

<div>
   
   <%  
   File folder = new File("/home/krunal/programs/test1/test");
   File[] listOfFiles = folder.listFiles();
   
   for (int i = 0; i < listOfFiles.length; i++) 
   {
	   	if (listOfFiles[i].isDirectory()) 
	   	{   
		} 
		else
		{		
			%><div> <li> <% out.println(listOfFiles[i].getName()); %> </li> <button type="button">pull</button> 
			<button type="button">push</button> </div><% 
		} 
   }
   %>   
   
</div>
<form action="upload" method="post" enctype="multipart/form-data">
Select File to Upload:<input type="file" name="fileName" multiple>
<br>
<input type="submit" value="Upload new File and Push">
</form>

<form action="download" method="get" ">
<br>
  <input type="submit" value="Pull all files"> 
</form>  

</body>
</html>