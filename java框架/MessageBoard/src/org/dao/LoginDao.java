package org.dao;  
import java.io.PrintWriter;
import java.sql.*;  

import org.model.*;  
import org.db.*;  

import java.util.ArrayList;  

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.servlet.http.HttpServletResponse;
public class LoginDao {  
    Connection conn=DBconn.getConn(); ;                                      //数据库连接对象  
    PreparedStatement pstmt;  
    public Login checkLogin(String name,String password){ //验证用户名密码  
        try{  
            pstmt=conn.prepareStatement("select * from loginss where name=?  and password=?");  
           
            pstmt.setString(1, name);                     //设置SQL语句参数  
            pstmt.setString(2, password);                 //设置SQL语句参数  
            ResultSet rs=pstmt.executeQuery();            //执行查询，返回结果集  
            if(rs.next()){                                //通过JavaBean保存值  
                Login login=new Login();  
                login.setId(rs.getInt(1));  
                login.setName(rs.getString(2));
                
                
                login.setPassword(rs.getString(3));  
                
                return login;                             //返回JavaBean对象  
            }  
            return null;                                  //验证失败返回null  
        }catch(Exception e){  
            e.printStackTrace();  
            return null;  
        }  
    }  
    public  ArrayList<MessBoar> findMbInfo(){  
        try{  
            ArrayList<MessBoar> al=new ArrayList<MessBoar>();  
            pstmt=conn.prepareStatement("select * from messagess");  
            ResultSet rs=pstmt.executeQuery();  
            while(rs.next()){  
                MessBoar mb=new MessBoar();  
                mb.setId(rs.getInt(1));  
                mb.setName(rs.getString(2));  
                mb.setTime(rs.getDate(3));  
                mb.setTitle(rs.getString(4));  
                mb.setMessage(rs.getString(5));  
                al.add(mb);  
            }  
            return al;  
        }catch(Exception e){  
            e.printStackTrace();  
            return null;  
        }  
    }  
        public String getName(int id){  
            String name=null;  
            try{  
                pstmt=conn.prepareStatement("select name from loginss where id=?");  
                pstmt.setInt(1, id);  
                ResultSet rs=pstmt.executeQuery();  
                while(rs.next()){  
                     name=rs.getString(1);  
                }  
                return name;  
            }catch(Exception e){  
                e.printStackTrace();  
                return null;  
            }  
        }  
  
        public boolean addInfo(MessBoar mb){  
            try{  
                pstmt=conn.prepareStatement("insert into messagess values(?,?,?,?,?)");  
                pstmt.setInt(1, mb.getId());  
                pstmt.setString(2, mb.getName()); 
                pstmt.setDate(3, mb.getTime());  
                pstmt.setString(4, mb.getTitle());  
                pstmt.setString(5, mb.getMessage());  
                pstmt.executeUpdate();  
                return true;  
            }catch(Exception e){  
                e.printStackTrace(); 
                
                return false;  
            }  
        }  
        public boolean insertUser(String name,String password,HttpServletResponse response){  
            try{  
                pstmt=conn.prepareStatement("insert into loginss(name,password,role) values(?,?,?)");  
                 
                pstmt.setString(1, name);                 
                pstmt.setString(2, password);  
                pstmt.setInt(3, 0);  
                pstmt.executeUpdate();  
               
                return true;  
            }catch(Exception e){  
                e.printStackTrace();
                try {
                	response.sendRedirect("registererror.jsp"); 
				} catch (Exception e2) {
					// TODO: handle exception
				}
                
                return false;  
            }  
        }  
        public String getUser(String name){
        	String getName ="";
        	try{  
        		PreparedStatement ps =conn.prepareStatement("select name from loginss where name =?");  
                 
        	ps.setString(1, name);
                ResultSet rs=ps.executeQuery(); 
                while(rs.next()){  
                      getName=rs.getString(1);
                }  
                
                 
                return getName;  
            }catch(Exception e){  
                e.printStackTrace();
            }
        	return getName;
        }
  
  
}  