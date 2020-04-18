package com.codegladiator.order.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "productlineitem_av")
public class PLIAttributes {

	@Embeddable
	public static class Id implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 201409011154L;

		@NotNull
		private String name;

		public Id() {
		}

		public Id(String name) {
			super();
			this.name = name;
		}


		public String getName() {
			return name;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Id other = (Id) obj;
			
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
		
		@Override
		public String toString() {
			return String.format(name);
		}

	}

	@EmbeddedId
	@NotNull
	private Id id;
	
	private String domainid;

	private Integer localizedflag;

	@NotNull
	private Integer type;

	private Integer intvalue;

	private Float doublevalue;
	
	@Size(max = 4000)
	private String stringvalue;
	
	@Digits(integer = 32, fraction = 6)
	private BigDecimal decimalvalue;
	
	private Date datevalue;
	
	@Lob
	private String textvalue;
	
	@NotNull
	private Integer oca;
	
	@NotNull
	private Date lastmodified;

	public String getDomainid() {
		return domainid;
	}

	public void setDomainid(String domainid) {
		this.domainid = domainid;
	}

	public Integer getLocalizedflag() {
		return localizedflag;
	}

	public void setLocalizedflag(Integer localizedflag) {
		this.localizedflag = localizedflag;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getIntvalue() {
		return intvalue;
	}

	public void setIntvalue(Integer intvalue) {
		this.intvalue = intvalue;
	}

	public Float getDoublevalue() {
		return doublevalue;
	}

	public void setDoublevalue(Float doublevalue) {
		this.doublevalue = doublevalue;
	}

	public String getStringvalue() {
		return stringvalue;
	}

	public void setStringvalue(String stringvalue) {
		this.stringvalue = stringvalue;
	}

	public BigDecimal getDecimalvalue() {
		return decimalvalue;
	}

	public void setDecimalvalue(BigDecimal decimalvalue) {
		this.decimalvalue = decimalvalue;
	}

	public Date getDatevalue() {
		return datevalue;
	}

	public void setDatevalue(Date datevalue) {
		this.datevalue = datevalue;
	}

	public String getTextvalue() {
		return textvalue;
	}

	public void setTextvalue(String textvalue) {
		this.textvalue = textvalue;
	}

	public Integer getOca() {
		return oca;
	}

	public void setOca(Integer oca) {
		this.oca = oca;
	}

	public Date getLastmodified() {
		return lastmodified;
	}

	public void setLastmodified(Date lastmodified) {
		this.lastmodified = lastmodified;
	}
	
}
