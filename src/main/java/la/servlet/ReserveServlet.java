package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.dao.DAOException;
import la.dao.ReserveDAO;

@WebServlet("/ReserveServlet")
public class ReserveServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String action = request.getParameter("action");
            HttpSession session = request.getSession();
            
			if (action.equals("reserve")) {
				ReserveDAO dao = new ReserveDAO();
				int dID = Integer.parseInt(request.getParameter(""));
				if (dao.Confirmation(dID)) {
					session.setAttribute("dID",dID);
					gotoPage(request, response, "/resevehtml");
			} else {
					request.setAttribute("message", "既に予約されています");
					gotoPage(request, response, "/errorTOP.jsp");
			}
			  }
		    } catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "既に予約されています");
			gotoPage(request, response, "/errorTOP.jsp");
		}
	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}