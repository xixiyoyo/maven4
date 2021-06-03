package com.xixiyoyo.controller;


import com.xixiyoyo.domain.User;
import com.xixiyoyo.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")   //请求到/user/login跳转到Success.jsp页面
    public String login(){
      System.out.println("登陆成功");
      //在Spring-mvc.xml中配置了内部资源视图解析器，可以实现对资源前缀和后缀的存储
      return "Success";     //redirect: 表示重定向  forward：表示转发  当使用这个前缀时，要将跳转的页面名写全。"redirect:/jsp/Success.jsp"
    }
  @RequestMapping("/login2")          //请求到/user/login2，modelAndView.addObject类似于request域存入数据（可以传入Success.jsp），返回到视图解析器中，然后由视图解析器帮我们转到Success.jsp。
  public ModelAndView login2(){
      ModelAndView modelAndView = new ModelAndView();
    //添加模型数据 可以是任意的POJO对象也可以是任何java类型
      modelAndView.addObject("username","zhangsan");
      modelAndView.addObject("password","123456");
    //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
      modelAndView.setViewName("Success");
    return modelAndView;
  }
  @RequestMapping("/login3")         //Spring容器可以帮我们调用方法并将ModelAndView参数注入，让我们可以直接使用modelAndView。
  public ModelAndView login3(ModelAndView modelAndView){
    modelAndView.addObject("username","zhangsan");
    modelAndView.addObject("password","123456");
    modelAndView.setViewName("Success");
    return modelAndView;
  }
  @RequestMapping("/login4")           //Spring容器可以帮我们调用方法并将Model参数注入，让我们可以直接使用model。
  public String login4(Model model){
    model.addAttribute("username","zhangsan");
    model.addAttribute("password","123456");
    //modelAndView.setViewName("Success");
    return "Success";

  }
  @RequestMapping("/login5")          //向responce页面回传数据Success
  @ResponseBody   //@ResponseBody回写数据
  public String login5(Model model){
    model.addAttribute("username","zhangsan");
    model.addAttribute("password","123456");
    //modelAndView.setViewName("Success");
    return "Success";

  }
  @RequestMapping("/login6")
  @ResponseBody
  public String login6(){

    //modelAndView.setViewName("Success");
    return "Success";

  }
  @RequestMapping("/login7")       //向页面传入一个User类型的对象，会以json的形式展现
  @ResponseBody
  public User login7(){       //在Spring-mvc.xml中配置了转换器，Spring容器会自动帮我们将对象转成json字符串
      User user = new User();     //这种操作可以用SpringMVC提供的配置去完成<mvc:annotation-driven/>。
      user.setName("xixiyoyo");   //这个驱动可以代替注解处理器和适配器的配置（MVC的三大组件，处理器映射器，处理器适配器，视图解析器）
      user.setAge(18);
      user.setMoney(10000000000.00);
    return user;

  }
  @RequestMapping("/login8")       //获得基本数据类型数据，然后回传数据
  @ResponseBody
  public String login8(String username,int age){

    return username+":"+age;

  }
  @RequestMapping(value = "/login9")     //获得POJO类型的数据，然后回传数据
  @ResponseBody
  public void login9(User user){                 //如果请求参数符合User构造器会自动帮我们生成User对象，实现对pojo类型数据的封装

    System.out.println(user);

  }
  @RequestMapping(value = "/login10")         //获得数组类型的数据，然后回传数据
  @ResponseBody
  public void login10(String[] strs){
    System.out.println(Arrays.asList(strs));

  }
  @RequestMapping(value = "/login11")          //创建一个pojo VO类，获得集合类型的数据，然后将userList 集合 作为属性存入VO中，如果请求参数符合User构造器会自动帮我们生成User对象，实现对pojo类型数据的封装
  @ResponseBody
  public void login11(VO vo){
    System.out.println(vo);

  }
  @RequestMapping(value = "/login12")          //当我们接收ajax请求时，我们可以直接接收一个json类型的集合，这个数据存在@RequestBody()中，我们就可以通过参数来获得。
  @ResponseBody
  public void login12(@RequestBody() List<User> arrsList){
    System.out.println(arrsList);

  }
  @RequestMapping(value = "/login13/{name}")        //restful风格的传参，我们可以通过@PathVariable("name")来去除占位符中的值，然后传给参数。
  @ResponseBody
  public void login13(@PathVariable("name") String strs){
    System.out.println(strs);

  }
  @RequestMapping(value = "/login14")          //获得servletAPI
  @ResponseBody
  public void login14(HttpServletRequest request, HttpServletResponse response, HttpSession session){
    System.out.println(request);
    System.out.println(response);
    System.out.println(session);

  }
  @RequestMapping(value = "/login15")        //获得请求头数据
  @ResponseBody
  public void login15(@RequestHeader("User-Agent") String strs){
    System.out.println(strs);

  }
  @RequestMapping(value = "/login16")             //获得Cookie类型数据
  @ResponseBody
  public void login16(@CookieValue("JSESSIONID") String strs){
    System.out.println(strs);

  }@RequestMapping(value = "/login17")             //文件上传
  @ResponseBody
  public void login17(MultipartFile[] updateFile,String username) throws IOException {
    System.out.println(username);
    for (MultipartFile multipartFile : updateFile) {
      String originalFilename = multipartFile.getOriginalFilename();
      multipartFile.transferTo(new File("D:\\新建文件夹\\"+originalFilename));
    }

  }





}
