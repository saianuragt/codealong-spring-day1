package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import model.Login;
import model.User;

public class UserDaoImpl implements UserDao{
	
	
	
	
	public void register(User user) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
	}


	public User validateUser(Login login) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		Query query = session.createQuery("from User where username ='"+login.getUsername()+"'and password='"+login.getPassword()+"'");
		List<User> user = query.list();
		session.close();
		return user.get(0);
	}

}
