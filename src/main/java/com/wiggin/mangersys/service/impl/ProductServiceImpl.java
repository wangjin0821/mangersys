package com.wiggin.mangersys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wiggin.mangersys.domain.entity.Product;
import com.wiggin.mangersys.domain.mapper.ProductMapper;
import com.wiggin.mangersys.service.ProductService;
import com.wiggin.mangersys.util.Page;
import com.wiggin.mangersys.web.vo.request.ProductPageRequest;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 产品主信息表 服务实现类
 * </p>
 *
 * @author wiggin123
 * @since 2018-09-18
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductMapper productMapper;

	@Override
	public Page<Product> getProductList(ProductPageRequest productReq) {
		Pagination pagination = productReq.getPagination();
		Wrapper<Product> wrapper = new EntityWrapper<>();
		List<Product> selectPage = productMapper.selectPage(pagination, wrapper);
		log.info("getProductList => {}", selectPage);
		return new Page<>(pagination.getTotal(), pagination.getPages(), selectPage);
	}

	@Override
	public Integer saveProduct(Product product) {
		product.setDefaultValue();
		if (product.getId() != null && product.getId() > 0) {
			return productMapper.updateById(product);
		} else {
			return productMapper.insert(product);
		}
	}

	@Override
	public Integer deleteProduct(Integer id) {
		return productMapper.deleteById(id);
	}

}
