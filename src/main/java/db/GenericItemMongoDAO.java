package db;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import ru.billing.stocklist.GenericItem;

import javax.print.Doc;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenericItemMongoDAO implements DAO{
    private MongoCollection<Document> collection;
    private MongoConnector mongoConnector;

    public GenericItemMongoDAO() throws SQLException, ClassNotFoundException {
        this.prepareDB();
    }

    @Override
    public void prepareDB() throws SQLException, ClassNotFoundException {
        mongoConnector = new MongoConnector();
        collection = mongoConnector.getCollection();
    }

    @Override
    public GenericItem getItemById(int id) throws SQLException {
        Document myDoc = (Document)collection.find(Filters.eq("id", id)).first();
        return new GenericItem(myDoc);
    }

    public Document getSomeItem() throws SQLException {
        return (Document)collection.find().sort(new BasicDBObject("_id",-1)).first();
    }

    @Override
    public int create(GenericItem item) throws SQLException {
        Document newItem = new Document()
                .append("name", item.getName())
                .append("category", item.getCategory().toString())
                .append("price", item.getPrice())
                .append("id", item.getId());
        collection.insertOne(newItem);
        return 0;
    }
}
