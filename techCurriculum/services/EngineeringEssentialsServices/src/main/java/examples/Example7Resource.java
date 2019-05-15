package examples;


import model.Country;
import model.Event;
import utility.FileHelper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Copyright 2018 Goldman Sachs.
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
@Path("events")
public class Example7Resource {

    /**
     * Example 7 Instructions:
     * <p>
     * Modify the method below to return the list of all of the events that a country participated in
     * <p>
     * Note: The country name should be case insensitive ("UnitedStates" returns the same results as "UnitedStates")
     * If no events are found for a country, return a message stating the country was not found
     * <p>
     * URL: http://localhost:8080/events/country/{countryName}
     */
    @GET
    @Path("country/{countryName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEventsForCountry(@PathParam("countryName") String countryName) throws IOException {
        List<Event> events = FileHelper.readAllEvents("events.json");
        List<Event> filter = events.stream().filter(event ->
                event.getAwayCountry().name().equalsIgnoreCase(countryName) ||
                event.getHomeCountry().name().equalsIgnoreCase(countryName))
                .collect(Collectors.toList());
        return Response.ok().entity(filter).build();
    }

}
