package com.woniuxy.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniuxy.dao.IEmpDao;
import com.woniuxy.domain.Dept;
import com.woniuxy.domain.Emp;

@Repository
public class EmpDaoImpl implements IEmpDao {

	private static final String Long = null;
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void save(Emp e) {
		getSession().save(e);
	}

	@Override
	public void update(Emp e) {
		getSession().update(e);
	}

	@Override
	public void delete(Integer eid) {
		getSession().delete(getSession().get(Emp.class, eid));

	}

	@Override
	public Emp find(Integer eid) {
		
		return getSession().get(Emp.class, eid);
	}

	@Override
	public int rowCount(DetachedCriteria ds) {
		
		Criteria c=null;
		if(ds!=null) {
			c = ds.getExecutableCriteria(getSession());
		}else {
			c = getSession().createCriteria(Emp.class);
		}
		c.setProjection(Projections.count("eid"));
		Long countRow = (Long) c.uniqueResult();
		c.setProjection(null);
		return countRow.intValue();
	}

	@Override
	public List<Emp> search(DetachedCriteria ds, int... pages) {
		Criteria c =null;
		if(ds!=null) {
			c = ds.getExecutableCriteria(getSession());
		}else {
			c = getSession().createCriteria(Emp.class);
		}
		
		if(pages.length>0) {
			c.setFirstResult(pages[0]);
			c.setMaxResults(pages[1]);
		}
		return c.list();
	}

}
