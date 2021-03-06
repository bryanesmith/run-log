/*eslint-disable no-unused-vars*/
import React from 'react';
import { Switch, Route } from 'react-router-dom';
import LoadEvents from 'run-log/components/events/LoadEvents';
import Dashboard from 'run-log/components/dashboard/Dashboard';
import Activity from 'run-log/components/activity/Activity';
/*eslint-enable no-unused-vars*/

export default () => (
  <LoadEvents>
    <div className="container">
      <Switch>
        <Route exact path="/" component={Dashboard} />
        <Route exact path="/activity" component={Activity} />
      </Switch>
    </div>
  </LoadEvents>
);
