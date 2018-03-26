package mongodb;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class MongodbTupleViewBuilder {

	private MongodbDataSource mongoConnector;
	public MongodbTupleViewBuilder( MongodbDataSource mongoConnector) {
		this.mongoConnector = mongoConnector;
	}

	public List<Map<String, Object>> build(String collectionName) {
		try {
			DB connecton = mongoConnector.getConnection();
			DBCollection coll = connecton.getCollection(collectionName);
	
			return new CollectionListMapAdapter().map(coll);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}	
	}
	
}

class CollectionListMapAdapter{
	public List<Map<String, Object>> map(DBCollection col) throws Exception{
		List<Map<String, Object>> viewRows = new ArrayList<Map<String, Object>>();
			
        DBCursor cursor = col.find();
        
        while (cursor.hasNext()) { 
           DBObject values = cursor.next();
           Map<String, Object> mp = values.toMap();
           viewRows.add(mp);
          //System.out.println("din map " + mp.toString());
	}
        
        return viewRows;
	}
}
