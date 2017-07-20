package com.javajo.listener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class JavajoListener
 *
 */
@WebListener
public class JavajoListener implements HttpSessionAttributeListener {

	FileWriter writer;
	HttpSession session;
	String id="";
	File file;
	String date2="";
    /**
     * Default constructor. 
     */
    public JavajoListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent e)  { 
         // TODO Auto-generated method stub
    	session = e.getSession();
    	id = (String)session.getAttribute("id");
    	Date date = new Date();
    	int year = date.getYear()+1900;
    	int month = date.getMonth()+1;
    	int day = date.getDate();
    	int hour = date.getHours();
    	int minute = date.getMinutes();
    	int second = date.getSeconds();
    	String contect = year+"년"+month+"월"+day+"일"+hour+"시"+minute+"분"+second+"초\r\n";
    	try {
    		file = new File("C:/hanbitproject/회원/"+id+".txt");
			writer = new FileWriter(file, true);
			writer.write(contect);
			writer.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	if(id==null)
    	{
    		int cnt = 3;
    		session.setAttribute("cnt", cnt);
    	}
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    	
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent e)  { 
         // TODO Auto-generated method stub
    	session = e.getSession();
    	id = (String)session.getAttribute("id");
    	Date date = new Date();
    	int year = date.getYear()+1900;
    	int month = date.getMonth()+1;
    	int day = date.getDate();
    	int hour = date.getHours();
    	int minute = date.getMinutes();
    	int second = date.getSeconds();
    	String contect = year+"년"+month+"월"+day+"일"+hour+"시"+minute+"분"+second+"초\r\n";
    	try {
    		file = new File("C:/hanbitproject/회원/"+id+".txt");
			writer = new FileWriter(file, true);
			writer.write(contect);
			writer.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
	
}
