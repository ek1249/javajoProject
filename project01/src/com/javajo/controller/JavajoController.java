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
		
		String path = config.getServletContext().getRealPath("/WEB-INF/javajo.properties");
		try{
			InputStreamReader input = new InputStreamReader(new FileInputStream(path));
			Properties prop = new Properties();
			prop.load(input);
			
			Set<Object> keys = prop.keySet();
			Iterator iter = keys.iterator();
			while(iter.hasNext())
			{
				String key = (String)iter.next();
				String cname = prop.getProperty(key);
				
				map.put(key, (JavajoAction)Class.forName(cname).newInstance());
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
		proRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		proRequest(request, response);
	}
	
	public void proRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String lasturi = uri.substring(uri.lastIndexOf("/")+1);
		
		JavajoAction action = map.get(lasturi);
		
		String view = action.proRequest(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

}
