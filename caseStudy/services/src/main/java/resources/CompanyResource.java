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

// TODO - add your @Path here

import jdk.nashorn.internal.objects.annotations.Getter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import pojo.Company;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


//check
@Path("companyInfo")
public class CompanyResource {

    private static List<Company> listOfCompanies;
    public static final String FILE_PATH = "C:/Users/chubi/Documents/GMS/goldmansachs/caseStudy/services/src/main/resources/data/companyInfo.json";

    public CompanyResource() {
//        CompanyResource.initialize();
    }

    public static void initialize() {
        if (listOfCompanies == null)
            try {
                listOfCompanies = FileHelper.getCompanyList(FILE_PATH);
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
    @Path("{ticker}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompanyInfo(@PathParam("ticker") String ticker) {
        if (listOfCompanies == null)
            initialize();

        for (Company company: listOfCompanies) {
            if (company.getSymbol().equalsIgnoreCase(ticker)) {
                return Response.ok().entity(company).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).entity(ticker).build();
    }


}
