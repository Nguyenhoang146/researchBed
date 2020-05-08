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


package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Results {

//    public static ResultSet getExpectedResult(int phase, int challenge, int scenario) throws IOException {
//        final String resultSourceFile = String.format("Stage%1$sChallenge%2$s.res", phase, challenge);
//        final String scenarioFolder = String.format("scenario%1$s", scenario);
//        final List<String> expectedResultRows = Files.readAllLines(Paths.get("resources", scenarioFolder, resultSourceFile));
//        ResultSet resultSet = new ResultSet();
//        List<ResultRow> rows = new ArrayList<ResultRow>();
//        for(String expectedRow : expectedResultRows) {
//            ResultRow row = new ResultRow();
//            HashMap<String, String> cols = new HashMap<String, String>();
//            cols.put("res", expectedRow);
//            row.setCols(cols);
//            rows.add(row);
//            resultSet.setRows(rows);
//        }
//        return resultSet;
//    }
    
    public static List<String> getExpectedResult(int phase, int challenge, int scenario) throws IOException {
        final String resultSourceFile = String.format("Stage%1$sChallenge%2$s.res", phase, challenge);
        final String scenarioFolder = String.format("scenario%1$s", scenario);
        final List<String> expectedResultRows = Files.readAllLines(Paths.get("resources", scenarioFolder, resultSourceFile));
        return expectedResultRows;
    }
}
