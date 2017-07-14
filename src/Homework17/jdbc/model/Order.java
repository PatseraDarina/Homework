package Homework17.jdbc.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Дарина on 14.07.2017.
 */
public class Order extends BaseEntity<Long> {
    private String  metainf;
    private Long userId;
    private Integer amount;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getMetainf(){
        return this.metainf;
    }

    public void setMetainf(String metainf){
        this.metainf = metainf;
    }

    @Override
    public void prepareCreateStatement(PreparedStatement stmt) throws SQLException {
        stmt.setInt(1, amount);
        stmt.setString(2, metainf);
        stmt.setLong(3, userId);
    }

    @Override
    public void prepareReadStatement(PreparedStatement stmt, Long id) throws SQLException {
        stmt.setLong(1, id);
    }

    @Override
    public void setDataFromResultSet(ResultSet resultSet) throws SQLException {
        metainf = resultSet.getString("metainf");
        userId = resultSet.getLong("user_id");
        amount = resultSet.getInt("amount");
    }

    @Override
    public void prepareUpdateStatement(PreparedStatement stmt) throws SQLException {
        stmt.setInt(1, amount);
        stmt.setString(2, metainf);
        stmt.setLong(3, userId);
        stmt.setLong(4, id);
    }

    @Override
    public String toString() {
        return "Order{ id = " + this.id +
                " metainf = " + this.metainf +
                "amount = " + this.amount +
                "user_Id = " + this.userId;
    }

    @Override
    public int hashCode() {
        return (int)(id % Integer.MAX_VALUE);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(!(obj instanceof Order)) return false;

        Order order = (Order) obj;
        if (metainf != null ? !metainf.equals(order.metainf) : order.metainf != null) return false;
        if (amount != null ? !amount.equals(order.amount) : order.amount != null) return false;
        if (userId != null ? !userId.equals(order.userId) : order.userId != null) return false;
        return (metainf != null ? !metainf.equals(order.metainf) : order.metainf != null);
    }
}
