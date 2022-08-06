package Dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Model.member;

public class memberDao implements implDao {
	public static void main(String[] args) {
		member m = new member("LLG", "324r4t4", "Aaron", "Kaoshiung", "35315253", "0950438524");
		new memberDao().add(m);
	}

	@Override
	public void add(Object o) {
		Session s = implDao.getDB();
		Transaction t = s.beginTransaction();
		s.save(o);
		t.commit();
		s.close();
		
	}

	@Override
	public List<member> query(String username, String password) {
		String HQL = "from member where username=?1 and password=?2";
		Session s = implDao.getDB();
		Query<member> q = s.createQuery(HQL);
		q.setParameter(1, username);
		q.setParameter(2, password);
		
		List<member> l = q.list();
		
		return l;
	}

	@Override
	public List<member> query(String username) {
		String HQL = "from member where username=?1";
		Session s = implDao.getDB();
		Query<member> q = s.createQuery(HQL);
		q.setParameter(1, username);
		
		
		List<member> l = q.list();
		
		return l;
	}
}
