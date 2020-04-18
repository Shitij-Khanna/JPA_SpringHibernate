package com.codegladiator.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codegladiator.order.entity.ProductLineItem;

public interface ProductLineItemRepository extends JpaRepository<ProductLineItem, Long> {

	public List<ProductLineItem> findByStatus(final int status);
	
}
