package mongodb;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;

public class ProjectViewBuilder {
	private static final String NAME = "Projects";
	private List<Project> projectList;
	private List<Map<String, Object>> projectRawList;

	public List<Project> getViewList() {
		return this.projectList;
	}

	public ProjectViewBuilder build(){
		return this.select().map();
	}
	
	private ProjectViewBuilder select() {
		this.projectRawList = this.mongodbPreViewBuilder.build(NAME);
		return this;
	}

	private ProjectViewBuilder map() {
		this.projectList = new ProjectViewListAdapter().map(this.projectRawList);
		return this;
	}

	private MongodbTupleViewBuilder mongodbPreViewBuilder;

	public ProjectViewBuilder(MongodbTupleViewBuilder mongodbPreViewBuilder) {
		super();
		this.mongodbPreViewBuilder = mongodbPreViewBuilder;
	}
}

class ProjectViewListAdapter {
	
	public List<Project> map(List<Map<String, Object>> sourceDataList){
		List<Project> viewList = new ArrayList<Project>();
		ProjectViewAdapter adapter = new ProjectViewAdapter();
		for(Map<String, Object> sourceData: sourceDataList){
			viewList.add(adapter.map(sourceData));
		}		
		return viewList;
	}
}
class ProjectViewAdapter {

	public Project map(Map<String, Object> rawData) {
		Integer id = ((Double) rawData.get("id")).intValue();
		String name = (String) rawData.get("name");
		Date start_date = (Date) rawData.get("start_date");
		Date end_date = (Date) rawData.get("end_date");
		Integer budget = ((Double) rawData.get("budget")).intValue();
		
		BasicDBList documents = (BasicDBList) rawData.get("documents");
		ArrayList<Document> documentsList = new DocumentAdapter().build(documents);
		
		return new Project(id, name, start_date, end_date, budget, documentsList);				
	}

	class DocumentAdapter {
		public ArrayList<Document> build(BasicDBList documents){
			ArrayList<Document> documentsList = new ArrayList<Document>();
			Integer size = documents.size();
			
			for(int i=0; i<size; i++){
				BasicDBObject documentMap = (BasicDBObject) documents.get(i);
				
				Integer documentId = ((Double) documentMap.get("documentId")).intValue();
				String documentName = (String) documentMap.get("documentName");
				
				Document document = new Document();
				document.setDocumentId(documentId);
				document.setDocumentName(documentName);
				
				documentsList.add(document);
			}
			
			return documentsList;
		}
	}
}
