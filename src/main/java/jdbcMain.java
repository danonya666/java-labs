import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import db.*;
import org.bson.Document;
import ru.billing.stocklist.GenericItem;

import java.sql.Connection;
import java.sql.SQLException;

public class jdbcMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        GenericItem item1 = new GenericItem("macbook pro 15", 17800);
        GenericItem item2 = new GenericItem("macbook air 13", 17800);
        GenericItem item3 = new GenericItem("windows phone", 14000);
        // JDBC (Postgres)
        PostgresConnector pgConnector = new PostgresConnector();
        Connection pgConn = pgConnector.connectToPostgres();

        System.out.format("Postgres metadata: %s, %s\n",
                pgConn.getMetaData().getDatabaseProductName(),
                pgConn.getMetaData().getDriverName());

        GenericItemRelationalDAO pgDao = new GenericItemRelationalDAO(pgConn);

        GenericItem pgItem = pgDao.getItemById(1);
        System.out.format("Read item by id: %s\n", pgItem);

        var pgItems = pgDao.getItemsByKeyword("Schecter");
        System.out.println("Read items by keyword:");
        pgItems.forEach(GenericItem::printAll);

        // MongoClient (Mongo)
        GenericItemMongoDAO dao = new GenericItemMongoDAO();
        dao.create(item1);
        System.out.print(dao.getSomeItem());
    }
}
