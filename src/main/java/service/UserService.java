package service;

import com.example.todo.Entities.Task;
import com.example.todo.Entities.User;
import dao.UserDao;
import org.hibernate.Session;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class UserService {

    private UserDao usersDao = new UserDao();

    public UserService() {
    }

    public User findUser(String id) {
        return usersDao.findByName(id);
    }

    public void saveUser(User user) {
        usersDao.save(user);
    }

    public void deleteUser(User user) {
        usersDao.delete(user);
    }

    public void updateUser(User user) {
        usersDao.update(user);
    }

    public List<User> findAllUsers() {
        return usersDao.findAll();
    }

    public List findAllTasks() {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().createCriteria(Task.class).list();
    }
}