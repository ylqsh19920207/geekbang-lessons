package org.geektimes.projects.user.web.controller;

import org.geektimes.injection.context.ComponentContext;
import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
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
public class UserController implements PageController {

    private UserService userService;

    public UserController() {
        userService = ComponentContext.getInstance().getComponent("bean/UserService");
    }

    @GET
    @POST
    @Path("/register")
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setEmail(request.getParameter("email"));
        user.setPhoneNumber(request.getParameter("phoneNumber"));
        user.setPassword(request.getParameter("password"));

        if(!userService.register(user)){
            return "register-error.jsp";
        }
        return "index.jsp";
    }
}
