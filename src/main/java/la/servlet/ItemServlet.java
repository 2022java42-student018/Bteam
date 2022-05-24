package la.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.ItemBean;
import la.dao.DAOException;
import la.dao.ItemDAO;

@WebServlet("/ItemServlet")
public class ItemServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String action = request.getParameter("action");
			ItemDAO dao = new ItemDAO();
			
			if(action.equals("dIDSearch")) {
			  int dID =Integer.parseInt(request.getParameter("dID"));
			   List<ItemBean> list= dao.dIDSearch(dID);	
			   request.setAttribute("items", list);
			   gotoPage(request,response,"/showAllDocument.jsp");
			   
			}else if(action.equals("dIDSearchDESC")) {
				int dID =Integer.parseInt(request.getParameter("dID"));
				List<ItemBean>list = dao.dIDSearchDESC(dID);
				request.setAttribute("items", list);
				gotoPage(request,response,"/showAllDocument.jsp");
				
			}else if(action.equals("dNameSearch")) {
				String dName= request.getParameter("dName");
				List<ItemBean> list = dao.dNameSearch(dName);
				request.setAttribute("items", list);
				gotoPage(request,response,"/showAllDocument.jsp");
				
			}else if(action.equals("aNameSearch")) {
				String aName=request.getParameter("aName");
				List<ItemBean> list = dao.aNameSearch(aName);
				request.setAttribute("items", list);
				gotoPage(request,response,"/showAllDocument.jsp");
			}else {
				request.setAttribute("message", "正しく操作してください");
				gotoPage(request,response,"/error.jsp");
				
			}
		}catch(DAOException e) {
				e.printStackTrace();
				request.setAttribute("message", "入力した内容に不備があります");
				gotoPage(request,response,"/error.jsp");
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
