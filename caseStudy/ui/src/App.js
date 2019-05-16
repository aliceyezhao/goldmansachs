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
import './style/App.css';
import StockTicker from './components/StockTicker';
import Date from './components/Date';
import Charts from './components/Charts';

/**
 * TODO:
 * Import your components
 */


class App extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            /**
             * TODO
             * Add state objects for the user inputs and anything else you may need to render the highchart.
             */
            start:undefined,
            end:undefined,
            ticker: undefined
        };

        this.handleChangeDateEnd = this.handleChangeDateEnd.bind(this)
        this.handleChangeDateStart = this.handleChangeDateStart.bind(this)
        this.handleChangeStockTicker = this.handleChangeStockTicker.bind(this)
    }


    handleChangeStockTicker(ticker){
      this.setState({ticker:ticker})
      console.log("ticker")
    }

    handleChangeDateStart(start){
      this.setState({start:start})
      console.log("start")
    }

    handleChangeDateEnd(end){
      this.setState({end:end})
      console.log("end")
    }

    render () {
      return (
          <div className="page-display">
          <h1>Group 1's Stock Ticker</h1>
              <div className="input">             

              
              <StockTicker onChange={this.handleChangeStockTicker}/>
              
              {/**
               * TODO
               * Render the StockTicker and Date components. You can use the date component twice
               * for both the start and end dates.
               * Add onChange props to the StockTicker and both Date components.
               * These props methods should set state and help determine if the
               * highchart should be displayed by changing the state of that boolean.
               * Don't forget to bind these methods!
               */}
               
                <div className="date-range">
                  <Date onChange = {this.handleChangeDateStart}/>
                  <Date onChange = {this.handleChangeDateEnd}/>
                </div>
                
                
               
              </div>


                 {/**
                   *  TODO
                   *  Create a div element that shows a highchart when the ticker, start date, end date
                   *  states ALL have values and nothing (null) otherwise. You will need to use a conditional here
                   *  to help control rendering and pass these states as props to the component. This conditional can
                   *  be maintained as a state object.
                   *  http://reactpatterns.com/#conditional-rendering
                   */}
                   <Charts ticker={this.state.ticker} start={this.state.start} end={this.state.end}/>
          </div>
      );
    }
}

export default App;
