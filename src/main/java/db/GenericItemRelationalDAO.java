package db;

import ru.billing.stocklist.GenericItem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class GenericItemRelationalDAO implements DAO {
    private boolean dbReady;
    private Connection conn;

    public GenericItemRelationalDAO(Connection conn) {
        this.dbReady = false;
        this.conn = conn;
    }

    @Override
    public void prepareDB() throws SQLException {
        var query = "CREATE TABLE IF NOT EXISTS items "
                + "(id INTEGER PRIMARY KEY, name VARCHAR(255), price DECIMAL);";
        var stmt = this.conn.prepareStatement(query);
        stmt.execute();
        this.dbReady = true;
    }

    @Override
    public GenericItem getItemById(int id) throws SQLException {
        if (!this.dbReady) {
            this.prepareDB();
        }

        var query = "SELECT * FROM items WHERE id=?";
        var stmt = this.conn.prepareStatement(query);
        stmt.setInt(1, id);

        var results = stmt.executeQuery();

        if (!results.next()) {
            return null;
        }

        return this.getItem(results);
    }

    public List<GenericItem> getItemsByKeyword(String keyword) throws SQLException {
        if (!this.dbReady) {
            this.prepareDB();
        }

        var query = "SELECT * FROM items WHERE name LIKE ?";
        var stmt = this.conn.prepareStatement(query);
        stmt.setString(1, String.format("%%%s%%", keyword));

        var results = stmt.executeQuery();

        var resultList = new LinkedList<GenericItem>();
        while (results.next()) {
            resultList.add(this.getItem(results));
        }

        return resultList;
    }

    @Override
    public int create(GenericItem item) throws SQLException {
        if (!this.dbReady) {
            this.prepareDB();
        }

        var query = "INSERT INTO items VALUES (?, ?, ?)";
        var stmt = this.conn.prepareStatement(query);

        stmt.setInt(1, item.getId());
        stmt.setString(2, item.getName());
        stmt.setFloat(3, item.getPrice());

        var result = stmt.executeUpdate();
        return result;
    }

}
