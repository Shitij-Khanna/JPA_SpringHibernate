package com.codegladiator.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codegladiator.order.constants.CommonConstants;
import com.codegladiator.order.entity.ISOrder;
import com.codegladiator.order.entity.ProductLineItem;
import com.codegladiator.order.repository.OrderRepository;
import com.codegladiator.order.service.OrderServiceImpl;
import com.codegladiator.order.service.ProductLineItemServiceImpl;

@RestController
@RequestMapping("order")
public class OrderExportController {

	@Autowired
	public OrderRepository orderRepository;

	@Autowired
	public OrderServiceImpl orderServiceImpl;

	@Autowired
	public ProductLineItemServiceImpl pliServiceImpl;

	@GetMapping(value = "id", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public String getDummyOrder() {
		return "Success";
	}

	@GetMapping(path = CommonConstants.FIND_ALL_ORDERS)
	public List<ISOrder> getOrders() {
		return orderRepository.findAll();
	}

	@GetMapping(path = CommonConstants.FIND_ORDER_BY_UUID, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ISOrder> getOrderByUUID(@PathVariable("uuid") String uuid) {
		ISOrder io = orderRepository.findByuuid(uuid);
		return ResponseEntity.status(HttpStatus.OK).body(io);
	}

	@GetMapping(path = CommonConstants.FIND_ALL_PLIS_TO_EXPORT)
	public ResponseEntity<List<ProductLineItem>> getPLIsToExport() {
		List<ProductLineItem> pliList = pliServiceImpl.getPLIsToExport();
		return ResponseEntity.status(HttpStatus.OK).body(pliList);
	}

}
