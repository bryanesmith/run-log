/*eslint-disable no-unused-vars*/
import React from 'react';

import ChartistGraph from 'react-chartist';
/*eslint-enable no-unused-vars*/

const hasType = type => event => event['@type'] === type;

function calculateCounts(events, totalDays) {
  const running = events.filter(e => hasType('Run')(e) || hasType('Run+CrossTrain')(e));
  const crossTraining = events.filter(hasType('CrossTrain'));
  return [
    {
      value: totalDays - events.length,
      className: 'slice-none',
    },
    {
      value: crossTraining.length,
      className: 'slice-x-train',
    },
    {
      value: running.filter(e => e.run && e.run.category === 'casual').length,
      className: 'slice-casual',
    },
    {
      value: running.filter(e => e.run && e.run.category === 'distance').length,
      className: 'slice-distance',
    },
    {
      value: running.filter(e => e.run && e.run.category === 'speed').length,
      className: 'slice-speed',
    },
    {
      value: running.filter(e => e.run && e.run['@type'] === 'Intervals').length,
      className: 'slice-intervals',
    },
  ];
}

function data(events, totalDays) {
  const counts = calculateCounts(events, totalDays).filter(p => p.value > 0);
  return {
    series: counts,
  };
}

function options() {
  return { showLabel: false };
}

export default ({ events, totalDays }) => {
  return (
    <div className="row">
      <div className="col-xs-6 pie-chart">
        <ChartistGraph
          data={data(events, totalDays)}
          options={options()}
          type={'Pie'}
        />
      </div>
      <div className="col-xs-6 pie-chart-legend">
        <table>
          <tbody>
            <tr>
              <td className="color slice-none" />
              <td className="description">No activity</td>
            </tr>
            <tr>
              <td className="color slice-x-train" />
              <td className="description">Cross-train</td>
            </tr>
            <tr>
              <td className="color slice-intervals" />
              <td className="description">Intervals</td>
            </tr>
            <tr>
              <td className="color slice-casual" />
              <td className="description">Casual</td>
            </tr>
            <tr>
              <td className="color slice-distance" />
              <td className="description">Distance</td>
            </tr>
            <tr>
              <td className="color slice-speed" />
              <td className="description">Speed</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  );
};
