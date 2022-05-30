package la.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.bean.CustomerBean;
import la.bean.DocumentInfoBean;
import la.bean.historyBean;
import la.dao.CustomerDAO;
import la.dao.DAOException;


@WebServlet("/CustomersearchServlet")

public class CustomersearchServlet extends HttpServlet {

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
		 CustomerDAO dao = new CustomerDAO();
		 
		HttpSession session = request.getSession(); 
         
		if(action.equals("eMailSearch")) {
			
			
			 if (session != null) { // セッションオブジェクトなし
			 session.removeAttribute("Customerdata");
			 }
           String eMail =request.getParameter("email");
         List<CustomerBean> list= dao.emailSearch(eMail);	
         request.setAttribute("customer", list);
         gotoPage(request,response,"/showcustomer.jsp");//showcustomerﾍ
         
     
         } else if (action.equals("renddoc")) {
        	 
             int cID = Integer.parseInt(request.getParameter("cID"));
             List<DocumentInfoBean> list = dao.renddoc(cID);
              
             request.setAttribute("document",list);

             gotoPage(request, response, "/lend_doc.jsp");// lend_doc.jspﾍ
           }
		if (action.equals("history")){
			
			int cID = Integer.parseInt(request.getParameter("cID"));
			
			 List<historyBean> list = dao.history(cID);
			
			 request.setAttribute("history",list);
			 gotoPage(request, response, "/history.jsp");
		}
    }catch(DAOException e) {
		e.printStackTrace();
		request.setAttribute("message", "入力した内容に不備があります");
		gotoPage(request,response,"/custmer_error.jsp");
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
