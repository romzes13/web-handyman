package com.web.handyman.controller;
// Delete this file  ////
/////////////////////////

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
/*package com.web.handyman.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@Controller
//@RequestMapping("/admin")
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/admin").setViewName("admin");
        //registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
    }

}*/
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class WebController {
    
    @RequestMapping(value={"/home"})
        public String home(){
            return "home";
        }
    
    @RequestMapping(value={"/welcome"})
    public String welcome(){
        return "welcome";
    }
   
   /* @RequestMapping(value="/admin")
    public String admin(){
        return "admin";
    }*/
    
    @RequestMapping(value={"/login"})
    public String login(){
        return "login";
    }
    
    
   /* @RequestMapping(value="/403")
    public String Error403(){
        return "403";
    }*/
    
  //for 403 access denied page
  	@RequestMapping(value = "/403", method = RequestMethod.GET)
  	public ModelAndView accesssDenied() {

  	  ModelAndView model = new ModelAndView();

  	  //check if user is login
  	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
  	  if (!(auth instanceof AnonymousAuthenticationToken)) {
  		UserDetails userDetail = (UserDetails) auth.getPrincipal();
  		model.addObject("userName", userDetail.getUsername());
  		System.out.println("User name: " + userDetail.getUsername());
  	  }

  	  model.setViewName("403");
  	  return model;

  	}
    
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminPage() {

	  ModelAndView model = new ModelAndView();
	  model.addObject("title", "Spring Security Login Form - Database Authentication");
	  model.addObject("message", "This page is for ROLE_ADMIN only!");
	  model.setViewName("admin");
	  return model;

	}
}