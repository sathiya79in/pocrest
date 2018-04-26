package com.restint.appstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.restint.controllers.AwardsController;
import com.restint.model.Award;
import com.restint.model.Company;
import com.restint.model.Employee;
import com.restint.model.Plan;
import com.restint.model.VestTemplate;
import com.restint.repository.AwardDao;
import com.restint.repository.CompanyDao;
import com.restint.repository.EmployeeDao;
import com.restint.repository.PlanDao;
import com.restint.repository.VestTemplateDao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* temporary data feeder for the employee table
 */
 
@Component
public class TempDataFeeder implements CommandLineRunner {
	
	@Autowired
	private EmployeeDao employeeDao;
	 
	@Autowired
	private AwardDao awardDao;
	
	@Autowired
	private CompanyDao companyDao;
	
	@Autowired
	private PlanDao planDao;
	
	@Autowired
	private VestTemplateDao vestTemplateDao;
   
    public TempDataFeeder(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }

    public Date convertToDate(LocalDate localDate) {
    	Date date = java.sql.Date.valueOf(localDate);
    	return date;
    }
    
    
    
   
	@Override
    public void run(String... strings) throws Exception {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("Marr", "Nova"));
        employeeList.add(new Employee("Bais","Habl"));
        employeeList.add(new Employee("Novotel", "Htl"));

        employeeDao.saveAll(employeeList);
        employeeDao.flush();
        
        List<Plan> planList = new ArrayList<>();

        planList.add(new Plan("Equity plan",convertToDate(LocalDate.of(2018, 1,31)),convertToDate(LocalDate.of(2018, 12, 31)),500 ));
        planList.add(new Plan("Test plan",convertToDate(LocalDate.of(2016, 1,31)),convertToDate(LocalDate.of(2018, 12, 31)),500 ));
        planList.add(new Plan("Stock plan",convertToDate(LocalDate.of(2008, 1,31)),convertToDate(LocalDate.of(2018, 12, 31)),500 ));

        planDao.saveAll(planList);
        planDao.flush();
        
        List<VestTemplate> templateList = new ArrayList<>();

        templateList.add(new VestTemplate("Quarterly",67,25, "Nova"));
        templateList.add(new VestTemplate("Semi",56,50,"Habl"));
        templateList.add(new VestTemplate("Annual",62,100, "Htl"));

        vestTemplateDao.saveAll(templateList);
        vestTemplateDao.flush();
       
        
        List<Company> companyList = new ArrayList<>();

        companyList.add(new Company("APPLE","APPL", 123));
        companyList.add(new Company("GOOGLE","GOOG",234));
        companyList.add(new Company("INTEL", "INTL", 623));
        
        companyDao.saveAll(companyList);
        companyDao.flush();
        
       /* System.out.println(planDao.findAll().get(1).toString());*/

        Award award=new Award(convertToDate(LocalDate.of(2018, 12, 31)),54, 452, 35, 2,17, 2, 1);
        
        awardDao.saveAndFlush(award);

    }
}
