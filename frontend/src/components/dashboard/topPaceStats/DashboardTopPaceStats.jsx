/*eslint-disable no-unused-vars*/
import React from 'react';
import DashboardStats from 'run-log/components/dashboard/stats/DashboardStats';
/*eslint-enable no-unused-vars*/

import { Option } from 'run-log/components/option/option';
import { secondsToMinuteMiles } from 'run-log/scripts/utils/dates';
import { pace } from 'run-log/scripts/utils/events';
import { min } from 'run-log/scripts/utils/math';

function calcFastestPace(events) {
  const durations = events.map(pace).filter(p => !!p);
  return durations.length ? durations.reduce(min) : 0;
}

export default props => {
  const stats = {
    name: 'Top Pace',
    value: Option(calcFastestPace(props.events))
      .map(p => secondsToMinuteMiles(p) + ' mi')
      .orElse('-'),
  };
  return <DashboardStats stats={stats} />;
};
