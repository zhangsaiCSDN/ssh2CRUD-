package com.woniuxy.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ModelDriven;
import com.woniuxy.domain.Dept;
import com.woniuxy.domain.Page;
import com.woniuxy.service.IDeptService;

@Controller
@Scope("prototype")
public class DeptAction implements ModelDriven<Dept>{

	private Dept dept = new Dept();
	@Autowired                      
	private IDeptService s;
	
	private int pz;
	
	
	public String save() {
		s.save(dept);
		return "find";
	} 
	
	public String find() {
		HttpServletRequest req = ServletActionContext.getRequest();
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
 
		DetachedCriteria ds = DetachedCriteria.forClass(Dept.class);
		if(dept.getDname()!=null) {		
			ds.add(Restrictions.ilike("dname", "%"+dept.getDname()+"%"));
		}
		
		Page page = s.search(ds,p,10);
		page.setKeywords(dept.getDname());
		req.setAttribute("page", page);
		req.getSession().setAttribute("pz", p);
		return "findUI";
	}
	
	public String delete() {
		s.delete(dept.getDid());
		return "find";
	}
	
	
	public String updateUI() {
		Dept d  = s.find(dept.getDid());
		ServletActionContext.getRequest().setAttribute("dept", d);
		return "updateUI";
	}
	
	public String update() {
		s.update(dept);
		return "find";
	}
	
	public void checkName() {
		DetachedCriteria ds = DetachedCriteria.forClass(Dept.class);
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("utf-8");
		
		ds.add(Restrictions.eq("dname", dept.getDname()));
		  List list = s.search(ds).getList();
		  try {
			PrintWriter pw = resp.getWriter();
			ObjectMapper om = new  ObjectMapper();
			String json=null;
			if(list.size()<1) {
				json = om.writeValueAsString("用户名正确");	
			}else {
				json = om.writeValueAsString("用户名已存在");
			}
			pw.print(json);
		} catch (IOException e) {
			throw new RuntimeException(e); 
		} 
	}
	
	
	
	
	
	
	@Override
	public Dept getModel() {
		// TODO Auto-generated method stub
		return dept;
	}

	public int getPz() {
		return pz;
	}

	public void setPz(int pz) {
		this.pz = pz;
	}

	 
	
	

}
