package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }
   @Override
   public User getCarOwner(String mod, int ser) {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User u inner join fetch  u.car  car where car.model = :paramMode and car.serial =:paramSer")
              .setParameter("paramMode",  mod)
              .setParameter("paramSer", ser);
      return  query.getSingleResult();
   }
}
