package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Student;

public class Dao {
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/information";
	private String user = "root";

	private String password = "123";
	Connection conn = null;
	Statement state = null;
	PreparedStatement pState = null;
	//初始化块
	{		
		connectToMysql();
	}
	//查询，注意：在使用ArrayList的add方法时，如果重新不实例化加入的对象，则会后面的覆盖前面的
	public ArrayList selectFromDb(String sql){
		ArrayList students = new ArrayList();
		
		try {
			ResultSet rs = state.executeQuery(sql);
			
			while(rs.next()){
				Student student = new Student();
				student.setSNo(rs.getInt("SNo"));
				student.setSName(rs.getString("SName"));
				student.setSAge(rs.getInt("SAge"));
				
				students.add(student);
			}
			rs.close();
			state.close();
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			//关闭连接
			try {
				if(conn!=null){
					conn.close();
					conn=null;
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}

		}
		return students;
	}
	//添加操作
	public int insertIntoDb(Student s){
		if(conn==null){
			connectToMysql();
		}
		int i =0;
		String sql = "insert into student values(?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, s.getSNo());
			ps.setString(2,s.getSName());
			ps.setInt(3, s.getSAge());
			i = ps.executeUpdate();
			System.out.println("插入成功");
			ps.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return i;
	}
	//删除操作
	public int  deleteFromDb(String sql){
		if(conn==null){
			connectToMysql();
		}
		if(state == null){
			try {
				state = conn.createStatement();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		int i =0;
		
		try {
			i = state.executeUpdate(sql);
			System.out.println("删除成功");
			state.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		
		return i;
	}
	//修改操作
	public int updateFromDb(String sql){
		if(conn==null){
			connectToMysql();
		}
		if(state == null){
			try {
				state = conn.createStatement();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		int i =0;
		
		try {
			i = state.executeUpdate(sql);
			System.out.println("修改成功");
			state.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		
		return i;
	}
	//进行数据库连接
	protected void connectToMysql()
	{
		try {		
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
			state = conn.createStatement();	


		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//关闭数据库连接
	public static void closeConnection(Connection conn,PreparedStatement ps,ResultSet rs){   //Connection对象，代表与数据源进行的唯一会话

		//根据先后执行的顺讯逆序关闭已经打开的资源。
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}


