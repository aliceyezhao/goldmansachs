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
public class Stock {

    // TODO - Think back to your modelling session
    // Define the attributes of a stock price based on the
    // provided data in resources/data

    private String name;
    private Map<Date, Float> dailyClosePrice;
    // TODO - add getter and setter methods for your attributes

    public Stock (String name, Map<Date, Float> dailyClosePrice) {
        this.name = name;
        Map<Date, Float> map = new TreeMap<Date, Float>(dailyClosePrice);
        this.dailyClosePrice = map;
    }


    public String getName() {
        return this.name;
    }

    public Float getPrice(Date d) {
        return dailyClosePrice.get(d);
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Float> getPriceList() {

        ArrayList<Float> prices =  new ArrayList<Float>();
        for (Float p : this.dailyClosePrice.values()) {
            prices.add(p);
        }
        return prices;
    }

    public ArrayList<Date> getDateList() {
        ArrayList<Date> dates =  new ArrayList<Date>();
        for (Date d : this.dailyClosePrice.keySet()) {
            dates.add(d);
        }
        return dates;
    }

    public void setDailyClosePrice(Map<Date, Float> map) {
        this.dailyClosePrice = map;
    }

    public void putDailyClosePrice(Date d, Float price) {
        this.dailyClosePrice.put(d, price);
        Map<Date, Float> map = new TreeMap<Date, Float>(dailyClosePrice);
        this.dailyClosePrice = map;
    }
}
