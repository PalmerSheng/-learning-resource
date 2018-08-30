package org.servlet;  
import java.io.IOException;  
import org.dao.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
public class RegisterServlet extends HttpServlet {  
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException { 
    		try {
    			request.setCharacterEncoding("gb2312");  
//              int id=Integer.valueOf(request.getParameter("id"));  
              String name=request.getParameter("name");  
              String password=request.getParameter("password");  
              if(new LoginDao().getUser(name)==null||new LoginDao().getUser(name)==""){
            	  
            	  if(new LoginDao().insertUser(name, password,response)){  
                      response.sendRedirect("login.jsp");  
                  } 
              }else{
            	  throw new Exception();
              }
             
			} catch (Exception e) {
				// TODO: handle exception
				response.sendRedirect("registererror.jsp");  
			}
             
        }  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        doGet(request,response);  
    }  
}  