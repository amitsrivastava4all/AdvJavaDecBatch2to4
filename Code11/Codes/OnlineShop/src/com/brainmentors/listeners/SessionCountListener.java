package com.brainmentors.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionCountListener
 *
 */
@WebListener
public class SessionCountListener implements HttpSessionListener {

	private static int counter ;
    /**
     * Default constructor. 
     */
    public SessionCountListener() {
        // TODO Auto-generated constructor stub
    }
    
    public static int getCounter(){
    	return counter;
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	counter++;
    	System.out.println("Created "+counter);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    counter--;
    System.out.println("Session Kill "+counter);
    }
	
}
