package mongodb;
import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongodbDataSource {
	static final String URL = "localhost";
	static final String DB = "Facultate";
	
	static final int PORT = 27017;

	public DB getConnection(){
        MongoClient mongoClient = new MongoClient(URL,PORT);
		
        return mongoClient.getDB(DB);	
	}
}
