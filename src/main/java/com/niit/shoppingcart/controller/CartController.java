package com.niit.shoppingcart.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.apache.log4j.jmx.LoggerDynamicMBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Cart;

@Controller
public class CartController {

	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private Cart cart;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value="/cart", method=RequestMethod.GET)
	public String myCart(Model model,HttpSession session) {
		model.addAttribute("cart", new Cart());
	String loggedInUserid = (String)session.getAttribute("loggrdInUserID");
	model.addAttribute("cartList", cartDAO.listCartItems());
	//model.addAttribute("totalAmount",cartDAO.getTotalAmount(loggedInUserid));
	model.addAttribute("displayCart","true");
	return"/cart";
	}
	
	@RequestMapping("cart/delete/{id}")
	public String removeCart(@PathVariable("id") String id,ModelMap model) throws Exception{
	
	try{
		cartDAO.delete(id);
		model.addAttribute("message", "succesfully removed");
	}
	catch(Exception e){
		model.addAttribute("message", e.getMessage());
		e.printStackTrace();
	}
	return "redirect:/home";
	
}

@RequestMapping("cart/edit/{id}")
public String editCart(@PathVariable("id") String id, Model model, HttpSession session){
	System.out.println("editCart");
	model.addAttribute("cart",this.cartDAO.get(id));
	String loggedInUserid = (String) session.getAttribute("LoggedInUserID");
	model.addAttribute("listCarts",this.cartDAO.listCartItems());
	model.addAttribute("displayCart", true);
	return "/home";
	
		
	}
}
	

