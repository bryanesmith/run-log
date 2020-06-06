import {
  TAB_7_DAY,
  TAB_6_WEEK,
  TAB_365_DAY,
  TAB_ALL,
} from 'run-log/components/dashboard/actions';

import {
  barChartData,
  calculateFinalDate,
  selectedTabBarChartParams
} from './DashboardBarChart';

import moment from 'moment';
import each from 'jest-each';

describe('calculateFinalDate should', () => {

  // TODO: use timezones instead of funky math based on daylight savings and timezones
  each([
    [moment('2020-06-06'), moment('2020-06-06'), TAB_7_DAY],
    [moment('2020-06-07'), moment('2020-06-01'), TAB_6_WEEK], // mon
    [moment('2020-06-07'), moment('2020-06-06'), TAB_6_WEEK], // tue
    [moment('2020-06-07'), moment('2020-06-07'), TAB_6_WEEK], // wed
    [moment('2020-06-30'), moment('2020-06-06'), TAB_365_DAY],
    [moment('2020-12-31'), moment('2020-06-06'), TAB_ALL],
  ]).it('return %s for %s on tab "%s"', (expected, date, tab) => {
    const found = calculateFinalDate(date, tab);
    expect(found.format('YYYY-MM-DD')).toEqual(expected.format('YYYY-MM-DD'));
  });
});

describe('barChartData should', () => {

  const EVENTS_TAB_ALL_ACROSS_YEARS = [
    {'@type': 'Run', 'date': '2017-12-15T09:00:00', run: {distance: 6}},
    {'@type': 'Run', 'date': '2018-08-12T09:00:00', run: {distance: 12}},
    {'@type': 'Run', 'date': '2020-06-05T09:00:00', run: {distance: 3}},
  ];

  const EVENTS_MULTIPLE_2019_08_03 = [
    {'@type': 'Run', 'date': '2019-08-03T09:00:00', run: {distance: 5}},
    {'@type': 'Run', 'date': '2019-08-03T09:00:00', run: {distance: 12}},
    {'@type': 'Run', 'date': '2019-08-03T09:00:00', run: {distance: 2}},
  ];

  const LABELS_2013_THRU_2020 = ['2013', '2014', '2015', '2016', '2017', '2018', '2019', '2020'];

  const LABELS_JULY_THRU_JUNE = ['Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec', 'Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun'];

  const LABELS_APR_27_THRU_JUN_7 = [ '4/27 - 5/3', '5/4 - 5/10', '5/11 - 5/17', '5/18 - 5/24', '5/25 - 5/31', '6/1 - 6/7' ];

  const LABELS_SUN_THRU_SAT = ['Su', 'Mo', 'Tu', 'We', 'Th', 'Fr', 'Sa'];

  each([
    // TAB_ALL: Show aggregates data across years
    [TAB_ALL, '2020-01-01', EVENTS_TAB_ALL_ACROSS_YEARS, LABELS_2013_THRU_2020, [0, 0, 0, 0, 6, 12, 0, 3]],

    // TAB_ALL: Show aggregates data across years
    [TAB_ALL, '2020-12-31', EVENTS_TAB_ALL_ACROSS_YEARS, LABELS_2013_THRU_2020, [0, 0, 0, 0, 6, 12, 0, 3]],

    // Show aggregates multiple events in given day
    [TAB_ALL, '2020-08-03', EVENTS_MULTIPLE_2019_08_03, LABELS_2013_THRU_2020, [0, 0, 0, 0, 0, 0, 19, 0]],

    // TAB_365_DAY: Show aggregates data correctly across months
    [TAB_365_DAY, '2020-06-06', [
      {'@type': 'Run', 'date': '2019-07-03T09:00:00', run: {distance: 3}},
      {'@type': 'Run', 'date': '2019-11-03T09:00:00', run: {distance: 5}},
      {'@type': 'Run', 'date': '2020-01-03T09:00:00', run: {distance: 6}},
      {'@type': 'Run', 'date': '2020-03-03T09:00:00', run: {distance: 8}},
      {'@type': 'Run', 'date': '2020-06-03T09:00:00', run: {distance: 12}},
    ], LABELS_JULY_THRU_JUNE, [3, 0, 0, 0, 5, 0, 6, 0, 8, 0, 0, 12]],

    // TAB_365_DAY: Show aggregates multiple events in given day
    [TAB_365_DAY, '2020-06-06', EVENTS_MULTIPLE_2019_08_03, LABELS_JULY_THRU_JUNE, [0, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]],

    // TAB_6_WEEK: Show aggregates data correctly across weeks
    [TAB_6_WEEK, '2020-06-06', [
      // week 2
      {'@type': 'Run', 'date': '2020-04-28T09:00:00', run: {distance: 4}},
      {'@type': 'Run', 'date': '2020-05-01T09:00:00', run: {distance: 9}},
      // week 5
      {'@type': 'Run', 'date': '2020-05-31T09:00:00', run: {distance: 3}},
      // week 6
      {'@type': 'Run', 'date': '2020-06-01T09:00:00', run: {distance: 5}},
      {'@type': 'Run', 'date': '2020-06-07T09:00:00', run: {distance: 2}},
    ], LABELS_APR_27_THRU_JUN_7, [13, 0, 0, 0, 3, 7]],

    // TAB_6_WEEK: Show aggreates multiple events in given day
    [TAB_6_WEEK, '2020-06-06', [
      {'@type': 'Run', 'date': '2020-06-05T09:00:00', run: {distance: 1}},
      {'@type': 'Run', 'date': '2020-06-05T09:00:00', run: {distance: 2}},
      {'@type': 'Run', 'date': '2020-06-05T09:00:00', run: {distance: 3}},
    ], LABELS_APR_27_THRU_JUN_7, [0, 0, 0, 0, 0, 6]],

    // TAB_7_DAY: Show summaries daily events correctly
    [TAB_7_DAY, '2020-06-06T12:00:00', [
      {'@type': 'Run', 'date': '2020-05-31T09:00:00', run: {distance: 7}},
      {'@type': 'Run', 'date': '2020-06-02T09:00:00', run: {distance: 3}},
      {'@type': 'Run', 'date': '2020-06-05T09:00:00', run: {distance: 5}},
      {'@type': 'Run', 'date': '2020-06-06T09:00:00', run: {distance: 2}},
    ], LABELS_SUN_THRU_SAT, [7, 0, 3, 0, 0, 5, 2]],

    // TAB_7_DAY: Show aggregates multiple events in given day
    [TAB_7_DAY, '2020-06-06T12:00:00', [
      {'@type': 'Run', 'date': '2020-06-06T09:00:00', run: {distance: 3}},
      {'@type': 'Run', 'date': '2020-06-06T09:00:00', run: {distance: 4}},
      {'@type': 'Run', 'date': '2020-06-06T09:00:00', run: {distance: 5}},
    ], LABELS_SUN_THRU_SAT, [0, 0, 0, 0, 0, 0, 12]],

  ]).it('aggregate run data correctly for tab "%s" on %s', (tab, date, events, expectedLabels, expectedSeries) => {
    const data = barChartData(tab, events, moment(date));
    expect(data.labels).toEqual(expectedLabels);
    expect(data.series[0]).toEqual(expectedSeries);
  });
});
