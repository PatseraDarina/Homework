package Homework17.jdbc;

import java.lang.*;
import Homework17.jdbc.dao.AbstractDaoFactory;
import Homework17.jdbc.dao.GenericDao;
import Homework17.jdbc.model.Order;

/**
 * Created by Дарина on 14.07.2017.
 */
public class OrderTest {
    public static void main(String[] args) {
        GenericDao<Order, Long> orderDAO = AbstractDaoFactory.getDaoFactory(Order.class).getDao();
        System.out.print(orderDAO.read(5L));
        Order or = new Order();
        or.setAmount(1234);
        or.setMetainf("qwerty");
        or.setUserId(4L);
        orderDAO.create(or);
    }
}
