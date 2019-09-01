package com.woniuxy.service;

import org.hibernate.criterion.DetachedCriteria;

import com.woniuxy.domain.Dept;
import com.woniuxy.domain.Page;

public interface IDeptService {

	void save(Dept d);
	void update(Dept d);
	void delete(Integer did);
	Dept find(Integer did);
	Page search(DetachedCriteria ds,int... pages);
}
