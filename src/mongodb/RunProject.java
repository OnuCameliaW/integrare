package mongodb;

import java.util.List;
import java.util.Map;

import com.mongodb.DB;
import com.mongodb.DBCollection;

public class RunProject {

	public static void main(String[] args) {
		MongodbDataSource mongodbDataSource = new MongodbDataSource();
		MongodbTupleViewBuilder mongodbTupleViewBuilder = new MongodbTupleViewBuilder(mongodbDataSource);
		ProjectViewBuilder pvb = new ProjectViewBuilder(mongodbTupleViewBuilder);
		List<Project> listOfProjects = pvb.build().getViewList();

		for(Project p: listOfProjects)
			System.out.println(p.getName());
		}
		

	}
