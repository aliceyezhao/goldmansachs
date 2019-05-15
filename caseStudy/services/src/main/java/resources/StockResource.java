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

package resources;

import pojo.DailyStock;
import pojo.Stock;

import java.util.*;

import java.io.IOException;
import java.io.FileNotFoundException;
import javax.ws.rs.Path;
import java.ws.rs.GET;

// TODO - add your @Path here
@Path("company")
public class StockResource {

    private static List<Stock> listOfStockPrices;

    public static void initialize() {
        try {
            listOfStockPrices = FileHelper.getStockList("historicalStockData.json");
        } catch (FileNotFoundException e) {
            //handle exception
        } catch (IOException e) {
            //handle exception
        }
    }

    // TODO - Add a @GET resource to get stock data
    // Your service should return data based on 3 inputs
    // Stock ticker, start date and end date


    //TO do:
    //Figure out import errors
    @Path("stockdata/{name}/{start}/{end}")
    @GET
    public Stock getStock(@PathParam("name") String name, @PathParam("start") String start, @PathParam("end")String end) {
        Stock current = ;

        for (Stock stock: listOfStockPrices) {
            if (stock.getName().equals(name)) {
                current = stock;
            }
        }
        if (current != null) {
            List<HashMap<String, Double>> subList = new ArrayList<HashMap<String, Double>>();
            List<HashMap<String, Double>> completeList = current.getCompleteListOfPrices();
            for (HashMap<String, Double> dailyPrice: completeList) {

                //Figure out a way to retrieve the only key from hashmap
                //Assuming HashMap has length of 1
                Set<String> onlyKey = dailyPrice.keySet();

                //String curentDate = onlyK

                        //...
                if (checkWithinRange(start, end, currentDate)) {
                    subList.add(dailyPrice);
                }
            }
            Stock modifiedStock = new Stock(current.getName(), subList);
            return modifiedStock;
        }
        return null;
    }

    private Date date(String currentDate) {
        String[] arr_start = currentDate.split("/");
        int year = Integer.parseInt(arr_start[2]);
        int day = Integer.parseInt(arr_start[1]);
        int month = Integer.parseInt(arr_start[0]);
        Date date = new Date(year,month - 1,day);
        return date;
    }

    private boolean checkWithinRange(String start, String end, String current) {
        Date sDate = date(start);
        Date eDate = date(end);
        Date cDate = date(current);
        if ((sDate.compareTo(cDate) <= 0) && (eDate.compareTo(cDate) >= 0)) {
            return true;
        }
        return false;
    }


}
