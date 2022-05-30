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

import la.bean.DocumentInfoBean;
import la.dao.DAOException;
import la.dao.DocumentChangeDelateDAO;

@WebServlet("/DocumentChangeDelateServlet")
public class DocumentChangeDelateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String action = request.getParameter("action");
			DocumentChangeDelateDAO dao = new DocumentChangeDelateDAO();
			HttpSession session = request.getSession(false);
			
            
			if (action.equals("delate")) {
				
				int dID = (Integer)session.getAttribute("ManagementdID");
                int list=dao.PreDelate(dID);
                
				if (list == 0) {
					request.setAttribute("message", "選択したデータは既に削除されています");
					gotoPage(request, response, "/documentSearchError.jsp");
				} else {
					int list1 = dao.Delate(dID);
					request.setAttribute("items", list1);
					gotoPage(request, response, "/documentDelate.jsp");
				}
				
				
			} else if (action.equals("preDelate")) {
				int dID = (Integer)session.getAttribute("ManagementdID");
				

				if (dID == 0) {
					request.setAttribute("message", "選択したデータは既に削除されています");
					gotoPage(request, response, "/documentSearchError.jsp");
				} else {
					gotoPage(request, response, "/documentPredelate.jsp");
				}
				
			}else if (action.equals("change")) {
				
				int dID = (Integer)session.getAttribute("ManagementdID");
				if (dID == 0) {
					request.setAttribute("message", "選択したデータは既に削除されています");
					gotoPage(request, response, "/documentSearchError.jsp");
				} else {
				long isbn =Long.parseLong(request.getParameter("isbn"));
				int cCode = Integer.parseInt(request.getParameter("cCode"));
				String dName = request.getParameter("dName");
				String aName = request.getParameter("aName");
				String pName = request.getParameter("pName");
				java.sql.Date pDate = Date.valueOf(request.getParameter("pDate"));
				
				int list1 = dao.Change(dID, isbn, cCode, dName, aName, pName, pDate);
				DocumentInfoBean bean = new DocumentInfoBean(dID, isbn, cCode, dName, aName, pName, pDate);
				
				request.setAttribute("change", bean);
				gotoPage(request, response, "/documentChange.jsp");
			    
				}
				
			} else {
				request.setAttribute("message", "正しく操作してください");
				gotoPage(request, response, "/documentSearchError.jsp");
			}
			
			
		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "正しく操作してください");
			gotoPage(request, response, "/documentSearchError.jsp");
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
