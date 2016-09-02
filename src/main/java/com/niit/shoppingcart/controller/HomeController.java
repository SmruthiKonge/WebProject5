package com.niit.shoppingcart.controller;

import javax.servlet.http.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.dao.UserLoginDAO;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.UserDetails;
import com.niit.shoppingcart.model.UserLogin;

@Controller
public class HomeController {
	
	Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	UserDetails userDetails;

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private UserLogin userLogin;
	
	@Autowired
	private UserLoginDAO userLoginDAO;

	@Autowired
	private UserDetailsDAO userDetailsDAO;
	
	@Autowired
	private Category category;

	//     ${categoryList}
	@RequestMapping("/")
	public ModelAndView onLoad(HttpSession session) {
		log.debug("Starting of the method onLoad");
		ModelAndView mv = new ModelAndView("/home");
		session.setAttribute("category", category);
		session.setAttribute("categoryList", categoryDAO.listCategory());
		log.debug("Ending of the method onLoad");
		return mv;
	}
	
	@RequestMapping("/home")
	public String home()
	{
		return "home";
	}
	
    //${successMessage}
	@RequestMapping(value = "user/register", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("userDetails") UserDetails userDetails) {
		this.userDetails = userDetails;
		
		userDetailsDAO.saveOrUpdate(userDetails);
		UserLogin userLogin = new UserLogin();
		userLogin.setUserId(userDetails.getUserId());
		userLogin.setUserName(userDetails.getUserName());
		userLogin.setEmail(userDetails.getEmail());
		userLogin.setMobile(userDetails.getMobile());
		userLogin.setPassword(userDetails.getPassword());
		userLogin.setAddress(userDetails.getAddress());
		userLoginDAO.saveOrUpdate(userLogin);
		
		ModelAndView mv  = new ModelAndView("login");
		mv.addObject("successMessage", "You are successfully register");
		
		return mv;
	}

	@RequestMapping("/register")
	public ModelAndView registerHere() {
		ModelAndView mv = new ModelAndView("/register");
		mv.addObject("userDetails", userDetails);
		mv.addObject("isUserClickedRegisterHere", "true");
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView loginHere() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("userDetails", new UserDetails());
		mv.addObject("isUserClickedLoginHere", "true");
		return mv;
	}
}
