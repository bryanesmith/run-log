/*eslint-disable no-unused-vars*/
import React from 'react';
import ChartistGraph from 'react-chartist';
/*eslint-enable no-unused-vars*/

import moment from 'moment';

import {
  TAB_7_DAY,
  TAB_30_DAY,
  TAB_365_DAY,
  TAB_ALL,
} from 'run-log/components/dashboard/actions';
import { generateMomentsUntil } from 'run-log/scripts/utils/dates';
import { filterEventsByEndDate, totalDistance } from 'run-log/scripts/utils/events.js';

/*
 * Generates data for bar chart.
 */
function barChartData(events, xLabelFn, barOpts) {

  // fetch the ending moment for every bar
  const dates = generateMomentsUntil(
    barOpts.count,
    barOpts.units,
    barOpts.length,
    moment()
  );

  // Partition all run events into a bucket per bar
  const runSeries = dates.map(endDate => {
    const runs = events.filter(e => ['Run','Run+CrossTrain'].includes(e['@type']));
    const filtered = filterEventsByEndDate(runs, endDate, barOpts.units, barOpts.length);
    return totalDistance(filtered);
  });

  // Find maximum run distance
  const maxDistance = Math.max(...runSeries);

  // Partition all cross-training events into a bucket per bar
  //   Note that the height of these bars will always be half of maximum run height
  const crossTrainingSeries = dates.map(endDate => {
    const crossTrains = events.filter(e => ['CrossTrain','Run+CrossTrain'].includes(e['@type']));
    const filtered = filterEventsByEndDate(crossTrains, endDate, barOpts.units, barOpts.length);

    if (filtered.length > 0) {
      // If no runs, any height will do, so use 1
      return isNaN(maxDistance) || maxDistance === 0 ? 1 : maxDistance / 2;
    } else {
      return null; // No activity
    }
  });

  return {
    labels: dates.map(xLabelFn),
    series: [runSeries, crossTrainingSeries],
  };
}

/*
 * Common options for all bar charts.
 */
function barChartOptions() {
  return {
    axisY: {
      labelInterpolationFnc: function(value) {
        return `${value} mi`;
      },
    },
  };
}

/*
 * Given selected tabs, returns the parameters needed for barChartData.
 */
function selectedTabBarChartParams(selectedTab) {
  switch (selectedTab) {
    case TAB_7_DAY:
      return {
        barOpts: { count: 7, units: 'Day', length: 1 },
        xLabelFn: m => m.format('dd'),
      };
    case TAB_30_DAY:
      return {
        barOpts: { count: 10, units: 'Day', length: 3 },
        xLabelFn: m => m.format('MM/DD'),
      };
    case TAB_365_DAY:
      return {
        barOpts: { count: 12, units: 'Month', length: 1 },
        xLabelFn: m => m.format('MMM'),
      };
    case TAB_ALL:
      return {
        barOpts: { count: 8, units: 'Year', length: 1 },
        xLabelFn: m => m.format('YYYY'),
      };
  }
}

/*
 * Renders a bar chart for 7d, 30d, 365d, or all-time.
 */
export default props => {
  const params = selectedTabBarChartParams(props.selectedTab);
  return (
    <ChartistGraph
      data={barChartData(props.events, params.xLabelFn, params.barOpts)}
      options={barChartOptions()}
      type={'Bar'}
    />
  );
};
