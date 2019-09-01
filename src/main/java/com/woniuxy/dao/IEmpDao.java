package com.woniuxy.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.woniuxy.domain.Dept;
import com.woniuxy.domain.Emp;

public interface IEmpDao {
	void save(Emp e);
	void update(Emp e);
	void delete(Integer eid);
	Emp find(Integer eid);
	
	int rowCount(DetachedCriteria ds);
	List<Emp> search(DetachedCriteria ds,int... pages);
}
