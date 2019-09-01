package com.woniuxy.service;

import org.hibernate.criterion.DetachedCriteria;

import com.woniuxy.domain.Dept;
import com.woniuxy.domain.Emp;
import com.woniuxy.domain.Page;

public interface IEmpService {

	void save(Emp e);
	void update(Emp e);
	void delete(Integer eid);
	Emp find(Integer eid);
	Page search(DetachedCriteria ds,int... pages);
}
