package mongodb;

import java.util.Date;
import java.util.ArrayList;

public class Project {
	private Integer id;
	private String name;
	private Date start_date;
	private Date end_date;
	private Integer budget;
	private ArrayList<Document> documents = new ArrayList<Document>();

	public Project(Integer id, String name,
					Date start_date, Date end_date,
					Integer budget, ArrayList<Document> documents){

	super();
	this.id = id;
	this.name = name;
	this.start_date = start_date;
	this.end_date = end_date;
	this.budget = budget;
	this.documents = documents;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Integer getBudget() {
		return budget;
	}

	public void setBudget(Integer budget) {
		this.budget = budget;
	}

	public ArrayList<Document> getDocuments() {
	return documents;}

	public void setDocuments(ArrayList<Document> documents) {
	this.documents = documents;}
	
}
