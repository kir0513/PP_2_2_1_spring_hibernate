package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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




    public List<User> getUserByCarModelAndCarSeries(String model, int series) {
        Query query = sessionFactory.getCurrentSession()
                //.createQuery("from User where Car.model = :paramModel and Car.series = :paramSeries")
                .createQuery("from User as u where u.car.model = :paramModel and u.car.series = :paramSeries")
                .setParameter("paramModel", model)
                .setParameter("paramSeries", series);
        return (List<User>) query.getResultList();
    }



}