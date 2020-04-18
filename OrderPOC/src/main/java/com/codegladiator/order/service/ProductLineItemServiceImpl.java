package com.codegladiator.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegladiator.order.entity.ProductLineItem;
import com.codegladiator.order.repository.ProductLineItemRepository;
import com.codegladiator.order.service.contract.ProductLineItemService;

@Service
public class ProductLineItemServiceImpl implements ProductLineItemService {

	
	@Autowired
	public ProductLineItemRepository pliRepository;
	
	public List<ProductLineItem> getPLIsToExport(){
		List<ProductLineItem> pliList = pliRepository.findByStatus(10);
		return pliList;
	}
}
