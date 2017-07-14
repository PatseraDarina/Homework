package Homework17.jdbc;

import Homework17.jdbc.dao.AbstractDaoFactory;
import Homework17.jdbc.dao.GenericDao;
import Homework17.jdbc.model.UserRole;

public class JdbcUserRoleTest {
    public static void main(String[] args) {
        GenericDao<UserRole, Long> userRoleDao =
                AbstractDaoFactory.getDaoFactory(UserRole.class).getDao();

        System.out.println(userRoleDao.read(1L));


        /*UserRole role = new UserRole();
        role.setRole("New Role");
        long id = userRoleDao.create(role);
        System.out.println("Role created " + role + "with id = " + id);
*/
        UserRole role = userRoleDao.read(3L);
        role.setRole("New Role1");
        //role.setId(6L);
        userRoleDao.update(role);
        //userRoleDao.delete(role);*/
    }
}
