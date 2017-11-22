package com.rs.training;

import java.util.List;


import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public User getUserFromUsername(String username) {
		String hql  = "from User u  where u.userName = '" + username + "'";
		Session session = sessionFactory.openSession();
		List result2=  session.createQuery(hql).list();
		if(result2.size() > 0)
		{
			return (User)result2.get(0);
		}
		return null;
	}

	public boolean addUser(User user) {
		
		Session session  = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		session.save(user);
		tx.commit();
		return true;
	}
	
}
