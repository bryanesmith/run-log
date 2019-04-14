import { durationToSeconds, subtractMoment } from './dates';
import { add } from './math';
import moment from 'moment';

/**
 * Returns distance for event, defaulting to zero if none specified.
 */
export function distance(event) {
  if (event.run && event.run.distance) {
    return event.run.distance;
  } else if (
    event.run && event.run.count && event.run.intervalDuration && event.run.intervalSpeed
  ) {
    const secs = durationToSeconds(event.run.intervalDuration);
    return event.run.count * secs * event.run.intervalSpeed / 3600;
  } else {
    return 0;
  }
}

/**
 * Returns the seconds for an event.
 */
export function seconds(event) {
  if (event.run && event.run.duration) {
    return durationToSeconds(event.run.duration);
  } else if (event.run && event.run.count && event.run.intervalDuration) {
    const secs = durationToSeconds(event.run.intervalDuration);
    return event.run.count * secs;
  } else {
    return 0;
  }
}

/**
 * Returns the pace for event in seconds per mile. If pace not available, returns 0.
 */
export function pace(event) {
  if (event.run && event.run.distance && event.run.duration) {
    return durationToSeconds(event.run.duration) / event.run.distance;
  } else if (event.run && event.run.intervalSpeed) {
    return 3600 / event.run.intervalSpeed;
  } else {
    return 0;
  }
}


/**
 * Returns combined distance for events, defaulting to zero for events without
 *   distances specified.
 */
export function totalDistance(events) {
  return events.map(distance).reduce(add, 0);
}

/**
 * Returns the average pace for a bunch of events. (seconds per mile)
 */
export function averagePace(events) {
  var filtered = events.filter(e => pace(e) > 0);
  if (filtered.length > 0) {
    return filtered.map(seconds).reduce(add, 0) / totalDistance(filtered);
  } else {
    return undefined;
  }
}

/**
 * Returns average mph.
 */
export function averageMPH(events) {
  const avgPace = averagePace(events);
  return (typeof avgPace  !== 'undefined') ? (3600 / avgPace) : undefined;
}

/**
 * Given some events, filters by types as well as within specified time from end date.
 *    Units can be "Day", "Month", "Year".
 */
export function filterEventsByEndDate(events, endDate, units, length) {
  const startDate = subtractMoment(endDate, units, length);
  return events
    .filter(e => moment(e.date).isBetween(startDate, endDate));
}
