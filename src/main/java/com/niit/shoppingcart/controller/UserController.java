package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
public class UserController {

	Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserLoginDAO userLoginDAO;

	@Autowired
	UserLogin userDetails;

	@Autowired
	UserDetailsDAO userDetailsDAO;

	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private Cart cart;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	
	/**
	 * if invalid credentials ->  Home page , login ,  error message
	 * if valid credentials  && he is admin ->  AdminHome page ,logout link
	 * if valid credentials && he is end user ->  Home page, cart, logout link
	 * @param userID
	 * @param password
	 * @return it will return data and page name where to return
	 */
	@RequestMapping(value="/login",method= RequestMethod.POST)
	public ModelAndView login(@RequestParam(value = "name") String userId,
			@RequestParam(value = "password") String password, HttpSession session) {
		log.debug("Starting of the method login");
		log.info("userID is {}  password is {}", userId, password);

	    System.out.println(userId+"   "+password);
		ModelAndView mv = new ModelAndView("/home");
		boolean isValidUser = userLoginDAO.isValidUser(userId, password);

		if (isValidUser == true) {
			userDetails = userLoginDAO.get(userId);
			session.setAttribute("loggedInUser", userDetails.getUserName());
			if (userDetails.getAdmin() == 1) {
				mv.addObject("isAdmin", "true");

			} else {
				mv.addObject("isAdmin", "false");
				cart = cartDAO.get(userId);
				mv.addObject("cart", cart);
				List<Cart> cartList = cartDAO.listCartItems();
				mv.addObject("cartList", cartList);
				mv.addObject("cartSize", cartList.size());
			}

		} else {

			mv.addObject("invalidCredentials", "true");
			mv.addObject("errorMessage", "Invalid Credentials");
			

		}
		log.debug("Ending of the method login");
		return mv;
	}

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginPage()
	{
		return "login";
	}
	 
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("home");
		session.invalidate();
		session = request.getSession(true);
		session.setAttribute("category", category);
		session.setAttribute("categoryList", categoryDAO.listCategory());
	
		mv.addObject("logoutMessage", "You successfully logged out");
		mv.addObject("loggedOut", "true");
	
		return mv;
	 }

}
