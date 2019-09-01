package com.woniuxy.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.IDeptDao;
import com.woniuxy.domain.Dept;
import com.woniuxy.domain.Page;
import com.woniuxy.service.IDeptService;

@Service
@Transactional
public class DeptServiceImpl implements IDeptService {

	@Autowired
	private IDeptDao dd;
	@Override
	public void save(Dept d) {

		dd.save(d);
	}

	@Override
	public void update(Dept d) {
		dd.update(d);
	}

	@Override
	public void delete(Integer did) {

		dd.delete(did);
	}

	@Override
	public Dept find(Integer did) {
		
		return dd.find(did);
	}


	@Override
	public Page search(DetachedCriteria ds, int... pages) {
		 int countRow = dd.rowCount(ds);
		 Page page = null;
		 if(pages.length>0) {
			 page = new Page(pages[0], countRow, pages[1]);
		 }else {
			 page = new Page(1, countRow, countRow);
		 }
		 List<Dept> list = dd.search(ds, page.getStartLine(),page.getSize());
		 page.setList(list);
		return page;
	}

}
