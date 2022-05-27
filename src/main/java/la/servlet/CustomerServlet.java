package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
      protected void doGet(HttpServletRequest request,

HttpServletResponse response) throws ServletException, IOException {

request.setCharacterEncoding("UTF-8");

response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter();
String action = request.getParameter("action");
if (action.equals("regist")) {

         String name = request.getParameter("name");
         String address = request.getParameter("address");
         String tel = request.getParameter("tel");
         HttpSession session = request.getSession();
 session.setAttribute("name", name);
 session.setAttribute("address", address);
 session.setAttribute("tel", tel);
 session.setAttribute("email", email);
 session.setAttribute("bday", bday);

    out.println("<html><head><title>ShowCart</title></head><body>");
    out.println("<h1>登録が完了しました</h1>");
    out.println("</body></html>");
} else if (action.equals("confirm")) {

HttpSession session = request.getSession(false);
if (session == null) {
   out.println("<html><head><title>ShowCart</title></head><body>");
   out.println("<h1>入力内容に誤りがあります</h1>");
  return;
}




        String name = (String)session.getAttribute("name");
        String address = (String)session.getAttribute("address");
        String tel = (String)session.getAttribute("tel");
out.println("<html><head><title>ShowCustomer</title></head><body>");
out.println("名前:" + name + "<br/>");
out.println("住所:" + address + "<br/>");
out.println("電話番号:" + tel + "<br/>");
out.println("Eメール:" + email + "<br/>");
out.println("生年月日:" + bday + "<br/>");
out.println("</body></html>");
     }
}
protected void doPost(HttpServletRequest request,

HttpServletResponse response) throws ServletException, IOException {
doGet(request, response);
      }
}


