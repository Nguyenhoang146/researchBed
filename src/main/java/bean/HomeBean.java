package bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.json.simple.parser.ParseException;
import org.vgu.sqlsi.ocl.exception.OclParseException;
import org.vgu.sqlsi.ocl.exception.SetOfSetException;
import org.vgu.sqlsi.test.ocl.Runner;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name="helloWorldBean")
@SessionScoped
public class HomeBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Setter @Getter
	private String ocl = null;
	@Setter @Getter
    private String sql = null;
	
	@PostConstruct
	public void init() {
		ocl = "Enter your OCL Expression here!";
		sql = "";
	}
	
	public void map() {
	    try {
	        Runner runner = new Runner();
	        sql = runner.run(ocl);
	    } catch (SetOfSetException e) {
            sql = "Invalid Sets of sets.";
        } catch (OclParseException e) {
            sql = "Invalid OCL expression";
        } catch (NullPointerException e) {
            sql = e.getMessage();
        } catch (Exception e) {
            sql = "Invalid OCL expression";
        }
        
    }
}
