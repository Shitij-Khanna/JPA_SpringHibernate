package com.codegladiator.order.entity;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="PRODUCTLINEITEM")
public class ProductLineItem {

	@Id
	private String uuid;
	
	@Column(name = "PRODUCTNAME")
	public String productName;
	
	@Column(name="OFFERPRODUCTREFPRODUCTSKU")
	private String productSKU;

//	@Column(name = "LINEITEMCTNRID")
//	private String lineItemCtnrID;
	
	@ManyToOne
	@JoinColumn(name = "lineitemctnrid")
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private ISOrder order;
	
	private int status;
	
	@Column(name = "OFFERPRODUCTREFDOMAINNAME")
	private String domainName;
	
	@OneToMany
	@JoinColumn(name = "ownerid")
	@MapKey(name = "id")
	private Map<String, PLIAttributes> pliAttributes;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductSKU() {
		return productSKU;
	}

	public void setProductSKU(String productSKU) {
		this.productSKU = productSKU;
	}

//	public String getLineItemCtnrID() {
//		return lineItemCtnrID;
//	}
//
//	public void setLineItemCtnrID(String lineItemCtnrID) {
//		this.lineItemCtnrID = lineItemCtnrID;
//	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public ISOrder getOrder() {
		return order;
	}

	public void setOrder(ISOrder order) {
		this.order = order;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Map<String, PLIAttributes> getPliAttributes() {
		return pliAttributes;
	}

	public void setPliAttributes(Map<String, PLIAttributes> pliAttributes) {
		this.pliAttributes = pliAttributes;
	}
	
}
