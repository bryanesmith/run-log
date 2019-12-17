import moment from 'moment';

export function formatDate(date: Date) {
  return moment(date, 'YYYYMMDD').calendar(undefined, {
    lastDay: '[Yesterday]',
    lastWeek: 'dddd',
    nextDay: '[Tomorrow]',
    nextWeek: 'dddd',
    sameDay: '[Today]',
    sameElse: 'L',
  });
}

/**
 * E.g., "PT2M35S" -> "2m 35s"
 */
export function formatDuration(duration: string) {
  // return moment.duration(duration).format('h[h] m[m] s[s]');
  return moment.utc(moment.duration(duration).as('milliseconds')).format('HH:mm:ss')
}

/**
 * "PT2M35S" -> {
 *   'hours': 0,
 *   'minutes': 2,
 *   'seconds': 35
 * }
 */
export function durationToComponents(duration: string) {
  const dur = moment.duration(duration);
  return {
    hours: dur.hours(),
    minutes: dur.minutes(),
    seconds: dur.seconds(),
  };
}

/**
 * Create ISO-8601 duration string.
 */
export function toDuration(hours?: number, minutes?: number, seconds?: number) {
  if (hours || minutes || seconds) {
    return `PT${hours ? hours : '0'}H${minutes ? minutes : '0'}M${
      seconds ? seconds : '0'
    }S`;
  } else {
    return undefined;
  }
}

/**
 * E.g., "PT2M35S" -> 155
 */
export function durationToSeconds(duration: string) {
  return moment.duration(duration).asSeconds();
}

/**
 * E.g, 155 -> "2:35"
 */
export function secondsToMinuteMiles(secs: number) {
  // return moment.duration(secs, 'seconds').format);
  return moment.utc(moment.duration(secs, 'seconds').as('milliseconds')).format('m[m] s[s]')
}

/**
 * Helper method for adding and subtracting moments.
 */
function momentMathArgs(units: string, duration: number) {
  const args: any = {};
  args[units] = duration;
  return args;
}

/*
 * Given moment, subtracts time.
 *
 * E.g., fromMoment = moment("2017-01-21"), units = 'Week', duration = 2,
 *   returns moment("2017-01-07").
 */
export function subtractMoment(fromMoment: any, units: string, duration: number) {
  const args = momentMathArgs(units, duration);
  return fromMoment.clone().subtract(args);
}

/*
 * Given moment, adds time.
 *
 * E.g., fromMoment = moment("2017-01-07"), units = 'Week', duration = 2,
 *   returns moment("2017-01-21").
 */
export function addMoment(fromMoment: any, units: string, duration: number) {
  const args = momentMathArgs(units, duration);
  return fromMoment.clone().add(args);
}

/*
 * Returns a series of moments ending in now with specified
 *   length and durations.
 *
 * E.g., length = 5, units = 'Day', duration = 2,
 *   returns [8, 6, 4, 2, 0].map(d => moment().subtract({days: d}))
 */
export function generateMomentsUntil(length: number, units: string, duration: number, endDate: any) {
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
