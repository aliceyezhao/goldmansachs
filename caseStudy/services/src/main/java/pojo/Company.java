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

/**
 * This class will define a company and its attributes
 * Look at resources/data/companyInfo.json
 */
//Done
public class Company {

    // TODO - Think back to your modelling session
    // Define the attributes of a Company based on the
    // provided data in resources/data

    // TODO - add getter and setter methods for your attributes

    private String symbol;
    private String name;
    private String headquartersCity;
    private String headquartersStateOrCountry;
    private int numberOfEmployees;
    private String sector;
    private String industry;

    //Main constructor
    public Company (String symbol, String name, String hqCity, String hqStateOrCountry, int numberOfEmployees, String sector, String industry) {
        this.symbol = symbol;
        this.name = name;
        this.headquartersCity = hqCity;
        this.headquartersStateOrCountry = hqStateOrCountry;
        this.numberOfEmployees = numberOfEmployees;
        this.sector = sector;
        this.industry = industry;
    }

    //Basic setters methods
    public void setHqCity(String hqCity) {
        this.headquartersCity = hqCity;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public void setHqStateOrCountry(String hqStateOrCountry) {
        this.headquartersStateOrCountry = hqStateOrCountry;
    }


    //Basic getter methods
    public String getIndustry() {
        return this.industry;
    }

    public String getSector() {
        return this.sector;
    }

    public int getNumberOfEmployees() {
        return this.numberOfEmployees;
    }

    public String getHqStateOrCountry() {
        return this.getHqStateOrCountry();
    }

    public String getHqCity() {
        return this.headquartersCity;
    }

    public String getName() {
        return this.getName();
    }

    public String getSymbol() {
        return this.getSymbol();
    }
}
