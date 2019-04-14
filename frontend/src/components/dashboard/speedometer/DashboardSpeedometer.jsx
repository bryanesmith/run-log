/*eslint-disable no-unused-vars*/
import React from 'react';
import ChartistGraph from 'react-chartist';
/*eslint-enable no-unused-vars*/

import { averageMPH } from 'run-log/scripts/utils/events';
import { min } from 'run-log/scripts/utils/math';

function options() {
  return {
    donut: true,
    donutWidth: 40,
    donutSolid: true,
    startAngle: 270,
    total: 200,
    showLabel: false,
  };
}

const GoalMPH = 10.0;

function data(mph) {
  const cappedMph = min(mph, GoalMPH);
  const percentage = 100 * cappedMph / GoalMPH;
  return {
    series: [percentage, 100.0 - percentage],
  };
}

export default props => {
  const mphUndef = averageMPH(props.events);
  const mph = mphUndef !== 'undefined' ? mphUndef : 0;
  return (
    <div className="dashboard-speedometer widget-stat-imposter col-xs-4">
      <div className="speed-achieved">{mph.toFixed(2)} mph</div>
      <div className="speed-goal">out of {GoalMPH.toFixed(2)} mph</div>
      <div className="svg-shrinkwrap">
        <ChartistGraph data={data(mph)} options={options()} type={'Pie'} />
      </div>
    </div>
  );
};
