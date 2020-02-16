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

public class CallStatements {

    public static String get(Integer scenario) {
        switch (scenario) {
        case 1:
            return "{call InjectScene1()}";
        case 2:
            return "{call InjectScene2()}";
        case 3:
            return "{call InjectScene3()}";
        case 4:
            return "{call InjectScene4()}";
        case 5:
            return "{call InjectScene5()}";
        case 6:
            return "{call InjectScene6()}";
        default:
            return "{call InjectScene7()}";
        }
    }

}
