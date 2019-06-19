package bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;

import lombok.Getter;
import lombok.Setter;
import model.Paper;
import model.Researcher;
import model.Review;
import model.Write;

@ManagedBean(name="helloWorldBean")
@RequestScoped
public class HomeBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection conn = null;
	private Statement readStatement = null;
	private ResultSet resultSet = null;
	@Getter
	private List<Researcher> researchers = null;
	@Getter
	private List<Paper> papers = null;
	@Getter
	private List<Write> writes = null;
	@Getter
	private List<Review> reviews = null;
	@Setter @Getter
	private String query = null;
	@Setter @Getter
	private String queryResult = null;
	@Setter @Getter
	private String scenario = null;
	
	@PostConstruct
	public void init() {
		scenario = "1";
		initdataDev();
//		initdata();
	}
	
	public void initdataDev() {
		researchers = new ArrayList<Researcher>();
		papers = new ArrayList<Paper>();
		writes = new ArrayList<Write>();
		reviews = new ArrayList<Review>();
		researchers.add(new Researcher(1L, "ref", "name", 21L, 1L));
		papers.add(new Paper(1L, "ref", "name", 1000L, 0L));
		writes.add(new Write("author", "manuscript"));
		reviews.add(new Review("referee", "submission"));
	}
	
	public void initdata() {
		researchers = new ArrayList<Researcher>();
		papers = new ArrayList<Paper>();
		writes = new ArrayList<Write>();
		reviews = new ArrayList<Review>();
		try {
			conn = getRemoteConnection(scenario);
			readStatement = conn.createStatement();
			initResearcher();
			initPaper();
			initWrites();
			initReviews();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void initReviews() throws SQLException {
		resultSet = readStatement.executeQuery("SELECT * FROM Reviews;");
		while (resultSet.next()) {
		    reviews.add(new Review(
		    		resultSet.getString("referee"), 
		    		resultSet.getString("submission")));
		}
	}

	private void initWrites() throws SQLException {
		resultSet = readStatement.executeQuery("SELECT * FROM Writes;");
		while (resultSet.next()) {
		    writes.add(new Write(
		    		resultSet.getString("author"), 
		    		resultSet.getString("manuscript")));
		}
	}

	private void initPaper() throws SQLException {
		resultSet = readStatement.executeQuery("SELECT * FROM Paper;");
		while (resultSet.next()) {
		    papers.add(new Paper(
		    		resultSet.getLong("Paper_id"), 
		    		resultSet.getString("Paper_ref"), 
		    		resultSet.getString("title"), 
		    		resultSet.getLong("wordCount"),
		    		resultSet.getLong("studentPaper")));
		}
	}

	private void initResearcher() throws SQLException {
		resultSet = readStatement.executeQuery("SELECT * FROM Researcher;");
		while (resultSet.next()) {
		    researchers.add(new Researcher(
		    		resultSet.getLong("Researcher_id"), 
		    		resultSet.getString("Researcher_ref"), 
		    		resultSet.getString("name"), 
		    		resultSet.getLong("age"),
		    		resultSet.getLong("isStudent")));
		}
	}
	
	public void buttonAction() {
		try {
			conn = getRemoteConnection(scenario);
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
			        queryResult = queryResult.concat("<td><center>").concat(resultSet.getString(i)).concat("</center></td>");
			        if(i == columnsNumber) queryResult = queryResult.concat("</tr>");
			    }
			}
			queryResult = queryResult.concat("</table>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
    
    public void onResearcherCellEdit(CellEditEvent event) {
    	try {
    		String researchId = String.valueOf(researchers.get(event.getRowIndex()).getId());
    		String columnName = event.getColumn().getHeaderText();
    		String newValue = "" + event.getNewValue();
    		if(columnName.equals("name") && !newValue.equals("NULL")) {
    			newValue = "\"" + newValue + "\"";
    		}
			readStatement = conn.createStatement();
			String updateQuery = "UPDATE Researcher SET " 
			+ columnName 
			+ " = "
			+ newValue
			+ " WHERE Researcher_id = "
			+ researchId
			+ ";";
			readStatement.executeUpdate(updateQuery);
			initResearcher();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void changeScene() {
		initdataDev();
//		initdata();
    }
}
