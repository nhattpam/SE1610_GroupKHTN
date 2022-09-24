/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import utils.DBUtils;

/**
 * Web application lifecycle listener.
 *
 * @author HUNG
 */
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context=sce.getServletContext();
        //get properties location
        String siteMapPath=context.getInitParameter("SITEMAPS_PATH");
        String authenticationPath=context.getInitParameter("AUTHENTICATION_PATH");
        //get properties
        Properties siteMapProperties=DBUtils.getProperties(context, siteMapPath);
        Properties authenticationProperties=DBUtils.getProperties(context, authenticationPath);
        //set properties
        context.setAttribute("SITE_MAP", siteMapProperties);
        context.setAttribute("AUTHENTICATION_LIST", authenticationProperties);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
