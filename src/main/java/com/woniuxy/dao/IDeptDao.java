package com.woniuxy.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.woniuxy.domain.Dept;

public interface IDeptDao {
	void save(Dept d);
	void update(Dept d);
	void delete(Integer did);
	Dept find(Integer did);
	
	int rowCount(DetachedCriteria ds);
	List<Dept> search(DetachedCriteria ds,int... pages);
}
