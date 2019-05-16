/**
 * Copyright 2019 Goldman Sachs.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package resources;

import pojo.Stock;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import java.io.IOException;
import java.io.FileNotFoundException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

// TODO - add your @Path here
@Path("company")
public class StockResource {

    private static List<Stock> listOfStockPrices;
    public static final String FILE_PATH = "C:/Users/chubi/Documents/GMS/goldmansachs/caseStudy/services/src/main/resources/data/historicalStockData.json";

    public static void initialize() {
        if (listOfStockPrices == null)
            try {
                listOfStockPrices = FileHelper.getStockList(FILE_PATH);
            } catch (FileNotFoundException e) {
                //handle exception
            } catch (IOException e) {
                //handle exception
            }
    }

    public StockResource() {
        StockResource.initialize();
    }

    // TODO - Add a @GET resource to get stock data
    // Your service should return data based on 3 inputs
    // Stock ticker, start getDate and end getDate


    //TO do:
    //Figure out import errors
    @Path("{name}/{start}/{end}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStock(@PathParam("name") String name, @PathParam("start") String start, @PathParam("end") String end) {
        Stock current = null;
        if (listOfStockPrices == null)
            initialize();

        for (Stock stock : listOfStockPrices) {
            if (stock.getName().equalsIgnoreCase(name)) {
                current = stock;
            }
        }
        if (current != null) {
            HashMap<String, Double> subList = new HashMap<String, Double>();
            List<HashMap<String, Double>> completeList = current.getDailyClosePrice();
            for (HashMap<String, Double> hashMap : completeList) {

                //Figure out a way to retrieve the only key from hashmap
                //Assuming HashMap has length of 1
                for (HashMap.Entry<String, Double> dailyPrice : hashMap.entrySet()) {
                    String onlyKey = dailyPrice.getKey();
                    if (checkWithinRange(start, end, onlyKey)) {
                        subList.put(dailyPrice.getKey(), dailyPrice.getValue());
                    }
                }
            }
            List<HashMap<String, Double>> list = new ArrayList<HashMap<String, Double>>();
            list.add(subList);
            Stock stock = new Stock(current.getName(), list);
            return Response.ok().entity(stock).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    private Date getDate(String date) {
        date = date.replace('-','/');
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        try {
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean checkWithinRange(String start, String end, String current) {
        Date sDate = getDate(start);
        Date eDate = getDate(end);
        Date cDate = getDate(current);
        try {
            return (sDate.compareTo(cDate) <= 0) && (eDate.compareTo(cDate) >= 0);
        }catch (NullPointerException e){
            e.printStackTrace();;
            return false;
        }
    }


}
