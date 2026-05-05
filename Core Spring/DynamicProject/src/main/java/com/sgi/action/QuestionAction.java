package com.sgi.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sgi.beans.QueBean;
import com.sun.tools.javac.util.List;

public class QuestionAction {
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private String sql=null;
	private int i=0;
	
	public int addQuestion(Connection con, QueBean qb)
	{
		try
		{
			sql="INSERT INTO question(que, opt1, opt2, opt3, opt4, ans, marks)VALUES(?,?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			System.out.println(sql);
			ps.setString(1, qb.getQue());
			ps.setString(2, qb.getOpt1());
			ps.setString(3, qb.getOpt2());
			ps.setString(4, qb.getOpt3());
			ps.setString(5, qb.getOpt4());
			ps.setString(6, qb.getAns());
			ps.setInt(7, qb.getMarks());
			
			i=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}
	
	
	public static List<QueBean> getAllEmployees(){
		List<QueBean> list=new ArrayList<QueBean>();
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from user");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Emp e=new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
				list.add(e);
				
			
				
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
}