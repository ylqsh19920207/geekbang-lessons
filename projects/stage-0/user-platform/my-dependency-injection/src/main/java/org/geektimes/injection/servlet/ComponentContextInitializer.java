package org.geektimes.injection.servlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

/**
 * @author xuxi
 * @date 2021/3/24
 * @description
 */
public class ComponentContextInitializer implements ServletContainerInitializer {


    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        servletContext.addListener(ComponentContextInitializerListener.class);
    }
}
