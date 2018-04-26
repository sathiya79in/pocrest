package com.restint.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VestTemplate {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="ID")
	    private long templateId;
	    
	    @Column(name="NAME")
	    private String templateName;
	    
	    @Column(name="MONTHS")
	    private int months;
	   
	    @Column(name="PERCENT")
	    private int percent;
	    
	    @Column(name="VEST_TYPE")
	    private String vestType;

		protected VestTemplate() {
			
		}

		public VestTemplate(String templateName, int months, int percent, String vestType) {
			super();
			this.templateName = templateName;
			this.months = months;
			this.percent = percent;
			this.vestType = vestType;
		}

		public long getTemplateId() {
			return templateId;
		}

		public void setTemplateId(long templateId) {
			this.templateId = templateId;
		}

		public String getTemplateName() {
			return templateName;
		}

		public void setTemplateName(String templateName) {
			this.templateName = templateName;
		}

		public int getMonths() {
			return months;
		}

		public void setMonths(int months) {
			this.months = months;
		}

		public int getPercent() {
			return percent;
		}

		public void setPercent(int percent) {
			this.percent = percent;
		}

		public String getVestType() {
			return vestType;
		}

		public void setVestType(String vestType) {
			this.vestType = vestType;
		}
	    
	    
	    
}
