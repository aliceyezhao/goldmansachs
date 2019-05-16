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

// TODO - add your @Path here

import jdk.nashorn.internal.objects.annotations.Getter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import pojo.Company;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


//check
@Path("company")
public class CompanyResource {

    private static List<Company> listOfCompanies;

    public static void initialize() {
        try {
            listOfCompanies = FileHelper.getCompanyList("companyInfo.json");
        } catch (FileNotFoundException e) {
            //handle exception
        } catch (IOException e) {
            //handle exception
        }
    }

    //have it like a property in Company Resource
    //Starter app
    //initialize that will create the List from file Helper

    // TODO - Add a @GET resource to get company data
    // Your service should return data for a given stock ticker
    @GET
    public Company getCompanyInfo(String comp) {
        for (Company company: listOfCompanies) {
            if (company.getName().equals(comp)) {
                return company;
            }
        }
        return null;
    }


}
