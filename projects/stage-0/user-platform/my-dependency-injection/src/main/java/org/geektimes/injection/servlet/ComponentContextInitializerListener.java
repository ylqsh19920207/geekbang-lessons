package org.geektimes.injection.servlet;



import org.geektimes.context.ClassicComponentContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * {@link } 初始化器
 * ContextLoaderListener
 */
public class ComponentContextInitializerListener implements ServletContextListener {

    private ServletContext servletContext;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        this.servletContext = sce.getServletContext();
        ClassicComponentContext context = new ClassicComponentContext();
        context.init(servletContext);

//        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
//        User user = new User();
//        try {
//            mBeanServer.registerMBean(new UserManager(user), new ObjectName("org.geektimes.projects.user.management:type=User"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        Config config = ConfigProvider.getConfig();
//        System.out.println("Application Name:" + config.getValue("application.name", String.class));
//        System.out.println("Test Integer:" + config.getValue("test.integer", Integer.class));
//        Config config1 = ConfigProvider.getConfig();
//        Config config2 = ConfigProvider.getConfig();

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
//        ComponentContext context = ComponentContext.getInstance();
//        context.destroy();
    }

}
