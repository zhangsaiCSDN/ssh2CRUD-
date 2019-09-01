package com.woniuxy.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.woniuxy.domain.Emp;
import com.woniuxy.domain.Page;
import com.woniuxy.service.IDeptService;
import com.woniuxy.service.IEmpService;

@Controller
@Scope("prototype")
public class EmpAction implements ModelDriven<Emp>{

	private Emp emp = new Emp();
	
	private int pz;
	
	@Autowired
	private IEmpService es;
	@Autowired
	private IDeptService ds;
	
	public String save() {
		es.save(emp);
		return "find";
	}
	
	public String find() {
		HttpServletRequest req = ServletActionContext.getRequest();
		DetachedCriteria ds = DetachedCriteria.forClass(Emp.class);
		if(emp.getEname()!=null) {
			
			ds.add(Restrictions.ilike("ename", "%"+emp.getEname()+"%"));
		}
//		System.out.println(emp);
//		System.out.println(emp.getEname());
		int p=0;
		if(pz!=0) {
			p=pz;
		}else {
			Integer temp = (Integer) req.getSession().getAttribute("pz");
			if(temp==null) {
				p=1;
			}else {
				p=temp;
			}
		}
		
		Page page = es.search(ds,p,3);
		page.setKeywords(emp.getEname());
		req.setAttribute("page", page);
		req.getSession().setAttribute("pz", p);
		return "findUI";
	}
	
	public String delete() {
		es.delete(emp.getEid());
		return "find";
	}
	
	public String update() {

		es.update(emp);
		return "find";
	}
	
	public String saveUI() {
		Page page = ds.search(null);
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("page", page);
		
		return "saveUI";
	}
	
	public String updateUI() {
		System.out.println(emp);
		System.out.println(emp.getEname());
		Emp emp2 = es.find(emp.getEid());
		  List list = ds.search(null).getList();
		ServletActionContext.getRequest().setAttribute("emp", emp2);
		ServletActionContext.getRequest().setAttribute("deptlist", list);
		return "updateUI";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int getPz() {
		return pz;
	}

	public void setPz(int pz) {
		this.pz = pz;
	}

	@Override
	public Emp getModel() {
		// TODO Auto-generated method stub
		return emp;
	}
	
	
}
