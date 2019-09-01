package com.woniuxy.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.IEmpDao;
import com.woniuxy.domain.Emp;
import com.woniuxy.domain.Page;
import com.woniuxy.service.IEmpService;

@Service
@Transactional
public class EmpServiceImpl implements IEmpService {

	@Autowired
	private IEmpDao ed;
	
	@Override
	public void save(Emp e) {

		ed.save(e);
	}

	@Override
	public void update(Emp e) {

		ed.update(e);
	}

	@Override
	public void delete(Integer eid) {
		ed.delete(eid);
	}

	@Override
	public Emp find(Integer eid) {

		return ed.find(eid);
	}

	@Override
	public Page search(DetachedCriteria ds, int... pages) {
		int countRow = ed.rowCount(ds);
		Page page = null;
		if(pages.length>0) {
			page = new Page(pages[0], countRow, pages[1]);
		}else {
			page = new Page(1, countRow, countRow);
		}
		List<Emp> list = ed.search(ds, page.getStartLine(), page.getSize());
		page.setList(list);
		return page;
	}

}
