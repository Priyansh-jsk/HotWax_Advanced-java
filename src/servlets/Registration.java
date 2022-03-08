package servlets;

import dao.RegistrationDao;

import model.Login;
import model.Party;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registration")
public class Registration extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Registration Page.
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String address = req.getParameter("address");
		String city = req.getParameter("city");
		String zip = req.getParameter("zip");
		String state = req.getParameter("state");
		String country = req.getParameter("country");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		Login login = new Login();
		Party party = new Party();

		party.setFirstName(firstname);
		party.setLastName(lastname);
		party.setAddress(address);
		party.setCity(city);
		party.setZip(zip);
		party.setState(state);
		party.setCountry(country);
		party.setPhone(phone);

		login.setEmail(email);
		login.setPassword(password);

		boolean success = false;
		try {
			success = RegistrationDao.saveUser(party, login);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}