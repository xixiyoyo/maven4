package com.xixiyoyo.web;

//import config.SpringConfig;
import com.xixiyoyo.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "userServlet",value="/User")
public class UserServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req,resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);

    ServletContext servletContext = this.getServletContext();
    ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(servletContext);
    UserService service = (UserService) ac.getBean(UserService.class);
    service.usersave();

  }
}
