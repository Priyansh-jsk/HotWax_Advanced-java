package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Display;
import model.Party;
import model.SearchOperation;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String value = request.getParameter("button");
		Display display = new Display();
		System.out.println(value);
		SearchOperation searchOperation = new SearchOperation();
		searchOperation.setFirstName(request.getParameter("firstname"));
		searchOperation.setLastName(request.getParameter("lastname"));
		ArrayList<Party> arraylist = display.display(searchOperation);

		RequestDispatcher rd = request.getRequestDispatcher("Display1.jsp");
		request.setAttribute("Arraylist", arraylist);
		rd.forward(request, response);
	}

}
