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
export function barChartData(selectedTab, events, date) {

  const {xLabelFn, barOpts} = selectedTabBarChartParams(selectedTab);
  const until = calculateFinalDate(date, selectedTab);

  // fetch the ending moment for every bar
  const dates = generateMomentsUntil(
    barOpts.count,
    barOpts.units,
    barOpts.length,
    until
  );

  const runSeries = getRunSeries(dates, events, barOpts);

  const maxDistance = Math.max(...runSeries);

  // We only want cross-training if on the TAB_7_DAY tab.
  //   Additionally, only if there are cross-training sessions; otherwise,
  //   doesn't look ass nice because the cross-training series messes w/
  //   centering of run series.
  const includeCrossTraining = [TAB_7_DAY].includes(selectedTab) &&
    events.find(e => ['CrossTrain','Run+CrossTrain'].includes(e['@type']));

  const crossTrainingSeries = includeCrossTraining ?
    getCrossTrainingSeries(dates, events, barOpts, maxDistance) : [];

  return {
    labels: dates.map(xLabelFn),
    series: includeCrossTraining ? [runSeries, crossTrainingSeries] : [runSeries],
  };
}

/**
 * Generates series of run events.
 */
function getRunSeries(dates, events, barOpts) {
  return dates.map(endDate => {
    const runs = events.filter(e => ['Run','Run+CrossTrain'].includes(e['@type']));
    const filtered = filterEventsByEndDate(runs, endDate, barOpts.units, barOpts.length);
    return totalDistance(filtered);
  });
}

/**
 * Generates series of cross-training events.
 *   Note that the height of these bars will always be half of maximum run height.
 */
function getCrossTrainingSeries(dates, events, barOpts, maxDistance) {
  return dates.map(endDate => {
    const crossTrains = events.filter(e => ['CrossTrain','Run+CrossTrain'].includes(e['@type']));
    const filtered = filterEventsByEndDate(crossTrains, endDate, barOpts.units, barOpts.length);

    if (filtered.length > 0) {
      // If no runs, any height will do, so use 1
      return isNaN(maxDistance) || maxDistance === 0 ? 1 : maxDistance / 2;
    } else {
      return null; // No activity
    }
  });
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
export function selectedTabBarChartParams(selectedTab) {
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

export function calculateFinalDate(date, selectedTab) {
  switch (selectedTab) {
    case TAB_7_DAY:
      return date;
    case TAB_30_DAY:
      return date; // TODO: wrong; just remove 30d
    case TAB_365_DAY:
      return date.endOf('month');
    case TAB_ALL:
      return date.endOf('year');
  }
}

/*
 * Renders a bar chart for 7d, 30d, 365d, or all-time.
 */
export default props => {
  const date = moment(); // want labels to be grounded on current time
  return (
    <ChartistGraph
      data={barChartData(props.selectedTab, props.events, date)}
      options={barChartOptions()}
      type={'Bar'}
    />
  );
};
