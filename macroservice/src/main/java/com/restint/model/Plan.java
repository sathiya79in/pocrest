package com.restint.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Plan {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
    private long planId;
	
	@Column(name="NAME")
	private String name;
	
	@Temporal(TemporalType.DATE)
	@Column(name="BEGIN_DATE")
	private Date beginDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="EXPIRATION_DATE")
	private Date expirationDate;
	
	@Column(name="ALLOCATED_SHARES")
	private int allocatedShares;

	protected Plan() {
	
	}

	public Plan(String name, Date beginDate, Date expirationDate, int allocatedShares) {
		super();
		this.name = name;
		this.beginDate = beginDate;
		this.expirationDate = expirationDate;
		this.allocatedShares = allocatedShares;
	}

	public long getPlanId() {
		return planId;
	}

	public void setPlanId(long planId) {
		this.planId = planId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getAllocatedShares() {
		return allocatedShares;
	}

	public void setAllocatedShares(int allocatedShares) {
		this.allocatedShares = allocatedShares;
	}
	
	
	
}
