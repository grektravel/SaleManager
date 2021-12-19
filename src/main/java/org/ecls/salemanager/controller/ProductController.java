package org.ecls.salemanager.controller;

import java.util.Map;

import org.ecls.salemanager.model.Product;
import org.ecls.salemanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = { "/", "/listProducts" })
	public String listProducts(Map<String, Object> map) {

		map.put("product", new Product());

		map.put("productList", productService.getAllProduct());

		return "/product/listProducts";
	}

	@RequestMapping("/get/{productId}")
	public String getBook(@PathVariable Integer productId, Map<String, Object> map) {

		Product book = productService.getProduct(productId);

		map.put("product", book);

		return "/product/productForm";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute("product") Product product, BindingResult result) {

		productService.save(product);

		/*
		 * Note that there is no slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the current path
		 */
		return "redirect:listProducts";
	}

	@RequestMapping("/delete/{productId}")
	public String deleteBook(@PathVariable("productId") Integer id) {

		productService.delete(id);

		/*
		 * redirects to the path relative to the current path
		 */
		// return "redirect:../listProducts";

		/*
		 * Note that there is the slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the project root path
		 */
		return "redirect:/product/listProducts";
	}
}