package com.servlets;

import java.io.IOException;
import java.util.Date;
import com.entity.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Note;
import com.helper.Factory;


public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateServlet() {
        super();
        
    }

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int noteId = Integer.parseInt(request.getParameter("noteId").trim());	
			Session s = Factory.getFactory().openSession();
			Transaction tx = s.beginTransaction();
			
	   Note	note=s.get(Note.class, noteId);
	   note.setTittle(title);
	   note.setContent(content);
	   note.setAddDare(new Date());
			
			response.sendRedirect("all_notes.jsp");
			tx.commit();
			
			
			s.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
