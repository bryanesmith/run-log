/*eslint-disable no-unused-vars*/
import React from 'react';

import FeaturedRun from 'run-log/components/featuredRun/FeaturedRun';
import DashboardAveragePaceStats from './averagePaceStats/DashboardAveragePaceStats';
import DashboardBarChart from './barChart/DashboardBarChart';
import DashboardTabs from './DashboardTabs';
import DashboardPieChart from './pieChart/DashboardPieChart';
import DashboardShoesStats from './shoesStats/DashboardShoesStats';
import DashboardSpeedometer from './speedometer/DashboardSpeedometer';
import DashboardTopPaceStats from './topPaceStats/DashboardTopPaceStats';
import DashboardTotalDistanceStats from './totalDistanceStats/DashboardTotalDistanceStats';
/*eslint-enable no-unused-vars*/

import './dashboard.scss';

import moment, { Moment } from 'moment';
import { connect } from 'react-redux';
import { Action, Dispatch } from 'redux';
import { RootState } from 'run-log/scripts/reducers';
import { TAB_365_DAY, TAB_6_WEEK, TAB_7_DAY, TAB_ALL } from './actions';

interface IStateToProps {
  dashboard: State.Dashboard;
  events: State.Events;
}

class Dashboard extends React.Component<{} & IStateToProps, {}> {
  public render() {
    const tabData = this.tabData(this.props.events.data);
    const selectedEvents = this.eventsSince(tabData.startMoment);

    return (
      <div className="dashboard">
        <div className="row">
          <div className="col-xs-12">
            <FeaturedRun
              events={this.filterByTypes(this.props.events.data, [
                'Run',
                'Run+CrossTrain',
              ])}
            />
          </div>
        </div>{' '}
        {/* .row */}
        <div className="row">
          <div className="col-sm-12">
            <DashboardTabs selectedTab={this.props.dashboard.ui.selectedTab} />
          </div>
        </div>{' '}
        {/* .row */}
        <div className="row">
          <div className="col-md-6">
            <h2>Distance</h2>
            <div className="dashboard-bar-chart">
              <DashboardBarChart
                selectedTab={this.props.dashboard.ui.selectedTab}
                events={selectedEvents}
              />
            </div>
          </div>
          <div className="col-md-6">
            <div className="row">
              <h2>Speed</h2>
            </div>
            <div className="widget-stats row">
              <DashboardSpeedometer events={selectedEvents} />
              <DashboardAveragePaceStats events={selectedEvents} />
              <DashboardTopPaceStats events={selectedEvents} />
            </div>
          </div>
        </div>{' '}
        {/* .row */}
        <div className="row">
          <div className="col-md-6">
            <h2>Overall</h2>
            <div className="widget-stats">
              <DashboardTotalDistanceStats events={selectedEvents} />
              <div className="col-xs-8">
                <DashboardPieChart
                  totalDays={tabData.totalDays}
                  events={selectedEvents}
                />
              </div>
            </div>
          </div>
          <div className="col-md-6">
            <div className="row">
              <h2>Shoes</h2>
            </div>
            <div className="widget-stats row">
              <DashboardShoesStats events={this.props.events.data} />
            </div>
          </div>
        </div>{' '}
        {/* .row */}
      </div>
    );
  } // render

  private tabData(events: Events.Any[]) {
    let days;
    switch (this.props.dashboard.ui.selectedTab) {
      case TAB_7_DAY:
        days = 7;
        return {
          startMoment: moment().subtract({ days }),
          totalDays: days,
        };
      case TAB_6_WEEK:
        days = 70;
        return {
          startMoment: moment().subtract({ days }),
          totalDays: days,
        }
      case TAB_365_DAY:
        days = 365;
        return {
          startMoment: moment().subtract({ days }),
          totalDays: days,
        };
      case TAB_ALL:
        // Last seven years as well as any days in the current year
        const startYear = moment().startOf('year' as moment.unitOfTime.StartOf);
        days = 365 * 7 + moment().diff(startYear, 'days');
        return {
          startMoment: moment(0),
          totalDays: days,
        };
      default:
        throw new Error(
          `Unexpected value for selected tab: ${
            this.props.dashboard.ui.selectedTab
          }`
        );
    }
  }

  private filterByTypes(events: Events.Any[], types: EventTypes.Any[]) {
    return events.filter(e => types.includes(e['@type']));
  }

  private eventsSince(start: Moment) {
    return this.props.events.data.filter(e => moment(e.date).diff(start) >= 0);
  }
} // Dashboard

function mapStateToProps(state: RootState): IStateToProps {
  return {
    dashboard: state.dashboard,
    events: state.events,
  };
}

export default connect<IStateToProps, {}, {}>(mapStateToProps, {})(Dashboard);
