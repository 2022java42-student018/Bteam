package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Customeradd.html")
public class Custmeradd extends HttpServlet {

       
  
    public Custmeradd() {
        super();
       
    }	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String straddress = request.getParameter("address");
		String strnumber = request.getParameter("number");
		String email = request.getParameter("email");
		
		if(straddress == null || strnumber == 0  ) {
			request.setAttribute("message", "入力内容に誤りがあります。");
			RequestDispatcher rd = request.getRequestDispatcher("/Customererror.jsp");
			rd.forward(request , response);
			return;
		}
		
		response.setContentType(name);
		response.setContentType(straddress);
		response.setContentType(strnumber);
		response.setContentType(email);
		
		PrintWriter out = response.getWriter();
		
		
		
		
		
		
		
	}

}
