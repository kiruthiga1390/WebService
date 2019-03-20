package uw.edu.context;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import uw.edu.controller.NotificationController;

public class ServletContextClass implements ServletContextListener {
	
	// Intializing the servlet context.(this acts like main method of java)
	public void contextInitialized(ServletContextEvent arg0) 
    {
		// the vital signs are checked every hour using the below logic.
		Thread t = new Thread() {
		    @Override
		    public void run() {
		        while(true) {
		            try {
		                Thread.sleep(1000*60*60);
		                //Thread.sleep(10000);
		                NotificationController notify = new NotificationController();
		                notify.getVitalSigns();
		            } catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		    }
		};
		t.start(); 
    }

    public void contextDestroyed(ServletContextEvent arg0) 
    {
              
    }

}
