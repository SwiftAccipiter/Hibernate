package Dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Model.member;

public interface implDao {
	//連線session
		static Session getDB()
		{
			Configuration c=new Configuration().configure();
			SessionFactory sf=c.buildSessionFactory();
			Session s=sf.openSession();
			return s;
		}
		
		//新增
		void add(Object o);
		
		
		//查詢
		List<member> query(String username,String password);//帳號密碼
		List<member> query(String username);//帳號
}
