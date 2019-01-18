package com.wiggin.mangersys.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wiggin.mangersys.domain.entity.Product;
import com.wiggin.mangersys.service.ProductService;
import com.wiggin.mangersys.util.Page;
import com.wiggin.mangersys.web.vo.request.ProductPageRequest;

/**
 * <p>
 * 产品主信息表 前端控制器
 * </p>
 *
 * @author wiggin123
 * @since 2018-09-18
 */
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/list")
	public Page<Product> getProductList(@RequestBody ProductPageRequest productReq) {
		return productService.getProductList(productReq);
	}
	
	@PostMapping("/add")
	public void add(@RequestBody Product product) {
		productService.saveProduct(product);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestParam("id") Integer id) {
		productService.deleteProduct(id);
	}
}

