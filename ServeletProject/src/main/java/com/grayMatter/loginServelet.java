package com.grayMatter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginServelet
 */
public class loginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    //servelets are basically controllers 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html><body bgcolor = yellow><h1>Hello form</h1></body></html>");
		//fetching jsp to servelet getParameter will get parameters and 
		//sending data from servelet to servelet getAttribute will fetch data in that servelet
		String name=request.getParameter("uname");//whatever user enters that will be fetched
		String pwd =request.getParameter("pwd");
		if(name.equals("amrit")&& pwd.equals("12345")) {
			out.println("welcome user "+name);
			request.setAttribute("uname", name);
			request.setAttribute("pass", pwd);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WelcomeServelet");//this is url where u will be forwarded
			dispatcher.forward(request, response);//to go to next page
			
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");//this is a way to to connect and move on to next page
			dispatcher.forward(request, response);
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
