package la.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.DocumentInfoBean;
import la.dao.DAOException;
import la.dao.DocumentAddDAO;


@WebServlet("/DocumentAddServlet")
public class DocumentAddServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("UTF-8");
			String action = request.getParameter("action");
			DocumentAddDAO dao = new DocumentAddDAO();
			
			
			if(action.equals("add")) {
				int isbn =Integer.parseInt(request.getParameter("isbn"));
				int cCode = Integer.parseInt(request.getParameter("cCode"));
				String dName = request.getParameter("dName");
				String aName = request.getParameter("aName");
				String pName = request.getParameter("pName");
				java.sql.Date pDate = Date.valueOf(request.getParameter("pDate"));
		
				
				DocumentInfoBean list1 = dao.Add(isbn, cCode, dName, aName, pName, pDate);
				int count1 = dao.CountDocument(dName);
				if(count1 >1) {
					request.setAttribute("count", count1);
					request.setAttribute("AddDocument", list1);
					gotoPage(request,response,"/documentPlusAdd.jsp");
					
				}else {
					request.setAttribute("AddDocument", list1);
					gotoPage(request,response,"/documentAdd.jsp");
				}
					
				
			}
		}catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "入力した内容に不備があります");
			gotoPage(request, response, "/documentAddError.jsp");
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
