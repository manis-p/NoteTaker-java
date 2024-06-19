package com.servlets;
import com.entity.Note;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.helper.Factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.helper.Factory;
import com.entity.Note;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
      public DeleteServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			int noteId = Integer.parseInt(request.getParameter("note_id").trim());
			Session s = Factory.getFactory().openSession();
			Transaction tx = s.beginTransaction();
		Note note	= (Note)s.get(Note.class,noteId);
		s.delete(note);
		tx.commit();
			s.close();
			response.sendRedirect("all_notes.jsp");
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}

	
	

}
