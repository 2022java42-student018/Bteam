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
import la.bean.historyBean;
import la.bean.lend_docBean;
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
        List<CustomerBean> list= dao.Emailcheck(eMail);
        
        if(list != null) {
        	String eMail1 =request.getParameter("email");
            List<CustomerBean> list1= dao.emailSearch(eMail1);	
            request.setAttribute("customer", list1);
            gotoPage(request,response,"/showcustomer.jsp");//showcustomerﾍ
        
        }else
        	request.setAttribute("message", "Emailが間違っています");
			gotoPage(request, response, "/customerError.jsp");

        
    
			
         }else if (action.equals("rend_doc")) {
        	 
             int cID = Integer.parseInt(request.getParameter("cID"));
             List<lend_docBean> list = dao.rend_doc(cID);
              
             request.setAttribute("document",list);

             gotoPage(request, response, "/lend_doc.jsp");// lend_doc.jspﾍ
           
           }
    
         else if (action.equals("history_doc")){
			
			int cID = Integer.parseInt(request.getParameter("cID"));
			
			 List<historyBean> list = dao.history_doc(cID);
			
			 request.setAttribute("history",list);
			 gotoPage(request, response, "/history_doc.jsp");
           }
           }catch(DAOException e) {
		e.printStackTrace();
		request.setAttribute("message", "入力した内容に不備があります");
		gotoPage(request,response,"/customerError.jsp");
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
