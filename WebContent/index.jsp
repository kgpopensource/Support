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
			%>
		    <li> <% out.println(listOfFiles[i].getName()); %>
		    <form action="fileutil" method="post" >  
		    <input type="hidden" name="hide" id="hide" value="<%=listOfFiles[i].getName() %>" /> 
			<select name="sel">
  				<option value="pull & Download">pull</option>
  				<option value="push">push</option>
			</select>
			<input type="submit" value="submit"/>
			</form>
			</li><% 
		} 
   }
   %>   
   <div id="result">
    <pre>
        ${requestScope.response}
    </pre>
   </div>
   
</div>
<br/>
<form action="" method="post" enctype="multipart/form-data">
Upload file<input type="file" name="fileName" multiple></input>
<br/>
<input type="submit" value="Upload new File and Push">
</form>
<br/>
<form action="download" method="get">
Pull files
<br/>
  <input type="submit" value="Pull and Download All files"> 
</form>  
<br/>

<!--  <form action="" method="post" enctype="multipart/form-data">
Push Files
<br>
<input type="submit" value="Upload and Push all files">
</form>   -->
<br/><br/><br/>

<textarea id="gitlog" placeholder="placeholder" onkeyup="resizeTextarea('InputTextArea')" style="width: 300px; height: 150px;"></textarea>
</body>
</html>