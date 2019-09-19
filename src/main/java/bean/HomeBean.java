package bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name="helloWorldBean")
@SessionScoped
@Setter @Getter
public class HomeBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ocl;
    private String sql;
	private boolean descriptionMode;
	
	@PostConstruct
	public void init() {
		ocl = "Enter your OCL Expression here!";
		sql = "";
		descriptionMode = false;
	}
	
	public void map() {
	    try {
	        Runner runner = new Runner();
	        sql = runner.run(ocl, descriptionMode);
        } catch (NullPointerException e) {
            sql = e.getMessage();
        } catch (Exception e) {
            sql = "Invalid OCL expression";
        }
    }

    public String getResultStyle() {
        return this.descriptionMode ? "white-space: pre;  overflow: auto;" : "";
    }
}
