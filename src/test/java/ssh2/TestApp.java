package ssh2;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.woniuxy.domain.Dept;
import com.woniuxy.service.IDeptService;

public class TestApp {

	@Test
	public void test() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		IDeptService s = (IDeptService) ac.getBean("deptServiceImpl");
		s.delete(25);
	 
		
	}
}
