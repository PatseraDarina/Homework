package Homework17.jdbc;

import Homework17.jdbc.dao.AbstractDaoFactory;
import Homework17.jdbc.dao.GenericDao;
import Homework17.jdbc.model.User;
import Homework17.jdbc.model.UserRole;

import java.util.Random;

public class JdbcUserTest {
    public static void main(String[] args) {
        GenericDao<User, Long> userDao =
                AbstractDaoFactory.getDaoFactory(User.class).getDao();

        System.out.println(userDao.read(1L));

        User user = createRandomClient();

        userDao.create(user);

       // User user = userDao.read(1L);

        /*user.setLastName("New");
        user.setName("New");

        GenericDao<UserRole, Long> userRoleDao = AbstractDaoFactory.getDaoFactory(UserRole.class).getDao();
        UserRole admin = userRoleDao.read(1L);
        user.setUserRole(admin);
        userDao.update(user);*/

      //  userDao.delete(user);

    }

    private static User createRandomClient() {
        GenericDao<UserRole, Long> userRoleDao = AbstractDaoFactory.getDaoFactory(UserRole.class).getDao();
        User user = new User();
        user.setName(randomString());
        user.setLastName(randomString());
        user.setLogin(randomString());
        user.setPassword(randomString());
        user.setEmail(randomString());
        user.setUserRole(userRoleDao.read(2L));
        return user;
    }

    private static String randomString() {
        Random random = new Random();
        int length = random.nextInt(5) + 3;
        char[] result = new char[length];
        for (int i = 0; i < length; i++) {
            result[i] = (char) ((random.nextInt(26) + 65) + (random.nextInt(2) * 32)) ;
        }
        return String.valueOf(result);
    }
}

