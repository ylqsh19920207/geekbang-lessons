package org.geektimes.projects.user.web.controller;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * @author xuxi
 * @date 2021/3/2
 * @description
 */
@Path(value = "/user")
public class LoginController implements PageController {

    @GET
    @POST
    @Path("/login")
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        Config config = ConfigProvider.getConfig();
        System.out.println("Application Name:" + config.getValue("application.name", String.class));
        System.out.println("Test Integer:" + config.getValue("test.integer", Integer.class));
        Config config1 = ConfigProvider.getConfig();
        Config config2 = ConfigProvider.getConfig();
        return "login-form.jsp";
    }
}
