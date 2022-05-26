package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.bean.DocumentInfoBean;
import la.dao.DAOException;
import la.dao.DocumentInfoDAO;

@WebServlet("/DocumentInfoServlet")
public class DocumentInfoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String action = request.getParameter("action");
			DocumentInfoDAO dao = new DocumentInfoDAO();
			HttpSession session = request.getSession();
			
			if(action.equals("showInfo")) {
				int dID = Integer.parseInt(request.getParameter("key"));
				session.setAttribute("ManagementdID", dID);
				DocumentInfoBean list = dao.ShowAllInfo(dID);
				session.setAttribute("items", list);
				gotoPage(request,response, "/showEachDocument.jsp");
			}else {
				request.setAttribute("message", "正しく操作してください");
				gotoPage(request,response,"/documentError.jsp");
			}
		}catch(DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "入力した内容に不備があります3");
			gotoPage(request,response,"/documentError.jsp");
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
