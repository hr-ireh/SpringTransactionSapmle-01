package ir.hri.repository.impl;

import ir.hri.entities.User;
import ir.hri.repository.UserRepository;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Scope(value = "singleton")
public class UserRepositoryImpl extends HibernateDaoSupport implements UserRepository {

    @Autowired
    public UserRepositoryImpl(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    @Transactional
    public void insertUser(User user) {
        getHibernateTemplate().saveOrUpdate(user);
    }

    @Override
    @Transactional
    public User getUserById(int userId) {
        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        return (User) session.get(User.class, userId);
    }

    @Override
    @Transactional
    public User getUser(String username) {
        Query query = getHibernateTemplate().getSessionFactory()
                .getCurrentSession()
                .createQuery("from ir.hri.entities.User t where t.username = :username");
        query.setParameter("username", username);
        return (User) query.list().get(0);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public List<User> getUsers() {
        Criteria criteria = getHibernateTemplate().getSessionFactory()
                .getCurrentSession()
                .createCriteria(User.class);
        return criteria.list();
    }
}
