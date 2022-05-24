package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Custmeradd.html")
public class Custmeradd extends HttpServlet {

       
  
    public Custmeradd() {
        super();
       
    }	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String number = request.getParameter("number");
		String email = request.getParameter("email");
		
		response.setContentType(name);
		response.setContentType(address);
		response.setContentType(number);
		response.setContentType(email);
		PrintWriter out = response.getWriter();
		
		out.println(name);
		out.println(address);
		out.println(number);
		out.println(email);
		
		
		
		
	}

}
