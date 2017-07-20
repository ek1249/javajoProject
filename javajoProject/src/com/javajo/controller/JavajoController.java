package com.javajo.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javajo.action.JavajoAction;



/**
 * Servlet implementation class MovieController
 */
@WebServlet("/MovieController")
public class JavajoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	HashMap<String, JavajoAction> map;
	
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
			map = new HashMap<String, JavajoAction>();
		
		try{
			String path = config.getServletContext().getRealPath("/WEB-INF/hb.properties");
			InputStreamReader input = new InputStreamReader(new FileInputStream(path));
			Properties prop = new Properties();
			prop.load(input);
			
			Set keys  = prop.keySet();
			Iterator iter = keys.iterator();
			while(iter.hasNext())
			{
				String key = (String)iter.next();
				String clsName = (String)prop.get(key);				
				//JavajoAction obj = (JavajoAction) Class.forName(clsName).newInstance();
				map.put(key, (JavajoAction) Class.forName(clsName).newInstance());
			}
			
			input.close();
			
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public JavajoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		proRequest(request,response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		proRequest(request,response);
	}

	private void proRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		String cmd =uri.substring(uri.lastIndexOf("/")+1);
		
		JavajoAction action = map.get(cmd);
		
		String view  = action.proRequest(request, response);
		/*
			만약에 사용자가 주소표시줄에 insertBoard.do라고 요청했다면
			view에 저장되는 값은 "insertBoard.jsp"
		 */
		
		//request.setAttribute("viewPage", view); //각페이지 마다 존재해야될것들을 고정시켜놓는? 
		
		// 컨트롤러의 역할인 서블릿에서 
		// 처리결과에 따라 특정 jsp로 이동시키기 위해서는 
		// RequestDispatcher를 이용한다.
		RequestDispatcher dispatcher
			= request.getRequestDispatcher(view); 
		
		dispatcher.forward(request, response);
		
		
		
	}

}
