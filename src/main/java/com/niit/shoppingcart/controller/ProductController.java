package com.niit.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.Product;

@Controller
public class ProductController {

	@Autowired(required = true)
	private CategoryDAO categoryDAO;

	@Autowired(required = true)
	private SupplierDAO supplierDAO;

	@Autowired(required = true)
	private ProductDAO productDAO;

	private String path = "";

@RequestMapping(value="/product", method=RequestMethod.GET)
public String listProducts(Model model){
	model.addAttribute("product", new Product());
	model.addAttribute("category", new Category());
	model.addAttribute("supplier", new Supplier());
	model.addAttribute("productList", this.productDAO.listProduct());
	model.addAttribute("categoryList", this.categoryDAO.listCategory());
	model.addAttribute("supplierList", this.supplierDAO.listSupplier());
	return "product";
}
	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product) {

		Category category = categoryDAO.getByName(product.getName());

		Supplier supplier = supplierDAO.getByName(product.getName());

		product.setId(category);
		product.getName(supplier);
		product.getSupplier(supplier);

		product.setId(category.getId());
		supplier.getId(supplier.getSupId());
		productDAO.saveOrUpdate(product);

		MultipartFile file = product.getImageUrl();

		// FileUtil.upload(path, file, product.getProductId()".jpg");
		return "redirects/product";
	}

	@RequestMapping("product/edit/{id}")
	public String editProduct(@PathVariable("id") String id, Model model) {
		System.out.println("editProduct");
		model.addAttribute("product", this.productDAO.get(id));
		model.addAttribute("listProducts", this.productDAO.listProduct());
		model.addAttribute("categoryList", this.categoryDAO.listCategory());
		model.addAttribute("supplierList", this.supplierDAO.listSupplier());

		return "product";
	}

	@RequestMapping(value = "product/get/{id}")
	String getSelectedProduct(@PathVariable("id") String id, Model model, RedirectAttributes redirectAttributes) {
		// RedirectAttributes.addFlashAttribute("selectedproduct",productDAO.get(id));
		return "redirect/backToHome";
	}
}
