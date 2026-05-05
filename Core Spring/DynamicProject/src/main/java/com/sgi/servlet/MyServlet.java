package com.sgi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sgi.action.QuestionAction;
import com.sgi.beans.QueBean;
import com.sgi.connection.MyConn;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String que, opt1, opt2, opt3, opt4, ans;
		int marks;
		
		if(request.getParameter("addque")!=null)
		{
			que=request.getParameter("que");
			opt1=request.getParameter("opt1");
			opt2=request.getParameter("opt2");
			opt3=request.getParameter("opt3");
			opt4=request.getParameter("opt4");
			ans=request.getParameter("ans");
			marks= Integer.parseInt(request.getParameter("marks"));
			
			QueBean qb=new QueBean();
			qb.setQue(que);
			qb.setOpt1(opt1);
			qb.setOpt2(opt2);
			qb.setOpt3(opt3);
			qb.setOpt4(opt4);
			qb.setAns(ans);
			qb.setMarks(marks);
			
			MyConn myConn = new MyConn();
			Connection conn = myConn.config();
			
			QuestionAction qa = new QuestionAction();
			int i=qa.addQuestion(conn, qb);
			System.out.println(i);
			if(i>0)
				out.println("<script>alert('Question Added Successfully')</script>");
			else
				out.println("<script>alert('No Question Added')</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
