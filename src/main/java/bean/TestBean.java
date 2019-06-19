package bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import lombok.Getter;
import lombok.Setter;
import model.QueryResult;

@ManagedBean(name="testBean")
@SessionScoped
public class TestBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection conn = null;
	private Statement readStatement = null;
	private ResultSet resultSet = null;
	private List<List<Integer>> validateMatrix;
	private List<String> oclExpressions;
	@Setter @Getter
	private String query;
	@Setter @Getter
	private String queryResult;
	@Setter @Getter
	private String scenario;
	@Setter @Getter
	private String queryNumber;
	@Setter @Getter
	private List<QueryResult> results;
	
	@PostConstruct
	public void init() {
		scenario = "1";
		queryNumber = "1";
		injectMatrix();
		changeScene();
	}
	
	private void injectMatrix() {
		results = new ArrayList<QueryResult>();
//		List<Integer> query1 = Arrays.asList(0, 1, 1, 1, 0, 1, 1, 0);
//		List<Integer> query2 = Arrays.asList(0, 1, 0, 1, 0, 0, 0, 0);
//		List<Integer> query3 = Arrays.asList(1, 0, 1, 0, 1, 1, 1, 0);
//		List<Integer> query4 = Arrays.asList(0, 1, 0, 1, 0, 1, 1, 1);
//		List<Integer> query5 = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1);
//		List<Integer> query6 = Arrays.asList(0, 0, 1, 0, 0, 1, 1, 0);
		List<Integer> query1 = Arrays.asList(0, 0, 1, 1, 1, 0);
		List<Integer> query2 = Arrays.asList(1, 1, 0, 1, 1, 0);
		List<Integer> query3 = Arrays.asList(1, 0, 1, 0, 1, 1);
		List<Integer> query4 = Arrays.asList(1, 1, 0, 1, 1, 0);
		List<Integer> query5 = Arrays.asList(0, 0, 1, 0, 1, 0);
		List<Integer> query6 = Arrays.asList(1, 0, 1, 1, 1, 1);
		List<Integer> query7 = Arrays.asList(1, 0, 1, 1, 1, 1);
		List<Integer> query8 = Arrays.asList(0, 0, 0, 1, 1, 0);
		validateMatrix = Arrays.asList(query1, query2, query3, query4, query5, query6, query7, query8);
		oclExpressions = Arrays.asList(
				"Researcher.allInstances()->exists(r|r.isStudent) and Researcher.allInstances()->select(r|r.isStudent)->size() <= 5",
				"Paper.allInstances()->forAll(p|p.wordCount <= 10000)",
				"Paper.allInstances()->forAll(p|p.referee->size() > 0)",
				"Paper.allInstances()->forAll(p|p.author->forAll(r|not r.isStudent))",
				"Paper.allInstances()->select(p|p.isStudentPaper)->forAll(s|s.author->exists(r|r.isStudent))",
				"Researcher.allInstances()->exists(r|r.submission->forAll(p|p.isStudentPaper))",
				"Paper.allInstances()->exists(p|p.author->exists(r|r.age = 18))",
				"Paper.allInstances()->forAll(p1|p1.author->forAll(r1|r1.submission->forAll(p2|p2 <> p1)))"
				);
	}

	public void initdata() {
		try {
			conn = getRemoteConnection(scenario);
			readStatement = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void execute() {
			conn = getRemoteConnection(scenario);
			try {
				executeQuery(query);
				results.add(0, new QueryResult(query, queryResult, "<hr/>"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }

	private void executeQuery(String query) throws SQLException {
		readStatement = conn.createStatement();
		resultSet = readStatement.executeQuery(query);
		ResultSetMetaData rsmd = resultSet.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		queryResult = "<table BORDER=1 CELLPADDING=1 CELLSPACING=1 WIDTH=100%>";
		for (int i = 1; i <= columnsNumber; i++) {
		    if (i == 1) queryResult = queryResult.concat("<tr>");
		    queryResult = queryResult.concat("<th>").concat(rsmd.getColumnName(i)).concat("</th>");
		    if(i == columnsNumber) queryResult = queryResult.concat("</tr>");
		}
		while (resultSet.next()) {
		    for (int i = 1; i <= columnsNumber; i++) {
		    	if (i == 1) queryResult = queryResult.concat("<tr>");
		    	String resultCell = resultSet.getString(i);
		        queryResult = queryResult.concat("<td><center>").concat(Objects.isNull(resultCell) ? "NULL" : resultCell).concat("</center></td>");
		        if(i == columnsNumber) queryResult = queryResult.concat("</tr>");
		    }
		}
		queryResult = queryResult.concat("</table>");
	}
	
	public void validate() {
		List<Integer> targetQueryResult = validateMatrix.get(Integer.valueOf(queryNumber) - 1);
		List<String> actualQueryResult = executeConstraintQuery(query);
		String firstRow = "";
		String secondRow = "";
		String thirdRow = "";
		queryResult = "<table BORDER=1 CELLPADDING=1 CELLSPACING=1 WIDTH=100%>";
		for (int i = 0; i < 6; i++) {
	        if (i == 0) {
	        	firstRow = firstRow.concat("<tr><td><b>Scenario</b></td>");
	        	thirdRow = thirdRow.concat("<tr><td><b>Expected Result</b></td>");
	        	secondRow = secondRow.concat("<tr><td><b>Actual Result</b></td>");
	        }
	        if(actualQueryResult.get(i).matches("[0-1]")) {
	        	if(targetQueryResult.get(i) == Integer.valueOf(actualQueryResult.get(i))) {
	        		firstRow = firstRow.concat("<th bgcolor=\"#00FF00\">").concat(String.valueOf(i)).concat("</th>");
	        		thirdRow = thirdRow.concat("<td bgcolor=\"#00FF00\"><center>")
		        			.concat(targetQueryResult.get(i)==1 ? "true" : "false")
		        			.concat("<center></td>");
		        	secondRow = secondRow.concat("<td bgcolor=\"#00FF00\"><center>")
		        			.concat(targetQueryResult.get(i)==1 ? "true" : "false")
		        			.concat("<center></td>");
	        	} else {
	        		firstRow = firstRow.concat("<th bgcolor=\"#FF0000\">").concat(String.valueOf(i)).concat("</th>");
	        		thirdRow = thirdRow.concat("<td bgcolor=\"#FF0000\"><center>")
		        			.concat(targetQueryResult.get(i)==1 ? "true" : "false")
		        			.concat("<center></td>");
		        	secondRow = secondRow.concat("<td bgcolor=\"#FF0000\"><center>")
		        			.concat(targetQueryResult.get(i)==1 ? "false" : "true")
		        			.concat("<center></td>");
	        	}
	        } else {
	        	firstRow = firstRow.concat("<th>").concat(String.valueOf(i)).concat("</th>");
	        	thirdRow = thirdRow.concat("<td><center>")
	        			.concat(targetQueryResult.get(i)==1 ? "true" : "false")
	        			.concat("<center></td>");
	        	secondRow = secondRow.concat("<td><center>Invalid<center></td>");
	        }
	        if(i == 5) {
	        	firstRow = firstRow.concat("</tr>");
	        	thirdRow = thirdRow.concat("</tr>");
	        	secondRow = secondRow.concat("</tr>");
	        }
	    }
		queryResult = queryResult.concat(firstRow).concat(thirdRow).concat(secondRow).concat("</table>");
		String content = "Validating scenarios on query ".concat(queryNumber);
		results.add(0, new QueryResult(content, queryResult, "<hr/>"));
	}

	private List<String> executeConstraintQuery(String query) {
		List<String> actualQueryResult = new ArrayList<String>();
		for(int i = 1; i <= 6; i++) {
			conn = getRemoteConnection(String.valueOf(i));
			try {
				readStatement = conn.createStatement();
				resultSet = readStatement.executeQuery(query);
				ResultSetMetaData rsmd = resultSet.getMetaData();
				int columnsNumber = rsmd.getColumnCount();
				resultSet.next();
				String res = resultSet.getString(1);
				if(columnsNumber == 1 && ("1".equals(res) || "0".equals(res)) && !resultSet.next()) {
					actualQueryResult.add(res);
				}
				else {
					actualQueryResult.add("invalid");
				}
			} catch (SQLException e) {
				actualQueryResult.add("invalid");
			}
		}
		return actualQueryResult;
	}

	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    private static Connection getRemoteConnection(String scenario) {
        if (System.getProperty("RDS_HOSTNAME") != null) {
          try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          String dbName = "researchDB" + scenario;
          String userName = System.getProperty("RDS_USERNAME");
          String password = System.getProperty("RDS_PASSWORD");
          String hostname = System.getProperty("RDS_HOSTNAME");
          String port = System.getProperty("RDS_PORT");
          String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
          Connection con = DriverManager.getConnection(jdbcUrl);
          return con;
        }
        catch (ClassNotFoundException e) { }
        catch (SQLException e) { }
        }
        return null;
      }
    
    public void changeScene() {
    	initdata();
    	try {
    		String reviews = "Select * from Reviews";
			executeQuery(reviews);
			results.add(0, new QueryResult(reviews, queryResult, "<hr/>"));
    		String writes = "Select * from Writes";
			executeQuery(writes);
			results.add(0, new QueryResult(writes, queryResult, null));
    		String papers = "Select * from Paper";
			executeQuery(papers);
			results.add(0, new QueryResult(papers, queryResult, null));
    		String researchers = "Select * from Researcher";
			executeQuery(researchers);
			results.add(0, new QueryResult(researchers, queryResult, null));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String content = "Selecting scenario ".concat(scenario).concat("...");
    	results.add(0, new QueryResult(content, null, null));
    }
    
    public void changeQueryNumber() {
    	String content = "Selecting query ".concat(queryNumber).concat("...");
    	results.add(0, new QueryResult(content, null, "<hr/>"));
    }
    
    public void sampleOCL() {
    	String content = oclExpressions.get(Integer.valueOf(queryNumber) - 1);
    	results.add(0, new QueryResult(content, null, "<hr/>"));
    }
    
    public void clear() {
    	results.clear();
    }
    
    public boolean isClearBtnDisabled() {
    	return results.isEmpty();
    }
}
