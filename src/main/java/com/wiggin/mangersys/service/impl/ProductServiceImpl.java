package com.wiggin.mangersys.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wiggin.mangersys.domain.entity.Product;
import com.wiggin.mangersys.domain.entity.ProductDesc;
import com.wiggin.mangersys.domain.mapper.ProductDescMapper;
import com.wiggin.mangersys.domain.mapper.ProductMapper;
import com.wiggin.mangersys.service.ProductService;
import com.wiggin.mangersys.util.Page;
import com.wiggin.mangersys.util.apifeignclient.eccang.EccangApi;
import com.wiggin.mangersys.util.apifeignclient.eccang.bean.EccangProductRequest;
import com.wiggin.mangersys.util.apifeignclient.eccang.bean.EccangProductResponse;
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
	
	@Autowired
	private EccangApi eccangApi;
	
	@Autowired
	private ProductDescMapper productDescMapper;

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

	@Override
	public Integer syncProductList() {
		int returnCount = 0;
		EccangProductRequest productReq = new EccangProductRequest();
		/*Wrapper<Product> wrapper = new EntityWrapper<>();
		wrapper.orderBy("product_add_time");
		wrapper.orderDesc(columns)
		List<Product> selectList = productMapper.selectList(wrapper);*/
		Page<EccangProductResponse> productPage = eccangApi.getProductList(productReq);
		if (productPage == null) {
			return returnCount;
		}
		int totalCount = productPage.getTotalCount();
		int pageSize = eccangApi.getPageSize().intValue();
		int pages = (int) Math.ceil(totalCount/pageSize);
		log.info("pages=>{}", pages);
		List<EccangProductResponse> productList = productPage.getList();
		returnCount += saveEccangProductList(productList);
		for(int i = 2; i <= pages; i++) {
			Page<EccangProductResponse> productPageTemp = eccangApi.getProductList(productReq);
			if (productPage == null) {
				return returnCount;
			}
			List<EccangProductResponse> productResponseList = productPageTemp.getList();
			returnCount += saveEccangProductList(productResponseList);
		}
		return returnCount;
	}
	
	
	/**
	 * 
	 * @param productList
	 * @return
	 */
	private Integer saveEccangProductList(List<EccangProductResponse> productList) {
		int returnCount = 0;
		if (CollectionUtils.isEmpty(productList)) {
			return returnCount;
		}
		for (EccangProductResponse eccangProductResponse : productList) {
			Product product = new Product();
			Product productEntity = new Product();
			BeanUtils.copyProperties(eccangProductResponse, product);
			productEntity.setProductSku(product.getProductSku());
			Product selectOne = productMapper.selectOne(productEntity);
			Integer productId = null;
			if (selectOne != null && selectOne.getId() != null) {
				productId = selectOne.getId();
				product.setId(selectOne.getId());
				product.setUpdateTime(new Date());
				productMapper.updateById(product);
			} else {
				product.setDefaultValue();
				Integer insert = productMapper.insert(product);
				if (insert > 0) {
					productId = product.getId();
				}
			}
			if (productId != null) {
				ProductDesc productDesc = new ProductDesc();
				productDesc.setProductId(productId);
				ProductDesc productDescOne = productDescMapper.selectOne(productDesc);
				BeanUtils.copyProperties(eccangProductResponse, productDesc);
				if (productDescOne != null && productDescOne.getId() != null) {
					productDesc.setId(productDescOne.getId());
					productDescMapper.updateById(productDesc);
				} else {
					productDescMapper.insert(productDesc);
				}
			}
			returnCount++;
		}
		return returnCount;
	}

}
