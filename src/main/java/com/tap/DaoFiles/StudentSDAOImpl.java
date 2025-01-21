package com.tap.DaoFiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.Model.Student;
import com.tap.dbUtils.DBUtils;
import com.tap.security.Decrypt;

public class StudentSDAOImpl implements StudentDAO {
	
	List<Student>studentlist=new ArrayList<Student>();
	private Connection con;
	String Fetch_All="select * from register";
	String FetchONID="select * from register where id=?";
	String addStudent="insert into register(name, email, password, mobile , address)values(?,?,?,?,?)";
	String UpdateStudent="update register set name=?, mobile=?,address=? where id=?";
	String Delete="delete  from register where id=?";
	private Statement stmt;
	private ResultSet rstmt;
	private PreparedStatement pstmt;
	private int status;
	public StudentSDAOImpl() {
		 try {
			 con = DBUtils.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public int insertStudent(Student s) {
		try {
			 pstmt = con.prepareStatement(addStudent);
			 pstmt.setString(1, s.getName());
			 pstmt.setString(2, s.getEmail());
			 pstmt.setString(3, s.getPassword());
			 pstmt.setString(4, s.getMobile());
			 pstmt.setString(5, s.getAddress());
			 status = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
		}
	
	public Student fetchOnId(int id) {
		try {
			 pstmt = con.prepareStatement(FetchONID);
			 pstmt.setInt(1, id);
			 rstmt = pstmt.executeQuery();
			  studentlist = extractUserListFromUserlist(rstmt);
			  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentlist.get(0);
	}
	@Override
	public List<Student> fetchAll() {
		try {
			 stmt = con.createStatement();
			  rstmt = stmt.executeQuery(Fetch_All);
			  return extractUserListFromUserlist(rstmt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	List<Student> extractUserListFromUserlist(ResultSet rstmt){
		try {
			while(rstmt.next()) {
				studentlist.add(new Student(rstmt.getInt("id"),
								   rstmt.getString("name"),
								   Decrypt.decrypt(rstmt.getString("email")),
								   rstmt.getString("password"),
								   rstmt.getString("mobile"),
								   rstmt.getString("address")
			
		
						));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentlist;
		
		
	}
	public int updateStudent(Student s) {
		try {
			pstmt=con.prepareStatement(UpdateStudent);
			pstmt.setString(1, s.getName());
			pstmt.setString(2, s.getMobile());
			pstmt.setString(3, s.getAddress());
			pstmt.setInt(4, s.getId());
			status=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public int delete(int id) 
	{
		try {
			 pstmt = con.prepareStatement(Delete);
			 pstmt.setInt(1, id);
			  status = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
		
	}

	
	
}
