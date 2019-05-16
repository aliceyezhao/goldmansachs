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
import Highcharts from 'highcharts';

class LineChart extends React.Component {
    constructor(props) {
        super(props);
    }

    componentDidMount() {
        this.chart = Highcharts.chart('chart', {

            // TODO
            // Create a highcharts line chart of your choosing (e.g. 
            // https://www.highcharts.com/demo/line-time-series for a demo).
            chart: {
                zoomType: 'x'
            },
            title: {
                text: 'Stock'
            },
            // subtitle: {
            //     text: document.ontouchstart === undefined ?
            //         'Click and drag in the plot area to zoom in' : 'Pinch the chart to zoom in'
            // },
            xAxis: {
                type: 'datetime',
                title: {
                    text: 'Date'
                }
            },
            yAxis: {
                title: {
                    text: 'Price'
                }
            },
            legend: {
                enabled: false
            },
            plotOptions: {
                area: {
                    fillColor: {
                        linearGradient: {
                            x1: 0,
                            y1: 0,
                            x2: 0,
                            y2: 1
                        },
                        stops: [
                            [0, Highcharts.getOptions().colors[0]],
                            [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
                        ]
                    },
                    marker: {
                        radius: 2
                    },
                    lineWidth: 1,
                    states: {
                        hover: {
                            lineWidth: 1
                        }
                    },
                    threshold: null
                }
            },
            series: [{
                name: 'Prices',
                data: this.props.data
            }]
        });

    }

  unpack_data(_data){
        var new_data = []
        _data.map((dict)=>{
            Object.keys(dict).map((key, index)=>{ 
                let temp_key = key.split("/")
                let year = +temp_key[2]
                let month = +temp_key[0] - 1
                let day = +temp_key[1]
                let new_key = Date.UTC(year, month, day,0, 0,0,0 )
                new_data.push([new_key , dict[key]])
            })
        })
        
        // return sorted data
        new_data.sort((a, b)=>{return a[0] - b[0]})
        return new_data
    }

    componentWillReceiveProps(props) {
        console.log("New data received to redraw chart.");

        /**
         * TODO
         * Parse the data received from props, a Javascript object, to map to a Javascript array
         * required by the type of line chart chosen and set it in the series. Use Date.UTC(..)
         * to create the x-axis.
         */

        /**
         * TODO
         * Uncomment the line below to pass the data be displayed to the series
         */
         this.chart.series[0].setData(this.unpack_data(props.data));
         
    }

    componentWillUnmount() {
        this.chart.destroy();
    }


    render() {
        return ( <div id='chart'> </div>
        )
    }
}

// Don't forget to export your component!

export default LineChart