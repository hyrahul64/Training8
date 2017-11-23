package com.rs.training.jdbc;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rs.training.model.User;
import com.rs.training.model.UserDetail;

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
		UserDetail userDetail = new UserDetail();
		userDetail.setUser(user);
		session.save(userDetail);
		tx.commit();
		return true;
	}

	public boolean addUserDetail(String userName, UserDetail userDetail) {
		
		Session session = sessionFactory.openSession();
		User user = (User)session.load(User.class, userName);
		if(user != null)
		{
			userDetail.setUser(user);
			//session.merge(userDetail);
			Transaction tx  = session.beginTransaction();
			session.saveOrUpdate(userDetail);
			tx.commit();
			return true;
		}
		return false;
/*		UserDetail old = (UserDetail) session.load(UserDetail.class, userDetail.getUser().getUserName());
		old.setUserFirstName(userDetail.getUserFirstName());
		old.setUserLastName(userDetail.getUserLastName());
		old.setUserEmail(userDetail.getUserEmail());
		old.setUserMobile(userDetail.getUserMobile());
		old.setUserAddress(userDetail.getUserAddress());
		old.setUserGender(userDetail.getUserGender());
		old.setUserBirthdate(userDetail.getUserBirthdate());
		session.merge(old);
		tx.commit();
		return true;
*/	}

	public UserDetail getUserDetail(String userName) {
		
		Session session = sessionFactory.openSession();
		UserDetail userDetail = (UserDetail)session.load(UserDetail.class, userName);
		return userDetail;
	}
	
}
