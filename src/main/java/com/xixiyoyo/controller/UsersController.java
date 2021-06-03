package com.xixiyoyo.controller;


import com.xixiyoyo.domain.Roles;
import com.xixiyoyo.domain.Users;
import com.xixiyoyo.service.RolesService;
import com.xixiyoyo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/users")
@Transactional(isolation = Isolation.REPEATABLE_READ)  //事务控制（这个类中的所有方法都会实现这个事务控制）
public class UsersController {

  @Autowired
  private UsersService usersService;
  @Autowired
  private RolesService rolesService;

  @Transactional(propagation = Propagation.REQUIRED)  //就近原则，执行当前的事务控制
  @RequestMapping("/login")
  public String login(String name, String password, HttpServletRequest request) throws IOException {
    Users users = usersService.isLogin(name, password);
    HttpSession session = request.getSession();
    if(users != null){
      session.setAttribute("users",users);
      return "redirect:/users/cus";
    }else {
      return "redirect:/jsp/usersLogin.jsp";
    }



  }

  @RequestMapping("/cus")
  public ModelAndView checkUsers(ModelAndView modelAndView){
    List<Users> users = usersService.getUsers();
    modelAndView.addObject("usersList", users);
    modelAndView.setViewName("usersCheck");
    return modelAndView;
  }

  @RequestMapping("/cusid")
  public ModelAndView CheckUsersById(int id,ModelAndView modelAndView){
    Users users = usersService.getUsersById(id);
    List<Roles> rolesList = rolesService.queryRoles();
    modelAndView.addObject("rolesList",rolesList);
    modelAndView.addObject("users",users);
    modelAndView.setViewName("updateUser");
    return modelAndView;
  }
  @RequestMapping("/uus")
  public String updateUsers(Users user,int[] role){
    int update = usersService.update(user);
    if(role.length > 0){
      int i = usersService.delFk(user.getId());
      for (int i1 : role) {
        int i2 = usersService.addFk(user.getId(),i1);
      }
    }


    return "redirect:/users/cus";
  }
  @RequestMapping("/ausUI")
  public ModelAndView addUsersUI(ModelAndView modelAndView){
    List<Roles> rolesList = rolesService.queryRoles();
    modelAndView.addObject("rolesList",rolesList);
    System.out.println(rolesList);
    modelAndView.setViewName("addUsers");
    return modelAndView;
  }
  @RequestMapping("/aus")
  public String addUsers(Users user,int[] role){
    int update = usersService.addUsers(user);
    Users users = usersService.getUsersByName(user.getName());
    //System.out.println(user);
    for (int i : role) {
      int i1 = usersService.addFk(users.getId(),i);
    }
    return "redirect:/users/cus";
  }
  @RequestMapping("/dus")
  public String delUsers(int id){
    int i = usersService.delFk(id);
    int update = usersService.delUsers(id);
    return "redirect:/users/cus";
  }




}
