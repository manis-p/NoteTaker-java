<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import = "com.entity.Note" %>
   <%@page import = "com.helper.*" %>
   <%@page import = "org.hibernate.*" %>
<!DOCTYPE html>
<html>
<head>
<link href="css/mani.css" rel="stylesheet" />
<meta charset="ISO-8859-1">
<title> this is edit page</title>
    
<%@ include file="alljs_css.jsp"%>
</head>
<body>

<div class="container">

		<%@ include file="navbar.jsp"%>
      
     <h1>edit your note</h1>
        <br>
	  <% 
	  int noteId = Integer.parseInt(request.getParameter("note_id").trim());
	  Session s = Factory.getFactory().openSession();
		
	    Note note	= (Note)s.get(Note.class,noteId);
	    
	    
	  
	  %>
	  
	  
	  
	  <form action="UpdateServlet" method = "post">
		<input value ="<%=note.getId()%>" name = "noteId" type = "hidder"/>
			<div class="form-group">
				<label for="title">Note title</label>
				 <input
				 name = "title"
			       required type="text" 
			       class="form-control"
			        id="title"
					aria-describedby="emailHelp" 
					placeholder="Enter here"
					value  = "<%=note.getTittle() %>"
					/> 
					
			</div>
			
			<div class="form-group">
				<label for="content">Note content</label> 
				<textarea
				name = "content"
				required id = "content"
				 placeholder="Enter your content here"
				 class = "form-control"
				 style="height:300px;"><%=note.getContent() %>
				 </textarea>
			</div>
			
			<div class ="container text-center">
			<button type="submit" class="btn btn-success">save your note</button>
			</div>
		</form>
	  
	

	</div>



</body>
</html>