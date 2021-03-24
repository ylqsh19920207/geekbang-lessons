package org.geektimes.configuration.microprofile.config.source.servlet;

import org.geektimes.configuration.microprofile.config.source.MapBasedConfigSource;

import javax.servlet.ServletContext;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class ServletContextConfigSource extends MapBasedConfigSource {

    private Map configData = new HashMap();

    private final ServletContext servletContext;

    public ServletContextConfigSource(ServletContext servletContext) {
        super("ServletContext Init Parameters", 500);
        this.servletContext = servletContext;
        Enumeration<String> parameterNames = servletContext.getInitParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            this.configData.put(parameterName, servletContext.getInitParameter(parameterName));
        }
    }

    @Override
    protected void prepareConfigData(Map configData) throws Throwable {
        configData = this.configData;
    }
}
