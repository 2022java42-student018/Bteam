package la.servlet;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.bean.DocumentBean;
import la.dao.DAOException;
import la.dao.DocumentDAO;

@WebServlet("/DocumentServlet")
public class DocumentServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String action = request.getParameter("action");
			DocumentDAO dao = new DocumentDAO();
			
			HttpSession session = request.getSession();
			
			if(action.equals("dIDSearch")) {
			  String dID1 =(request.getParameter("dID"));
			  Pattern pattern = Pattern.compile("^[0-9]$");
			  Matcher matcher = pattern.matcher(dID1);
			  if(matcher.find() == true) {
				 int dID=Integer.parseInt(dID1);
			   List<DocumentBean> list= dao.dIDSearch(dID);	
			   session.setAttribute("items", list);
			   gotoPage(request,response,"/showAllDocument.jsp");
			  }else {
				  request.setAttribute("message", "入力した内容に不備があります");
					gotoPage(request,response,"/documentError.jsp");
			  }
			   
			}else if(action.equals("dNameSearch")) {
				session.setAttribute("dName", null);
				session.setAttribute("aName", null);
				String dName= request.getParameter("dName");
				if(dName.length() != 0) {
				session.setAttribute("dName", dName);
				List<DocumentBean> list = dao.dNameSearch(dName);
				session.setAttribute("items", list);
				gotoPage(request,response,"/showAllDocument.jsp");
				}else if(dName.length() == 0) {
					request.setAttribute("message", "正しく操作してください");
					gotoPage(request,response,"/documentError.jsp");
				}
				
			}else if(action.equals("aNameSearch")) {
				session.setAttribute("dName", null);
				session.setAttribute("aName", null);
				String aName=request.getParameter("aName");
				if(aName.length() !=0) {
				session.setAttribute("aName", aName);
				List<DocumentBean> list = dao.aNameSearch(aName);
				session.setAttribute("items", list);
				gotoPage(request,response,"/showAllDocument.jsp");
				}else if(aName.length() ==0) {
					request.setAttribute("message", "正しく操作してください");
					gotoPage(request,response,"/documentError.jsp");
				}
			}else if(action.equals("DscSort")) {
				
				if(session.getAttribute("dName") != null) {
					 String lesession = (String) session.getAttribute("dName");
					 List<DocumentBean> list = dao.dNameSearchDESC(lesession);
					 session.setAttribute("items", list);
					 gotoPage(request,response,"/showAllDocument.jsp");
					   
				}else if(session.getAttribute("aName") != null) {
					 String lesession = (String) session.getAttribute("aName");
					 List<DocumentBean> list = dao.aNameSearchDESC(lesession);
					 session.setAttribute("items", list);
					 gotoPage(request,response,"/showAllDocument.jsp");
					   
					
				}
			
			}else if(action.equals("AscSort")) {
				
				if(session.getAttribute("dName") != null) {
					 String lesession = (String) session.getAttribute("dName");
					 List<DocumentBean> list = dao.dNameSearchASC(lesession);
					 session.setAttribute("items", list);
					 gotoPage(request,response,"/showAllDocument.jsp");
					   
				}else if(session.getAttribute("aName") != null){
					 String lesession = (String) session.getAttribute("aName");
					 List<DocumentBean> list = dao.aNameSearchASC(lesession);
					 session.setAttribute("items", list);
					 gotoPage(request,response,"/showAllDocument.jsp");
				}
			}
			else {
				request.setAttribute("message", "正しく操作してください");
				gotoPage(request,response,"/documentError.jsp");
				
			}
			
		}catch(DAOException e) {
				e.printStackTrace();
				request.setAttribute("message", "入力した内容に不備があります");
				gotoPage(request,response,"/documentError.jsp");
			}
			
	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

}
