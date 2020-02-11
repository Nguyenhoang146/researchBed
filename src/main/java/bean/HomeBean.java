package bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="homeBean")
@SessionScoped
public class HomeBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ocl;
    private String sql;
	private boolean descriptionMode;
	
	public String getOcl() {
        return ocl;
    }

    public void setOcl(String ocl) {
        this.ocl = ocl;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public boolean isDescriptionMode() {
        return descriptionMode;
    }

    public void setDescriptionMode(boolean descriptionMode) {
        this.descriptionMode = descriptionMode;
    }

    @PostConstruct
	public void init() {
		ocl = "Enter your OCL Expression here!";
		sql = "";
		descriptionMode = false;
	}
	
	public String map() {
	    try {
	        Runner runner = new Runner();
	        sql = runner.run(ocl, descriptionMode);
        } catch (NullPointerException e) {
            sql = e.getMessage();
        } catch (Exception e) {
            sql = "Invalid OCL expression";
        }
	    return null;
    }

    public String getResultStyle() {
        return this.descriptionMode ? "white-space: pre;  overflow: auto;" : "";
    }
}
