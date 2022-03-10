package servlets;

import dao.LoginDao;

import model.Login;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.istack.internal.logging.Logger;

import java.io.IOException;
import java.util.logging.LogManager;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final Class<LoginServlet> LoginServlet = null;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		Login login = new Login();
		login.setEmail(email);
		login.setPassword(password);

		Boolean success = LoginDao.validateLogin(login);

		if (success) {

			HttpSession httpSession = req.getSession(true);
			httpSession.setAttribute("email", login.getEmail());
			httpSession.setAttribute("password", login.getPassword());

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("profile.jsp");
			requestDispatcher.forward(req, resp);
		} else {

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
			req.setAttribute("Msg", "Try again");
			requestDispatcher.forward(req, resp);
		}
	}

}
