package la.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.bean.CustomerBean;
import la.dao.CustomerChangeDAO;
import la.dao.DAOException;


@WebServlet("/CustomerChangeServlet")
public class CustomerChangeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String action = request.getParameter("action");
			CustomerChangeDAO dao = new CustomerChangeDAO();
			HttpSession session = request.getSession();
			
			if(action.equals("cIDcheck")) {
				int cID = Integer.parseInt(request.getParameter("cID"));
				session.setAttribute("ManagementcID", cID);
				int kakunin = dao.Kakunin(cID);
				if(cID != kakunin) {
					request.setAttribute("message", "存在しない会員IDです");
					gotoPage(request, response, "/customerChangeError.jsp");
				}else {
					CustomerBean list = dao.ShowCustomerInfo(cID);
					request.setAttribute("CustomerInfo", list);
					gotoPage(request, response, "/customerChangeForm.jsp");
				}
				
			}else if (action.equals("cChange")) {
				int cID = (Integer)session.getAttribute("ManagementcID");
				int kakunin = dao.Kakunin(cID);
				if(cID != kakunin) {
					request.setAttribute("message", "存在しない会員です");
					gotoPage(request,response,"/customerChangeError.jsp");
				}else {
					String cName = request.getParameter("cName");
					String cAddress = request.getParameter("cAddress");
					String cTell = request.getParameter("cTell");
					String cMail = request.getParameter("cMail");
					java.sql.Date cBday = Date.valueOf(request.getParameter("cBday"));
					
					int list1 = dao.Change(cID, cName, cAddress, cTell, cMail, cBday);
					CustomerBean bean = new CustomerBean(cID, cName,cAddress, cTell, cMail, cBday);
					
					request.setAttribute("change", bean);
					gotoPage(request, response, "/customerChange.jsp");
				}
			}else {
				request.setAttribute("message", "正しく操作してください");
				gotoPage(request, response, "/customerChangeError.jsp");
				
			}
			}catch(DAOException e) {
				e.printStackTrace();
				request.setAttribute("message", "正しく操作してください");
				gotoPage(request, response, "/customerChangeError.jsp");
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
