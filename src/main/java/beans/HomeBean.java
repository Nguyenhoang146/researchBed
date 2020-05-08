package beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.vgu.ttc2020.model.TTCReturnModel;

@ManagedBean(name = "homeBean")
@SessionScoped
public class HomeBean implements Serializable {
    /**
    * 
    */
    private static final long serialVersionUID = 1L;
    private String ocl;
    private String sql;
    private boolean descriptionMode;
    private long transformationTime;

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
        transformationTime = 0L;
    }

    public String map() {
        try {
            Runner runner = new Runner();
            TTCReturnModel returnModel = runner.run(ocl, descriptionMode);
            sql = returnModel.getStatement();
            transformationTime = returnModel.getOcl2sqlNanoTime();
        } catch (NullPointerException e) {
            sql = String.format("%1$s: %2$s", e.getClass().getCanonicalName(), e.getMessage());
        } catch (Exception e) {
            sql = String.format("%1$s: %2$s", e.getClass().getCanonicalName(), e.getMessage());
        }
        return null;
    }

    public long getTransformationTime() {
        return transformationTime;
    }

    public void setTransformationTime(long transformationTime) {
        this.transformationTime = transformationTime;
    }
}
