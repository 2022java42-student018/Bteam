package la.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.CustomerBean;
import la.dao.CustomerAddDAO;
import la.dao.DAOException;


@WebServlet("/CustomerAddServlet")
public class CustomerAddServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("UTF-8");
			String action = request.getParameter("action");
			CustomerAddDAO dao = new CustomerAddDAO();
			
			if(action.equals("add")) {
				String cName = request.getParameter("cName");
				String cAddress = request.getParameter("cAddress");
				String cTell = request.getParameter("cTell");
				String cMail = request.getParameter("cMail");
				java.sql.Date cBday = Date.valueOf(request.getParameter("cBday"));
				
				CustomerBean list = dao.Add(cName, cAddress, cTell, cMail, cBday);
				
				request.setAttribute("AddCustomer",list);
				gotoPage(request,response,"/customerAdd.jsp");
				
			}else {
				request.setAttribute("message","入力した内容に不備があります");
				gotoPage(request, response, "/customerAddError.jsp");
			}
		}catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "入力した内容に不備があります");
			gotoPage(request, response, "/customerAddError.jsp");
		}
	}
	
	
	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
