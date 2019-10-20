package bean;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import ssl.ExpressionParser;
import ssl.SQLVisitor;
import ssl.SSLStart;

@ManagedBean(name="ssl2plsqlBean")
@SessionScoped
public class SSL2PLSQLBean {
    static ExpressionParser parser = null;
    public void genData() {
        try {
            String language = FacesContext
                    .getCurrentInstance()
                    .getExternalContext()
                    .getRequestParameterMap().get("unique-form:hidden-result");
            String dataModel = FacesContext
                    .getCurrentInstance()
                    .getExternalContext()
                    .getRequestParameterMap().get("unique-form:data-model");
            language = language.replaceAll(" USING", "@@USING");
            language = language.replaceAll(" WITH", "@@WITH");
            InputStream is = new ByteArrayInputStream(language.getBytes());
            if(parser == null) parser = new ExpressionParser(is);
            else ExpressionParser.ReInit(is);
            SSLStart start = null;
            start = ExpressionParser.parse();
            SQLVisitor visitor = new SQLVisitor(language.split(";"));
            visitor.setJsonContext(dataModel);
            String result = visitor.visit(start, "");
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();  
            response.setHeader("Content-Disposition", "attachment;filename=file.sql");  
            response.setContentLength((int) result.length());  
            ServletOutputStream out = null;  
            try {  
                InputStream input = new ByteArrayInputStream(result.getBytes(Charset.forName("UTF-8")));
                byte[] buffer = new byte[1024];  
                out = response.getOutputStream();  
                int i = 0;  
                while ((i = input.read(buffer)) != -1) {  
                    out.write(buffer);  
                    out.flush();  
                }  
                FacesContext.getCurrentInstance().getResponseComplete();  
            } catch (IOException err) {  
                err.printStackTrace();  
            } finally {  
                try {  
                    if (out != null) {  
                        out.close();  
                    }  
                } catch (IOException err) {  
                    err.printStackTrace();  
                }  
            }  
        } catch (Exception e) {
            return;
        }
    }
}
