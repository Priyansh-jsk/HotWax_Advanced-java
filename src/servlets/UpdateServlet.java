package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Update;
import model.Party;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Party party=new Party();
		boolean status=false;
		party.setFirstName(request.getParameter("firstname"));
		party.setLastName(request.getParameter("lastname"));
		party.setAddress(request.getParameter("address"));
		party.setCity(request.getParameter("city"));
		party.setZip(request.getParameter("zip"));
		party.setState(request.getParameter("state"));
		party.setCountry(request.getParameter("country"));
		party.setPhone(request.getParameter("phone"));
	///(request.getParameter("partyId"));
		String id=request.getParameter("Update");
		System.out.println(id);
		Update update=new Update();
	status=	update.updateParty(party, id);
		if(status) {
			System.out.println("status updatye");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("profile.jsp");
		requestDispatcher.forward(request, response);
		}

	}

}
