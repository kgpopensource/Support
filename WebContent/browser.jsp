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
   
   <%  
   File folder = new File("/home/krunal/programs/test1/test");
  
   if(request.getAttribute("path")!=null)
   {   
	   folder = new File(request.getAttribute("path").toString());
   }
   
   File[] listOfFiles = folder.listFiles();
   
   for (int i = 0; i < listOfFiles.length; i++) 
   {
	   	if (listOfFiles[i].isDirectory()) 
	   	{   
	   		%>
		    <li>
		    <form id="<%= listOfFiles[i].getName() %>" method="post" action="filebrowser">
				<input type="hidden" name="hide" id="hide" value="<%=listOfFiles[i].getName() %>" /> 
  				<a href="#" onclick="document.getElementById('<%= listOfFiles[i].getName() %>').submit();"><% out.println(listOfFiles[i].getName()); %></a>

			</form> 
		    </li><br/><%
		} 
		else
		{	
			
			%>
		    <li>
		    <form id="<%= listOfFiles[i].getName() %>" method="post" action="filebrowser">
				<input type="hidden" name="hide" id="hide" value="<%=listOfFiles[i].getName() %>" /> 
  				<a href="#" onclick="document.getElementById('<%= listOfFiles[i].getName() %>').submit();"><% out.println(listOfFiles[i].getName()); %></a>

			</form> 
		    </li><br/><% 
		} 
   }
   %>   
   
</div>

</body>
</html>