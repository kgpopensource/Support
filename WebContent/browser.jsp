<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.io.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
   <%!String path="/home/krunal/programs/test1/test";%>
   <%  
   File folder = new File(path);
  
   if(request.getAttribute("path")!=null)
   {   
	   folder = new File(request.getAttribute("path").toString());
	   path=request.getAttribute("path").toString();
   }
   else
   {
	   path="/home/krunal/programs/test1/test";
   }
   
   File[] listOfFiles = folder.listFiles();
   
   for (int i = 0; i < listOfFiles.length; i++) 
   {
	   	if (listOfFiles[i].isDirectory()) 
	   	{   
	   		%>
		    <li>
		    <form id="<%= listOfFiles[i].getName() %>" method="post" action="filebrowser">
				<input type="hidden" name="hide"  value="<%=listOfFiles[i].getName() %>" /> 
  				<a href="#" onclick="document.getElementById('<%= listOfFiles[i].getName() %>').submit();"><% out.println(listOfFiles[i].getName()); %></a>

			</form> 
		    </li><br/><%
		} 
		else
		{				
			%>
		    <li>
		    <form id="<%= listOfFiles[i].getName() %>" method="post" action="download">
				<input type="hidden" name="hide1"  value="<%=request.getAttribute("path") %>" />
				<input type="hidden" name="hide2"  value="<%=listOfFiles[i].getName() %>" />
				 
  				<a href="#" onclick="document.getElementById('<%= listOfFiles[i].getName() %>').submit();"><% out.println(listOfFiles[i].getName()); %></a>

			</form> 
		    </li><br/><% 
		} 
   }
   %>   
   
</div>

<form id="asldajsldijads" action="upload" method="post" enctype="multipart/form-data">
<input type="hidden" name="hidn" value="<%=path %>" />
Upload file<input type="file" name="fileName" multiple></input>
<br/>
<input type="submit" value="Upload new File and Push">

</form>

<br/>

<form action="download" method="get">
Pull files
<br/>

  <input type="hidden" name="hid" value="kk" />
  <input type="submit" value="Pull and Download All files"> 

</form>  
<br/>

</body>
</html>