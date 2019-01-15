package com.wiggin.mangersys.service;

import com.wiggin.mangersys.domain.entity.Product;
import com.wiggin.mangersys.util.Page;
import com.wiggin.mangersys.web.vo.request.ProductPageRequest;

/**
 * <p>
 * 产品主信息表 服务类
 * </p>
 *
 * @author wiggin123
 * @since 2018-09-18
 */
public interface ProductService {
	
	Page<Product> getProductList(ProductPageRequest productReq);
	
	Integer saveProduct(Product product);
	
	Integer deleteProduct(Integer id);
	
}
