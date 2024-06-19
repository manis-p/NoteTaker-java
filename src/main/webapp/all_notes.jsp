<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="org.hibernate.Session"%>
<%@page import="com.helper.Factory"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.Note"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Notes:Note Taker</title>
<link href="css/mani.css" rel="stylesheet" />
<%@ include file="alljs_css.jsp"%>
</head>
<body>

	<div class="container">
		<%@ include file="navbar.jsp"%>
		<br>
		<h1 class="text-upercase">All Notes:</h1>


		<div class="row">

			<div class="col-12">

				<%
				Session s = Factory.getFactory().openSession();

				Query query = s.createQuery("from Note");

				List<Note> list = query.list();

				for (Note p : list) {
				%>

				<div class="card mt-3 max-width:90px">
					<img class = "card-img-top m-4 mx-auto" style = "max-width:100px"  src = "image/writing.png" alt= "card image cap">
					<div class="card-body px-5">
						<h5 class="card-title"><%=p.getTittle() %></h5>
						<p class="card-text"><%=p.getContent() %></p>
						<div class = " container text-center mt-2">
						<a href="DeleteServlet?note_id=<%=p.getId() %>" class="btn btn-danger">Delete</a>
						<a href="edit.jsp?note_id=<%=p.getId() %>" class="btn btn-primary">update</a>
						</div>
					</div>
				</div>




				<%
				}

				s.close();
				%>


			</div>


		</div>






	</div>


</body>
</html>