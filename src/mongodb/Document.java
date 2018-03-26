package mongodb;

public class Document {
	private Integer documentId;
	private String documentName;
	
	public Document(Integer documentId, String documentName){
	super();
	this.documentId = documentId;
	this.documentName = documentName;
	}
	
	public Document() {
		super();
		this.documentId = 0;
		this.documentName = null;
	}

	public Integer getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

}
