package com.niit.shoppingcart.controller;

import java.io.File;




import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

@Controller
public class CategoryController {
	
	Logger log = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private Category category;
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value = "/categories",method = RequestMethod.GET)
	public String listCategories(Model model) {
		model.addAttribute("category", category);
		model.addAttribute("categoryList", this.categoryDAO.listCategory());
		return "category";
		
	}
	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category")Category category) 
	{   
		
		categoryDAO.saveOrUpdate(category);
		
		return "category";

	}
	
	@RequestMapping("category/remove/{id}")
	public String deleteCategory(@PathVariable("id") String id,ModelMap model) 
			throws Exception {
		try{
		categoryDAO.delete(id);
		model.addAttribute("message", "Succesfully removed");
		}
		catch(Exception e){
		model.addAttribute("message", e.getMessage());
		e.printStackTrace();
		}
		return "category";
		
	}
	
	@RequestMapping("category/edit/{id}")
	public String editCategory(@PathVariable("id") String id,Model model) {
		category = categoryDAO.get(id);
		model.addAttribute("category",category);
		model.addAttribute("category", categoryDAO.listCategory());
		return "category";
		
	}
}