/**************************************************************************
Copyright 2019 Vietnamese-German-University

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

@author: ngpbh
***************************************************************************/


package models;

import java.util.List;
import java.util.Set;

public class ResultSet {
    private List<String> headers;
    private List<ResultRow> rows;

    public List<ResultRow> getRows() {
        return rows;
    }

    public void setRows(List<ResultRow> rows) {
        this.rows = rows;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((rows == null) ? 0 : rows.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ResultSet other = (ResultSet) obj;
        if (rows == null) {
            if (other.rows != null)
                return false;
        } else if (!compareRows(other.rows))
            return false;
        return true;
    }

    private boolean compareRows(List<ResultRow> obj) {
        if(rows.size() != obj.size())
            return false;
        for(int i = 0; i < rows.size(); i++) {
            if(!rows.get(i).equals(obj.get(i)))
                return false;
        }
        return true;
    }

    public String toHTMLString() {
        String output = "";
        if(rows != null && !rows.isEmpty()) {
            Set<String> keys = rows.get(0).getCols().keySet();
            output = output.concat("<table border=\"1\">");
            output = output.concat("<tr>");
            for(String h : keys) {
                output = output.concat("<th>" + h + "</th>");
            }
            output = output.concat("</tr>");
            for (int i = 0; i < rows.size(); i++) {
                output = output.concat("<tr>");
                for(String h : keys) {
                    output = output.concat("<td>" + rows.get(i).getCols().get(h) + "</td>");
                }
                output = output.concat("</tr>");
            }
            output = output.concat("</table>");
        }
        return output;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }
}
