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

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import pojo.Company;
import pojo.Stock;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Write your tests for the Stock Resource here
 */
public class StockResourceTest extends JerseyTest {

    // TODO - write a test for each method in the CompanyResource class
    // Think about both positive and negative test cases:
    // What happens if no inputs are passed?
    // What happens if the input is null?

    @Override
    protected Application configure() {
        return new ResourceConfig(
                StockResource.class
        );
    }

    @Test
    public void test() {
        WebTarget target = target("company/ADBE/2-16-2019/4-4-2019");
        Stock response = target.request().get(Stock.class);
        assertEquals("ADBE",response.getName());
        assertFalse(response.getDailyClosePrice().get(0).isEmpty());
    }

}
