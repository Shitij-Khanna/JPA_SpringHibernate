package com.codegladiator.order.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "ISORDER")
public class ISOrder {
	
	@Id
	private String uuid;

	@Column(name = "DOCUMENTNO")
	private String documentNo;
	
	@Column(name = "GRANDTOTALNETPRICELCCODE")
	private String orderAmount;
	
	@Column(name = "CUSTOMERID")
	private String customerID;
	
	@Column(name= "BUYERNAME")
	private String buyerName;
	
	@Column(name="CUSTOMERNO")
	private String customerNo;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
	private List<ProductLineItem> productLineItems = new ArrayList<ProductLineItem>();
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "userid")
	@NotFound(action = NotFoundAction.IGNORE)
	private BasicProfile profile;
	
	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	
	public String getUuid() {
		return uuid;
	}
	
	public List<ProductLineItem> getProductLineItems() {
		return productLineItems;
	}

	public void setProductLineItems(List<ProductLineItem> productLineItems) {
		this.productLineItems = productLineItems;
	}

	public BasicProfile getProfile() {
		return profile;
	}

	public void setProfile(BasicProfile profile) {
		this.profile = profile;
	}

	public String getDocumentNo() {
		return documentNo;
	}

	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}

	public String getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}

	@Override
	public String toString() {
		return String.format("Order[%s]", "");
	}
	
}
