package com.restint.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Award {

	
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private long id;
	   
	   @Temporal(TemporalType.DATE)
	   private Date date;
	   
	   @Column(name="MARKET_VALUE")
	   private long marketValue;
	   
	   @Column(name="SHARES")
	   private int shares;
	   
	   @Column(name="PRICE")
	   private int price;
	   
	  
	   @Column(name="PLAN_ID")
	   private long planId;
	   
	   @ManyToOne
	   @JoinColumn(name="PLAN_ID", insertable=false, updatable = false)
	   private Plan plan;
	   
	   @Column(name="NUMBER")
	   private int number;
	   
	 
	   @Column(name="TEMPLATE_ID")
	   private long templateId;
	   
	   @ManyToOne
	   @JoinColumn(name="TEMPLATE_ID", insertable=false, updatable = false)
	   private VestTemplate vestTemplate;
	   
	   @Column(name="EMPLOYEE_ID")
	   private long employeeId;

	   @OneToOne
	   @JoinColumn(name="EMPLOYEE_ID",insertable=false, updatable = false)
	   private Employee employee;
	   
	   
	   
       public VestTemplate getVestTemplate() {
		return vestTemplate;
	}

	public void setVestTemplate(VestTemplate vestTemplate) {
		this.vestTemplate = vestTemplate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Award(Date date,long marketValue, int shares, int price, long planId, int number, long templateId, long employeeId) {
		super();
		this.date=date;
		this.marketValue = marketValue;
		this.shares = shares;
		this.price = price;
		this.planId = planId;
		this.number = number;
		this.templateId = templateId;
		this.employeeId = employeeId;
	}

	protected Award() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(long marketValue) {
		this.marketValue = marketValue;
	}

	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public long getPlanId() {
		return planId;
	}

	public void setPlanId(long planId) {
		this.planId = planId;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(long templateId) {
		this.templateId = templateId;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	   
	   
	   
}
