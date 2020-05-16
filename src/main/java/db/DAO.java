package db;

import ru.billing.stocklist.GenericItem;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DAO {
    void prepareDB() throws SQLException, ClassNotFoundException;

    GenericItem getItemById(int id) throws SQLException;

    int create(GenericItem item) throws SQLException;

    default GenericItem getItem(ResultSet rs) throws SQLException {
        return new GenericItem(rs.getString("name"),
                rs.getFloat("price"));
    }
}
