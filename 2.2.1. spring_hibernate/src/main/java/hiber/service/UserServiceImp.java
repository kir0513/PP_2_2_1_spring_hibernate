package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Override
   @Transactional(readOnly = true)
   //public User getSingelUserByCarModelAndCarSeries(String model, int series) {
     // return userDao.getSingelUserByCarModelAndCarSeries(model, series);
   public List<User> getUserByCarModelAndCarSeries(String model, int series) {
      return (List<User>)userDao.getUserByCarModelAndCarSeries(model, series);
   }
}
