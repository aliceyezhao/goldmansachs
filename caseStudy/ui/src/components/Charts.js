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

import React from 'react';
import LineChart from './charts/LineChart';

class Charts extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            //date:'', line:'', posts=[], datestamp:undefined};
            //this.handleStockChange= this.handleStockChange.bind(this);
            data: undefined
        };
            
        // this.dataSourceHelper = this.dataSourceHelper.bind(this);
            /**
             * TODO
             * Initialize a state object to store a JavaScript object returned from the helper method.
             * It can be initialized to be empty.
             */
            
    }


    componentWillReceiveProps(nextProps) {
        this.dataSourceHelper(nextProps);
    }

    dataSourceHelper(props) {        
        console.log("Fetch data when company, start or end changes");
        props = props || this.props;
        let ticker = props.ticker
        let start = props.start
        let end = props.end
        console.log(`/${ticker}/${start}/${end}`)
        fetch(`/${ticker}/${start}/${end}`)
        .then((response) => {
            return response.json();
        })
        .then(data => {
            console.log(data)
            this.setState({
                data
            })
        }).catch(error => {
            console.log(error);
        });
        
        // Hard coded
        var data = data = [{
            "3/15/2019": 210.08,
  "4/6/2019": 235.08,
  "4/21/2019": 243.61,
  "2/16/2019": 205.43,
  "2/20/2019": 207.68,
  "4/3/2019": 242.38,
  "5/1/2019": 238.49,
  "3/8/2019": 235.57,
  "5/5/2019": 262.78,
  "4/4/2019": 231.23,
  "3/2/2019": 213.77,
  "3/17/2019": 199.43,
  "4/28/2019": 248.97,
  "4/20/2019": 226.41,
  "2/1/2019": 245.97,
  "4/25/2019": 264.28,
  "3/30/2019": 222.98,
  "3/16/2019": 199.43,
  "2/10/2019": 237.4,
  "3/29/2019": 235.45,
  "2/3/2019": 218.15,
  "3/13/2019": 224.29,
  "4/24/2019": 253.94,
  "3/27/2019": 218.32,
  "4/27/2019": 264.61,
  "4/19/2019": 237.9,
  "3/31/2019": 242.38,
  "3/14/2019": 210.08,
  "2/7/2019": 253.35,
  "2/17/2019": 192,
  "4/10/2019": 235.08,
  "4/13/2019": 213.72,
  "2/21/2019": 207.68,
  "3/6/2019": 216.7,
  "4/18/2019": 219.9,
  "2/13/2019": 237.4,
  "2/23/2019": 226.71,
  "2/15/2019": 220.55,
  "3/7/2019": 235.57,
  "4/17/2019": 230.46,
  "3/24/2019": 218.32,
  "2/8/2019": 242.83,
  "3/1/2019": 225.34,
  "2/27/2019": 225.34,
  "2/2/2019": 235.07,
  "4/11/2019": 215.31,
  "4/14/2019": 213.72,
  "4/26/2019": 251.53,
  "3/3/2019": 196.94,
  "5/2/2019": 250.39,
  "3/23/2019": 199.5,
  "2/6/2019": 236.29,
  "2/9/2019": 254.15,
  "4/5/2019": 247.33,
  "3/10/2019": 235.84,
  "3/9/2019": 222.94,
  "4/12/2019": 233.41,
  "4/7/2019": 235.08,
  "5/3/2019": 232.79,
  "3/21/2019": 203.95,
  "2/28/2019": 225.34,
  "3/22/2019": 187.26,
  "2/24/2019": 244.82,
  "2/22/2019": 207.68,
  "3/28/2019": 235.45,
  "2/14/2019": 220.55,
  "5/4/2019": 243.86,
  "3/20/2019": 187.99
       }]  
        this.setState({data:data});
    }

        /**
         * TODO
         * Write a helper method to make an AJAX HTTP request to your service for the
         * company and dates specified in a props parameter. You can use promises(axios),
         * fetch, jQuery...there are many libraries to help you do this. The data you will
         * receive will be in a JSON format.
         * https://hashnode.com/post/5-best-libraries-for-making-ajax-calls-in-react-cis8x5f7k0jl7th53z68s41k1
         * fetch: https://davidwalsh.name/fetch
         * axios: https://github.com/mzabriskie/axios (you will need to install this package)
         * jquery: http://api.jquery.com/jquery.getjson/ (you will need to install the jquery package)
         *
         * The URL will be on your localhost (e.g. http://localhost:8000/service_path/some_param) where
         * your service is running. Your service MUST be running for the request to work (you can add a catch function
         * to handle errors). Once you make the request, you will want to convert the JSON to a JavaScript
         * object and set in the component state so it can be passed as a prop to your LineChart component.
         *
         * REMEMBER, you'll need to use '=>' if you want to set the state in a callback or promise due
         * to the scope of the 'this' object.
         *
         * Data received should be in a JSON format of
         * {
         *      "dailyClosePrices": [
         *      {
         *         "3/15/2018": 284.97,
         *          "4/6/2018": 152.97,
         *          "4/21/2018": 156.97,
         *          ...
         *      }],
         *      "name": "SOME_STOCK_NAME"
         *  }
         *
         *  Do you need to enable CORS for your service??
         *  https://spring.io/guides/gs/rest-service-cors/#_enabling_cors
         *
         *  Don't forget to bind the helper method in the constructor!
         * */
    
    render() {
        /**
         * TODO
         * Render your LineChart component and pass the data for the chart to display via props
         */
        return <LineChart data = {this.state.data}/>
    }
}

// Don't forget to export your component!
export default Charts;
