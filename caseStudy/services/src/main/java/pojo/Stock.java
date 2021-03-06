/**
 * Copyright 2019 Goldman Sachs.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package pojo;

import java.util.*;

/**
 * This class will define a company's end-of-day stock price
 * Look at resources/data/historicalStockData.json
 */
//Done
public class Stock {

    // TODO - Think back to your modelling session
    // Define the attributes of a stock price based on the
    // provided data in resources/data

    // TODO - add getter and setter methods for your attributes

    private String name;
    private List<HashMap<String, Double>> dailyClosePrice;

    public Stock(){

    }

    public Stock(String name, List<HashMap<String, Double>> dailyClosePrice) {
        this.name = name;
        this.dailyClosePrice = dailyClosePrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<HashMap<String, Double>> getDailyClosePrice() {
        return dailyClosePrice;
    }

    public void setDailyClosePrice(List<HashMap<String, Double>> dailyClosePrice) {
        this.dailyClosePrice = dailyClosePrice;
    }
}
