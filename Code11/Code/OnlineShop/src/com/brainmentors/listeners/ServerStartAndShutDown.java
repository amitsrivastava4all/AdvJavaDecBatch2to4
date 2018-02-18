package com.brainmentors.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServerStartAndShutDown
 *
 */
@WebListener
public class ServerStartAndShutDown implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ServerStartAndShutDown() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	for(int i = 1; i<=100; i++){
    		System.out.println("Server Start "+i);
    		try {
				Thread.sleep(70);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
	
}
