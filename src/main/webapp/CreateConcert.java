package servlet;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jpa.EntityManagerHelper;
import jpa.EventTest;

@WebServlet(name="createConcert",urlPatterns={"/CreateConcert"})
public class CreateConcert extends HttpServlet {
	 private static final long serialVersionUID = 1L;

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	EntityManager manager= EntityManagerHelper.getEntityManager();
			EntityTransaction tx = manager.getTransaction();
			tx.begin();
	        String artist = request.getParameter("artist");
	        String date = request.getParameter("date");
	        String location = request.getParameter("location");
	        String description = request.getParameter("description");
	        int places = Integer.parseInt(request.getParameter("places"));
	        
	        Concert concert = new Concert(artist, date, location, description, places);
	        ConcertDAO concertDAO = new ConcertDAO();
	        manager.persist(concertDAO.save(concert));
	        tx.commit();
	        response.sendRedirect("success.html");
	    }
}
