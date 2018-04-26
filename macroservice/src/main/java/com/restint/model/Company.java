package com.restint.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="ID")
	    private long companyId;
	    
	    @Column(name="NAME")
	    private String name;
	    
	    @Column(name="SYMBOL")
	    private String symbol;
	   
	    @Column(name="CORP_ID")
	    private long corpId;

		protected Company() {
			
		}

		public Company(String name, String symbol, long corpId) {
			super();
			this.name = name;
			this.symbol = symbol;
			this.corpId = corpId;
		}

		public long getCompanyId() {
			return companyId;
		}

		public void setCompanyId(long companyId) {
			this.companyId = companyId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSymbol() {
			return symbol;
		}

		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}

		public long getCorpId() {
			return corpId;
		}

		public void setCorpId(long corpId) {
			this.corpId = corpId;
		}	
	    
}

