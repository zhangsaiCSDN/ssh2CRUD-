package com.woniuxy.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniuxy.dao.IDeptDao;
import com.woniuxy.domain.Dept;

@Repository
public class DeptDaoImpl implements IDeptDao {

	@Autowired
	private SessionFactory sf;
	
	public Session getSession() {
		return sf.getCurrentSession();
	}
	
	@Override
	public void save(Dept d) {
		getSession().save(d);
	}

	@Override
	public void update(Dept d) {
		getSession().update(d);
	}

	@Override
	public void delete(Integer did) {
		Dept dept = getSession().get(Dept.class, did);
		getSession().delete(dept);
	}

	@Override
	public Dept find(Integer did) {
		
		return getSession().get(Dept.class, did);
	}

	@Override
	public int rowCount(DetachedCriteria ds) {
		Criteria c=null;
		if(ds!=null) {
			c = ds.getExecutableCriteria(getSession());
		}else {
			c = getSession().createCriteria(Dept.class);
		}
		c.setProjection(Projections.count("did"));
		Long row = (Long) c.uniqueResult();
		
		c.setProjection(null);
		return row.intValue();
	}

	@Override
	public List<Dept> search(DetachedCriteria ds, int... pages) {
		Criteria c =null;
		if(ds!=null) {
			c  = ds.getExecutableCriteria(getSession());
		}else {
			c = getSession().createCriteria(Dept.class);
		}
		
		if(pages.length>0) {
			c.setFirstResult(pages[0]);
			c.setMaxResults(pages[1]);
		}
		
		return c.list();
	}

}
