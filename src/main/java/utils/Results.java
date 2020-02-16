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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import models.ResultRow;
import models.ResultSet;

public class Results {

    public static ResultSet getExpectedResult(int phase, int challenge, int scenario) {
        switch (phase) {
        case 0:
            return getResultPhase0(challenge, scenario);
        case 1:
            return getResultPhase1(challenge, scenario);
        case 2:
            return getResultPhase2(challenge, scenario);
        case 3:
            return getResultPhase3(challenge, scenario);
        case 4:
            return getResultPhase4(challenge, scenario);
        case 5:
            return getResultPhase5(challenge, scenario);
        case 6:
            return getResultPhase6(challenge, scenario);
        case 7:
            return getResultPhase7(challenge, scenario);
        case 8:
            return getResultPhase8(challenge, scenario);
        default:
            return getResultPhase9(challenge, scenario);
        }
    }

    private static ResultSet getResultPhase0(int challenge, int scenario) {
        switch (challenge) {
        case 0:
            return getResultPhase0Challenge0(scenario);
        case 1:
            return getResultPhase0Challenge1(scenario);
        default:
            return getResultPhase0Challenge2(scenario);
        }
    }
    
    private static ResultSet getResultPhase0Challenge2(int scenario) {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        cols.put("val", "1");
        cols.put("res", "1");
        row1.setCols(cols);
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase0Challenge1(int scenario) {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        cols.put("val", "1");
        cols.put("res", "Peter");
        row1.setCols(cols);
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase0Challenge0(int scenario) {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        cols.put("val", "1");
        cols.put("res", "2");
        row1.setCols(cols);
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase1(int challenge, int scenario) {
        switch (challenge) {
        case 0:
            return getResultPhase1Challenge0(scenario);
        case 1:
            return getResultPhase1Challenge1(scenario);
        default:
            return getResultPhase1Challenge2(scenario);
        }
    }
    
    private static ResultSet getResultPhase1Challenge2(int scenario) {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        cols.put("val", "1");
        cols.put("res", "1");
        row1.setCols(cols);
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase1Challenge1(int scenario) {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        cols.put("val", "1");
        cols.put("res", "1");
        row1.setCols(cols);
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase1Challenge0(int scenario) {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        cols.put("val", "1");
        cols.put("res", "0");
        row1.setCols(cols);
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase2(int challenge, int scenario) {
        switch (challenge) {
        default:
            return getResultPhase2Challenge0(scenario);
        }
    }
    
    private static ResultSet getResultPhase2Challenge0(int scenario) {
        switch (scenario) {
        case 1:
            return getResultPhase2Challenge0Scenario1();
        case 2:
            return getResultPhase2Challenge0Scenario2();
        case 3:
            return getResultPhase2Challenge0Scenario3();
        case 4:
            return getResultPhase2Challenge0Scenario4();
        case 5:
            return getResultPhase2Challenge0Scenario5();
        case 6:
            return getResultPhase2Challenge0Scenario6();
        default:
            return getResultPhase2Challenge0Scenario7();
        }
    }

    private static ResultSet getResultPhase2Challenge0Scenario7() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "2");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase2Challenge0Scenario6() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "2");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase2Challenge0Scenario5() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "2");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase2Challenge0Scenario4() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "2");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase2Challenge0Scenario3() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "2");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase2Challenge0Scenario2() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        cols.put("val", "1");
        cols.put("res", "1");
        row1.setCols(cols);
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase2Challenge0Scenario1() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase3(int challenge, int scenario) {
        switch (challenge) {
        case 0:
            return getResultPhase3Challenge0(scenario);
        default:
            return getResultPhase3Challenge1(scenario);
        }
    }
    
    private static ResultSet getResultPhase3Challenge1(int scenario) {
        switch (scenario) {
        case 1:
            return getResultPhase3Challenge1Scenario1();
        case 2:
            return getResultPhase3Challenge1Scenario2();
        case 3:
            return getResultPhase3Challenge1Scenario3();
        case 4:
            return getResultPhase3Challenge1Scenario4();
        case 5:
            return getResultPhase3Challenge1Scenario5();
        case 6:
            return getResultPhase3Challenge1Scenario6();
        default:
            return getResultPhase3Challenge1Scenario7();
        }
    }
    
    private static ResultSet getResultPhase3Challenge1Scenario7() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase3Challenge1Scenario6() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase3Challenge1Scenario5() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase3Challenge1Scenario4() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase3Challenge1Scenario3() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase3Challenge1Scenario2() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        cols.put("val", "1");
        cols.put("res", "1");
        row1.setCols(cols);
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase3Challenge1Scenario1() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        cols.put("val", "1");
        cols.put("res", "0");
        row1.setCols(cols);
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase3Challenge0(int scenario) {
        switch (scenario) {
        case 1:
            return getResultPhase3Challenge0Scenario1();
        case 2:
            return getResultPhase3Challenge0Scenario2();
        case 3:
            return getResultPhase3Challenge0Scenario3();
        case 4:
            return getResultPhase3Challenge0Scenario4();
        case 5:
            return getResultPhase3Challenge0Scenario5();
        case 6:
            return getResultPhase3Challenge0Scenario6();
        default:
            return getResultPhase3Challenge0Scenario7();
        }
    }
    
    private static ResultSet getResultPhase3Challenge0Scenario7() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "2");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase3Challenge0Scenario6() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "2");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase3Challenge0Scenario5() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "2");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase3Challenge0Scenario4() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "2");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase3Challenge0Scenario3() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "2");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase3Challenge0Scenario2() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        cols.put("val", "1");
        cols.put("res", "1");
        row1.setCols(cols);
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase3Challenge0Scenario1() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        cols.put("val", "1");
        cols.put("res", "0");
        row1.setCols(cols);
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase4(int challenge, int scenario) {
        switch (challenge) {
        case 0:
            return getResultPhase4Challenge0(scenario);
        case 1:
            return getResultPhase4Challenge1(scenario);
        default:
            return getResultPhase4Challenge2(scenario);
        }
    }
    
    private static ResultSet getResultPhase4Challenge2(int scenario) {
        switch (scenario) {
        case 1:
            return getResultPhase4Challenge2Scenario1();
        case 2:
            return getResultPhase4Challenge2Scenario2();
        case 3:
            return getResultPhase4Challenge2Scenario3();
        case 4:
            return getResultPhase4Challenge2Scenario4();
        case 5:
            return getResultPhase4Challenge2Scenario5();
        case 6:
            return getResultPhase4Challenge2Scenario6();
        default:
            return getResultPhase4Challenge2Scenario7();
        }
    }
    
    private static ResultSet getResultPhase4Challenge2Scenario7() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "0");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase4Challenge2Scenario6() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "0");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase4Challenge2Scenario5() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "0");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase4Challenge2Scenario4() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "0");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase4Challenge2Scenario3() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "0");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase4Challenge2Scenario2() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        cols.put("val", "1");
        cols.put("res", "0");
        row1.setCols(cols);
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase4Challenge2Scenario1() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase4Challenge1(int scenario) {
        switch (scenario) {
        case 1:
            return getResultPhase4Challenge1Scenario1();
        case 2:
            return getResultPhase4Challenge1Scenario2();
        case 3:
            return getResultPhase4Challenge1Scenario3();
        case 4:
            return getResultPhase4Challenge1Scenario4();
        case 5:
            return getResultPhase4Challenge1Scenario5();
        case 6:
            return getResultPhase4Challenge1Scenario6();
        default:
            return getResultPhase4Challenge1Scenario7();
        }
    }
    
    private static ResultSet getResultPhase4Challenge1Scenario7() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "2");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase4Challenge1Scenario6() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "2");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase4Challenge1Scenario5() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "2");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase4Challenge1Scenario4() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "2");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase4Challenge1Scenario3() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "2");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase4Challenge1Scenario2() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        cols.put("val", "1");
        cols.put("res", "1");
        row1.setCols(cols);
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase4Challenge1Scenario1() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase4Challenge0(int scenario) {
        switch (scenario) {
        case 1:
            return getResultPhase4Challenge0Scenario1();
        case 2:
            return getResultPhase4Challenge0Scenario2();
        case 3:
            return getResultPhase4Challenge0Scenario3();
        case 4:
            return getResultPhase4Challenge0Scenario4();
        case 5:
            return getResultPhase4Challenge0Scenario5();
        case 6:
            return getResultPhase4Challenge0Scenario6();
        default:
            return getResultPhase4Challenge0Scenario7();
        }
    }
    
    private static ResultSet getResultPhase4Challenge0Scenario7() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "5");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "5");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase4Challenge0Scenario6() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "5");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "5");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase4Challenge0Scenario5() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "5");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "5");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase4Challenge0Scenario4() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "5");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "5");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase4Challenge0Scenario3() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "5");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "5");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase4Challenge0Scenario2() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        cols.put("val", "1");
        cols.put("res", "5");
        row1.setCols(cols);
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase4Challenge0Scenario1() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase5(int challenge, int scenario) {
        switch (challenge) {
        case 0:
            return getResultPhase5Challenge0(scenario);
        default:
            return getResultPhase5Challenge1(scenario);
        }
    }
    
    private static ResultSet getResultPhase5Challenge1(int scenario) {
        switch (scenario) {
        case 1:
            return getResultPhase5Challenge1Scenario1();
        case 2:
            return getResultPhase5Challenge1Scenario2();
        case 3:
            return getResultPhase5Challenge1Scenario3();
        case 4:
            return getResultPhase5Challenge1Scenario4();
        case 5:
            return getResultPhase5Challenge1Scenario5();
        case 6:
            return getResultPhase5Challenge1Scenario6();
        default:
            return getResultPhase5Challenge1Scenario7();
        }
    }
    
    private static ResultSet getResultPhase5Challenge1Scenario7() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "0");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase5Challenge1Scenario6() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "0");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase5Challenge1Scenario5() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "0");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase5Challenge1Scenario4() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "0");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase5Challenge1Scenario3() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "0");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase5Challenge1Scenario2() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        cols.put("val", "1");
        cols.put("res", "1");
        row1.setCols(cols);
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase5Challenge1Scenario1() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase5Challenge0(int scenario) {
        switch (scenario) {
        case 1:
            return getResultPhase5Challenge0Scenario1();
        case 2:
            return getResultPhase5Challenge0Scenario2();
        case 3:
            return getResultPhase5Challenge0Scenario3();
        case 4:
            return getResultPhase5Challenge0Scenario4();
        case 5:
            return getResultPhase5Challenge0Scenario5();
        case 6:
            return getResultPhase5Challenge0Scenario6();
        default:
            return getResultPhase5Challenge0Scenario7();
        }
    }
    
    private static ResultSet getResultPhase5Challenge0Scenario7() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "black");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "red");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase5Challenge0Scenario6() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "black");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "red");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase5Challenge0Scenario5() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "black");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "red");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase5Challenge0Scenario4() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "black");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "red");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase5Challenge0Scenario3() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "black");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "red");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase5Challenge0Scenario2() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        cols.put("val", "1");
        cols.put("res", "black");
        row1.setCols(cols);
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase5Challenge0Scenario1() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase6(int challenge, int scenario) {
        switch (challenge) {
        case 0:
            return getResultPhase6Challenge0(scenario);
        default:
            return getResultPhase6Challenge1(scenario);
        }
    }
    
    private static ResultSet getResultPhase6Challenge1(int scenario) {
        switch (scenario) {
        case 1:
            return getResultPhase6Challenge1Scenario1();
        case 2:
            return getResultPhase6Challenge1Scenario2();
        case 3:
            return getResultPhase6Challenge1Scenario3();
        case 4:
            return getResultPhase6Challenge1Scenario4();
        case 5:
            return getResultPhase6Challenge1Scenario5();
        case 6:
            return getResultPhase6Challenge1Scenario6();
        default:
            return getResultPhase6Challenge1Scenario7();
        }
    }
    
    private static ResultSet getResultPhase6Challenge1Scenario7() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "0");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase6Challenge1Scenario6() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "1");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase6Challenge1Scenario5() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "1");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase6Challenge1Scenario4() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "1");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase6Challenge1Scenario3() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "1");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase6Challenge1Scenario2() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        cols.put("val", "1");
        cols.put("res", "1");
        row1.setCols(cols);
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase6Challenge1Scenario1() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase6Challenge0(int scenario) {
        switch (scenario) {
        case 1:
            return getResultPhase6Challenge0Scenario1();
        case 2:
            return getResultPhase6Challenge0Scenario2();
        case 3:
            return getResultPhase6Challenge0Scenario3();
        case 4:
            return getResultPhase6Challenge0Scenario4();
        case 5:
            return getResultPhase6Challenge0Scenario5();
        case 6:
            return getResultPhase6Challenge0Scenario6();
        default:
            return getResultPhase6Challenge0Scenario7();
        }
    }
    
    private static ResultSet getResultPhase6Challenge0Scenario7() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "2");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "1");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase6Challenge0Scenario6() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "2");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "0");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase6Challenge0Scenario5() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "0");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase6Challenge0Scenario4() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "0");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase6Challenge0Scenario3() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        ResultRow row2 = new ResultRow();
        HashMap<String, String> cols2 = new HashMap<String, String>();
        row2.setCols(cols2);
        cols2.put("val", "1");
        cols2.put("res", "0");
        rows.addAll(Arrays.asList(row1, row2));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase6Challenge0Scenario2() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        cols.put("val", "1");
        cols.put("res", "0");
        row1.setCols(cols);
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase6Challenge0Scenario1() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase7(int challenge, int scenario) {
        switch (challenge) {
        case 0:
            return getResultPhase7Challenge0(scenario);
        case 1:
            return getResultPhase7Challenge1(scenario);
        case 2:
            return getResultPhase7Challenge2(scenario);
        default:
            return getResultPhase7Challenge3(scenario);
        }
    }
    
    private static ResultSet getResultPhase7Challenge3(int scenario) {
        switch (scenario) {
        case 1:
            return getResultPhase7Challenge3Scenario1();
        case 2:
            return getResultPhase7Challenge3Scenario2();
        case 3:
            return getResultPhase7Challenge3Scenario3();
        case 4:
            return getResultPhase7Challenge3Scenario4();
        case 5:
            return getResultPhase7Challenge3Scenario5();
        case 6:
            return getResultPhase7Challenge3Scenario6();
        default:
            return getResultPhase7Challenge3Scenario7();
        }
    }
    
    private static ResultSet getResultPhase7Challenge3Scenario7() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase7Challenge3Scenario6() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase7Challenge3Scenario5() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase7Challenge3Scenario4() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase7Challenge3Scenario3() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase7Challenge3Scenario2() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        cols.put("val", "1");
        cols.put("res", "0");
        row1.setCols(cols);
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase7Challenge3Scenario1() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        row1.setCols(cols);
        cols.put("val", "1");
        cols.put("res", "0");
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase7Challenge2(int scenario) {
        switch (scenario) {
        case 1:
            return getResultPhase7Challenge2Scenario1();
        case 2:
            return getResultPhase7Challenge2Scenario2();
        case 3:
            return getResultPhase7Challenge2Scenario3();
        case 4:
            return getResultPhase7Challenge2Scenario4();
        case 5:
            return getResultPhase7Challenge2Scenario5();
        case 6:
            return getResultPhase7Challenge2Scenario6();
        default:
            return getResultPhase7Challenge2Scenario7();
        }
    }
    
    private static ResultSet getResultPhase7Challenge2Scenario7() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase7Challenge2Scenario6() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase7Challenge2Scenario5() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase7Challenge2Scenario4() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase7Challenge2Scenario3() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase7Challenge2Scenario2() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        cols.put("val", "1");
        cols.put("res", "1");
        row1.setCols(cols);
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase7Challenge2Scenario1() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        row1.setCols(cols);
        cols.put("val", "1");
        cols.put("res", "0");
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase7Challenge1(int scenario) {
        switch (scenario) {
        case 1:
            return getResultPhase7Challenge1Scenario1();
        case 2:
            return getResultPhase7Challenge1Scenario2();
        case 3:
            return getResultPhase7Challenge1Scenario3();
        case 4:
            return getResultPhase7Challenge1Scenario4();
        case 5:
            return getResultPhase7Challenge1Scenario5();
        case 6:
            return getResultPhase7Challenge1Scenario6();
        default:
            return getResultPhase7Challenge1Scenario7();
        }
    }
    
    private static ResultSet getResultPhase7Challenge1Scenario7() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase7Challenge1Scenario6() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase7Challenge1Scenario5() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase7Challenge1Scenario4() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase7Challenge1Scenario3() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase7Challenge1Scenario2() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        cols.put("val", "1");
        cols.put("res", "0");
        row1.setCols(cols);
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase7Challenge1Scenario1() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        row1.setCols(cols);
        cols.put("val", "1");
        cols.put("res", "0");
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase7Challenge0(int scenario) {
        switch (scenario) {
        case 1:
            return getResultPhase7Challenge0Scenario1();
        case 2:
            return getResultPhase7Challenge0Scenario2();
        case 3:
            return getResultPhase7Challenge0Scenario3();
        case 4:
            return getResultPhase7Challenge0Scenario4();
        case 5:
            return getResultPhase7Challenge0Scenario5();
        case 6:
            return getResultPhase7Challenge0Scenario6();
        default:
            return getResultPhase7Challenge0Scenario7();
        }
    }
    
    private static ResultSet getResultPhase7Challenge0Scenario7() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase7Challenge0Scenario6() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase7Challenge0Scenario5() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase7Challenge0Scenario4() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase7Challenge0Scenario3() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase7Challenge0Scenario2() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        cols.put("val", "1");
        cols.put("res", "1");
        row1.setCols(cols);
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase7Challenge0Scenario1() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        row1.setCols(cols);
        cols.put("val", "1");
        cols.put("res", "0");
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase8(int challenge, int scenario) {
        switch (challenge) {
        case 0:
            return getResultPhase8Challenge0(scenario);
        case 1:
            return getResultPhase8Challenge1(scenario);
        case 2:
            return getResultPhase8Challenge2(scenario);
        default:
            return getResultPhase8Challenge3(scenario);
        }
    }
    
    private static ResultSet getResultPhase8Challenge3(int scenario) {
        switch (scenario) {
        case 1:
            return getResultPhase8Challenge3Scenario1();
        case 2:
            return getResultPhase8Challenge3Scenario2();
        case 3:
            return getResultPhase8Challenge3Scenario3();
        case 4:
            return getResultPhase8Challenge3Scenario4();
        case 5:
            return getResultPhase8Challenge3Scenario5();
        case 6:
            return getResultPhase8Challenge3Scenario6();
        default:
            return getResultPhase8Challenge3Scenario7();
        }
    }
    
    private static ResultSet getResultPhase8Challenge3Scenario7() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase8Challenge3Scenario6() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase8Challenge3Scenario5() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase8Challenge3Scenario4() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase8Challenge3Scenario3() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase8Challenge3Scenario2() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        cols.put("val", "1");
        cols.put("res", "0");
        row1.setCols(cols);
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase8Challenge3Scenario1() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        row1.setCols(cols);
        cols.put("val", "1");
        cols.put("res", "1");
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase8Challenge2(int scenario) {
        switch (scenario) {
        case 1:
            return getResultPhase8Challenge2Scenario1();
        case 2:
            return getResultPhase8Challenge2Scenario2();
        case 3:
            return getResultPhase8Challenge2Scenario3();
        case 4:
            return getResultPhase8Challenge2Scenario4();
        case 5:
            return getResultPhase8Challenge2Scenario5();
        case 6:
            return getResultPhase8Challenge2Scenario6();
        default:
            return getResultPhase8Challenge2Scenario7();
        }
    }
    
    private static ResultSet getResultPhase8Challenge2Scenario7() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase8Challenge2Scenario6() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase8Challenge2Scenario5() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase8Challenge2Scenario4() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase8Challenge2Scenario3() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase8Challenge2Scenario2() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        cols.put("val", "1");
        cols.put("res", "1");
        row1.setCols(cols);
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase8Challenge2Scenario1() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        row1.setCols(cols);
        cols.put("val", "1");
        cols.put("res", "1");
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase8Challenge1(int scenario) {
        switch (scenario) {
        case 1:
            return getResultPhase8Challenge1Scenario1();
        case 2:
            return getResultPhase8Challenge1Scenario2();
        case 3:
            return getResultPhase8Challenge1Scenario3();
        case 4:
            return getResultPhase8Challenge1Scenario4();
        case 5:
            return getResultPhase8Challenge1Scenario5();
        case 6:
            return getResultPhase8Challenge1Scenario6();
        default:
            return getResultPhase8Challenge1Scenario7();
        }
    }
    
    private static ResultSet getResultPhase8Challenge1Scenario7() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase8Challenge1Scenario6() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase8Challenge1Scenario5() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase8Challenge1Scenario4() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase8Challenge1Scenario3() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase8Challenge1Scenario2() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        cols.put("val", "1");
        cols.put("res", "1");
        row1.setCols(cols);
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase8Challenge1Scenario1() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        row1.setCols(cols);
        cols.put("val", "1");
        cols.put("res", "1");
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase8Challenge0(int scenario) {
        switch (scenario) {
        case 1:
            return getResultPhase8Challenge0Scenario1();
        case 2:
            return getResultPhase8Challenge0Scenario2();
        case 3:
            return getResultPhase8Challenge0Scenario3();
        case 4:
            return getResultPhase8Challenge0Scenario4();
        case 5:
            return getResultPhase8Challenge0Scenario5();
        case 6:
            return getResultPhase8Challenge0Scenario6();
        default:
            return getResultPhase8Challenge0Scenario7();
        }
    }
    
    private static ResultSet getResultPhase8Challenge0Scenario7() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase8Challenge0Scenario6() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase8Challenge0Scenario5() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase8Challenge0Scenario4() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase8Challenge0Scenario3() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase8Challenge0Scenario2() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        cols.put("val", "1");
        cols.put("res", "0");
        row1.setCols(cols);
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase8Challenge0Scenario1() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        row1.setCols(cols);
        cols.put("val", "1");
        cols.put("res", "1");
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase9(int challenge, int scenario) {
        switch (challenge) {
        case 0:
            return getResultPhase9Challenge0(scenario);
        case 1:
            return getResultPhase9Challenge1(scenario);
        case 2:
            return getResultPhase9Challenge2(scenario);
        default:
            return getResultPhase9Challenge3(scenario);
        }
    }

    private static ResultSet getResultPhase9Challenge3(int scenario) {
        switch (scenario) {
        case 1:
            return getResultPhase9Challenge3Scenario1();
        case 2:
            return getResultPhase9Challenge3Scenario2();
        case 3:
            return getResultPhase9Challenge3Scenario3();
        case 4:
            return getResultPhase9Challenge3Scenario4();
        case 5:
            return getResultPhase9Challenge3Scenario5();
        case 6:
            return getResultPhase9Challenge3Scenario6();
        default:
            return getResultPhase9Challenge3Scenario7();
        }
    }
    
    private static ResultSet getResultPhase9Challenge3Scenario7() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase9Challenge3Scenario6() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase9Challenge3Scenario5() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase9Challenge3Scenario4() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase9Challenge3Scenario3() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase9Challenge3Scenario2() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        cols.put("val", "1");
        cols.put("res", "1");
        row1.setCols(cols);
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase9Challenge3Scenario1() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        row1.setCols(cols);
        cols.put("val", "1");
        cols.put("res", "1");
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase9Challenge2(int scenario) {
        switch (scenario) {
        case 1:
            return getResultPhase9Challenge2Scenario1();
        case 2:
            return getResultPhase9Challenge2Scenario2();
        case 3:
            return getResultPhase9Challenge2Scenario3();
        case 4:
            return getResultPhase9Challenge2Scenario4();
        case 5:
            return getResultPhase9Challenge2Scenario5();
        case 6:
            return getResultPhase9Challenge2Scenario6();
        default:
            return getResultPhase9Challenge2Scenario7();
        }
    }
    
    private static ResultSet getResultPhase9Challenge2Scenario7() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase9Challenge2Scenario6() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase9Challenge2Scenario5() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase9Challenge2Scenario4() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase9Challenge2Scenario3() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase9Challenge2Scenario2() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        cols.put("val", "1");
        cols.put("res", "0");
        row1.setCols(cols);
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase9Challenge2Scenario1() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        row1.setCols(cols);
        cols.put("val", "1");
        cols.put("res", "0");
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase9Challenge1(int scenario) {
        switch (scenario) {
        case 1:
            return getResultPhase9Challenge1Scenario1();
        case 2:
            return getResultPhase9Challenge1Scenario2();
        case 3:
            return getResultPhase9Challenge1Scenario3();
        case 4:
            return getResultPhase9Challenge1Scenario4();
        case 5:
            return getResultPhase9Challenge1Scenario5();
        case 6:
            return getResultPhase9Challenge1Scenario6();
        default:
            return getResultPhase9Challenge1Scenario7();
        }
    }
    
    private static ResultSet getResultPhase9Challenge1Scenario7() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase9Challenge1Scenario6() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase9Challenge1Scenario5() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase9Challenge1Scenario4() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase9Challenge1Scenario3() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "1");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase9Challenge1Scenario2() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        cols.put("val", "1");
        cols.put("res", "1");
        row1.setCols(cols);
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase9Challenge1Scenario1() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        row1.setCols(cols);
        cols.put("val", "1");
        cols.put("res", "0");
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase9Challenge0(int scenario) {
        switch (scenario) {
        case 1:
            return getResultPhase9Challenge0Scenario1();
        case 2:
            return getResultPhase9Challenge0Scenario2();
        case 3:
            return getResultPhase9Challenge0Scenario3();
        case 4:
            return getResultPhase9Challenge0Scenario4();
        case 5:
            return getResultPhase9Challenge0Scenario5();
        case 6:
            return getResultPhase9Challenge0Scenario6();
        default:
            return getResultPhase9Challenge0Scenario7();
        }
    }
    
    private static ResultSet getResultPhase9Challenge0Scenario7() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase9Challenge0Scenario6() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase9Challenge0Scenario5() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase9Challenge0Scenario4() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase9Challenge0Scenario3() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols1 = new HashMap<String, String>();
        row1.setCols(cols1);
        cols1.put("val", "1");
        cols1.put("res", "0");
        rows.addAll(Arrays.asList(row1));
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase9Challenge0Scenario2() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        cols.put("val", "1");
        cols.put("res", "0");
        row1.setCols(cols);
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

    private static ResultSet getResultPhase9Challenge0Scenario1() {
        ResultSet resultSet = new ResultSet();
        List<ResultRow> rows = new ArrayList<ResultRow>();
        ResultRow row1 = new ResultRow();
        HashMap<String, String> cols = new HashMap<String, String>();
        row1.setCols(cols);
        cols.put("val", "1");
        cols.put("res", "1");
        rows.add(row1);
        resultSet.setRows(rows);
        return resultSet;
    }

}
