import { averageMPH, averagePace, distance, filterEventsByEndDate, nextId, pace, seconds, totalDistance } from './events';
import moment from 'moment';

const nonRun = {};
const steadyRun = {run: {distance: 6, duration: "PT1H"}};
const intervals = {run: {count: 6, intervalDuration: "PT1M", intervalSpeed: 10.0}};

test('distance for non-running event', () => {
  expect(distance(nonRun)).toBe(0);
});

test('distance for steady-state run', () => {
  expect(distance(steadyRun)).toBe(6);
});

test('distance for intervals', () => {
  expect(distance(intervals)).toBe(1);
});

test('totalDistance for 0 events', () => {
  expect(totalDistance([])).toBe(0);
});

test('totalDistance for several types of events', () => {
  const events = [
    nonRun,
    steadyRun,
    intervals
  ];
  expect(totalDistance(events)).toBe(7);
});

test('pace for non-running event', () => {
  expect(pace(nonRun)).toBe(0);
});

test('pace for steady-state run', () => {
  expect(pace(steadyRun)).toBe(600);
});

test('pace for intervals', () => {
  expect(pace(intervals)).toBe(360);
});

test('seconds for non-running event', () => {
  expect(seconds(nonRun)).toBe(0);
});

test('seconds for steady-state run', () => {
  expect(seconds(steadyRun)).toBe(3600);
});

test('seconds for intervals', () => {
  expect(seconds(intervals)).toBe(360);
});

test('averageMPH for no events', () => {
  expect(averageMPH([])).toBeUndefined();
});

test('averageMPH for non-run event', () => {
  expect(averageMPH([nonRun])).toBeUndefined();
});

test('averageMPH for steady run event', () => {
  expect(averageMPH([steadyRun])).toBe(6.0);
});

test('averageMPH for interval run event', () => {
  expect(averageMPH([intervals])).toBe(10.0);
});

function undefToZero(someVal: number | undefined) {
  return typeof someVal !== 'undefined' ? someVal : 0;
}

test('averageMPH for heterogeneous events', () => {
  const events = [
    nonRun,
    steadyRun,
    intervals
  ];
  const avg = averageMPH(events);
  expect(undefToZero(averageMPH(events)).toFixed(2)).toBe("6.36");
});

test('averagePace for no events', () => {
  expect(averagePace([])).toBeUndefined();
});

test('averagePace for several types of events', () => {
  const events = [
    nonRun,
    steadyRun,
    intervals
  ];
  expect(undefToZero(averagePace(events)).toFixed(2)).toBe("565.71");
});

test('averagePace for single steady runs with duration', () => {
  const events = [
    {run: {distance: 6, duration: "PT1H"}}
  ];
  expect(averagePace(events)).toBe(600); // 10 min
});

test('averagePace for single steady runs without duration', () => {
  const events = [
    {run: {distance: 6, duration: null}}
  ];
  expect(averagePace(events)).toBeUndefined();
});

test('averagePace for steady runs with and without duration', () => {
  const events = [
    {run: {distance: 6, duration: "PT1H"}},
    {run: {distance: 6, duration: null}},
    {run: {distance: 6, duration: "PT1H"}},
    {run: {distance: 6, duration: null}},
  ];
  expect(averagePace(events)).toBe(600); // 10 min
});

test('filterEventsByEndDate for no events', () => {
  const found = filterEventsByEndDate([], moment('2019-04-03'), 'Day', 1);
  expect(found).toEqual([]);
});

test('filterEventsByEndDate for just one event, doesn\'t match', () => {
  const events = [
    { date: "2019-04-01T09:00:00" }
  ];
  const found = filterEventsByEndDate(events, moment('2019-04-03'), 'Day', 1);
  expect(found).toEqual([]);
});

test('filterEventsByEndDate for just one event, matches', () => {
  const events = [
    { date: "2019-04-02T09:00:00" }
  ];
  const found = filterEventsByEndDate(events, moment('2019-04-03'), 'Day', 1);
  expect(found).toEqual(events);
});

test('filterEventsByEndDate for multiple events, no matches', () => {
  const events = [
    { date: "2019-03-21T09:00:00" },
    { date: "2019-03-30T09:00:00" },
    { date: "2019-04-01T09:00:00" }
  ];
  const found = filterEventsByEndDate(events, moment('2019-04-03'), 'Day', 1);
  expect(found).toEqual([]);
});

test('filterEventsByEndDate for multiple events, some matches', () => {
  const expected = [
    { date: "2019-03-31T09:00:00" },
    { date: "2019-04-02T09:00:00" }
  ];
  const events = [
    { date: "2019-03-21T09:00:00" },
    ...expected
  ];
  const found = filterEventsByEndDate(events, moment('2019-04-03'), 'Day', 3);
  expect(found).toEqual(expected);
});

test('filterEventsByEndDate for multiple events, all matches', () => {
  const events = [
    { date: "2019-03-31T09:00:00" },
    { date: "2019-04-01T09:00:00" },
    { date: "2019-04-02T09:00:00" }
  ];
  const found = filterEventsByEndDate(events, moment('2019-04-03'), 'Day', 3);
  expect(found).toEqual(events);
});

test('nextId when no events', () => {
  const found = nextId([]);
  expect(found).toEqual('_:n1');
});

test('nextId when one expected event value', () => {
  const events = [
    { '@id': '_:n1' }
  ];
  const found = nextId(events);
  expect(found).toEqual('_:n2');
});

test('nextId when one unexpected event value', () => {
  const events = [
    { '@id': '_:n17' }
  ];
  const found = nextId(events);
  expect(found).toEqual('_:n18');
});

test('nextId when one unexpected event value with padding', () => {
  const events = [
    { '@id': '_:n0023' }
  ];
  const found = nextId(events);
  expect(found).toEqual('_:n24');
});

test('nextId when multiple sequential event values', () => {
  const events = [
    { '@id': '_:n1' },
    { '@id': '_:n2' },
    { '@id': '_:n3' },
  ];
  const found = nextId(events);
  expect(found).toEqual('_:n4');
});

test('nextId when multiple unordered sequential event values', () => {
  const events = [
    { '@id': '_:n2' },
    { '@id': '_:n3' },
    { '@id': '_:n1' },
  ];
  const found = nextId(events);
  expect(found).toEqual('_:n4');
});

test('nextId when multiple non-sequential event values', () => {
  const events = [
    { '@id': '_:n1' },
    { '@id': '_:n101' },
    { '@id': '_:n200' },
    { '@id': '_:n202' },
    { '@id': '_:n3' },
  ];
  const found = nextId(events);
  expect(found).toEqual('_:n203');
});
