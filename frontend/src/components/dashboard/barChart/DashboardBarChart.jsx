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
import { addMoment, subtractMoment } from 'run-log/scripts/utils/dates';
import { filterEventsByEndDate, totalDistance } from 'run-log/scripts/utils/events.js';

/*
 * Returns a series of moments ending in now with specified
 *   length and durations.
 *
 * E.g., length = 5, units = 'Days', duration = 2,
 *   returns [10, 8, 6, 4, 2, 0].map(d => moment().subtract({days: d}))
 */
function generateSeriesOfMoments(length, units, duration, endDate) {
  const dates = [];

  // If not measuring days, the end should be the end of the calendar month
  //   or year....
  if (['Month', 'Year'].includes(units)) {
    endDate = addMoment(endDate.startOf(units), units, 1);
  }

  for (let i = length - 1; i >= 0; i--) {
    const date = subtractMoment(endDate, units, i * duration);
    dates.push(date);
  }

  return dates;
}

/*
 * Generates data for bar chart.
 */
function barChartData(events, xLabelFn, barOpts) {

  // normalize dates
  const filteredEvents = events.map(e =>
    Object.assign({}, e, { date: moment(e.date) })
  );

  // fetch the ending moment for every bar
  const dates = generateSeriesOfMoments(
    barOpts.count,
    barOpts.units,
    barOpts.length,
    moment()
  );

  // Partition all run events into a bucket per bar
  const runs = dates.map(endDate => {
    const s = filterEventsByEndDate(filteredEvents, ['Run','Run+CrossTrain'], endDate, barOpts.units, barOpts.length);
    return totalDistance(s);
  });

  // Find maximum run distance
  const maxDistance = Math.max(...runs);

  // Partition all cross-training events into a bucket per bar
  //   Note that the height of these bars will always be half of maximum run height
  const crossTrainingEvents = dates.map(endDate => {
    const s = filterEventsByEndDate(filteredEvents, ['CrossTrain'], endDate, barOpts.units, barOpts.length);

    if (s.length > 0) {
      // If no runs, any height will do, so use 1
      return isNaN(maxDistance) ? 1 : maxDistance / 2;
    } else {
      return null; // No activity
    }
  });

  return {
    labels: dates.map(xLabelFn),
    series: [runs, crossTrainingEvents],
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
