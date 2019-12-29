import q from 'es6-promise';
q.polyfill();
import fetch from 'isomorphic-fetch';

import config from 'run-log/config.json';
import { clearState } from 'run-log/scripts/actions';

import { Action, Dispatch } from 'redux';

const MILLIS_WAIT = 350;

class FavoriteAction implements Action {
  public eventId: string;
  public favorite: boolean;
  public type: 'SET_FAVORITE';
}

class DeleteAction implements Action {
  public eventId: string;
  public type: 'SEND_DELETE_EVENT' | 'RECEIVE_DELETE_EVENT';
}

class CrudAction implements Action {
  public event: Events.Any;
  public type:
    | 'SEND_EDIT_EVENT'
    | 'RECEIVE_EDIT_EVENT'
    | 'SEND_ADD_EVENT'
    | 'RECEIVE_ADD_EVENT';
}

class SendGetAction implements Action {
  public type: 'SEND_GET_EVENTS';
}

class ReceiveGetAction implements Action {
  public payload: any; // TODO: payload type
  public receivedAt: number;
  public type: 'RECEIVE_GET_EVENTS';
}

export type EventsAction =
  | FavoriteAction
  | DeleteAction
  | CrudAction
  | SendGetAction
  | ReceiveGetAction;

const Actions = {
  setFavorite(eventId: string, favorite: boolean): FavoriteAction {
    return {
      eventId,
      favorite,
      type: 'SET_FAVORITE',
    };
  },

  requestDeleteEvent(eventId: string): DeleteAction {
    return {
      eventId,
      type: 'SEND_DELETE_EVENT',
    };
  },

  receiveDeleteEvent(eventId: string): DeleteAction {
    return {
      eventId,
      type: 'RECEIVE_DELETE_EVENT',
    };
  },

  requestEditEvent(event: Events.Any): CrudAction {
    return {
      event,
      type: 'SEND_EDIT_EVENT',
    };
  },

  receiveEditEvent(event: Events.Any): CrudAction {
    return {
      event,
      type: 'RECEIVE_EDIT_EVENT',
    };
  },

  requestAddEvent(event: any): CrudAction {
    return {
      event,
      type: 'SEND_ADD_EVENT',
    };
  },

  receiveAddEvent(event: any): CrudAction {
    return {
      event,
      type: 'RECEIVE_ADD_EVENT',
    };
  },

  requestEvents(): SendGetAction {
    return {
      type: 'SEND_GET_EVENTS',
    };
  },

  receiveEvents(json: any): ReceiveGetAction {
    return {
      payload: json,
      receivedAt: Date.now(),
      type: 'RECEIVE_GET_EVENTS',
    };
  },
}; // Actions

export const setFavorite = Actions.setFavorite;

/**
 * TODO: delete from server, then fetch events
 */
export function deleteEvent(eventId: string) {
  return simulateAsyncRequest(
    Actions.requestDeleteEvent(eventId),
    Actions.receiveDeleteEvent(eventId)
  );
}

/**
 * TODO: post to server, then fetch events
 */
export function editEvent(event: Events.Any) {
  return simulateAsyncRequest(
    Actions.requestEditEvent(event),
    Actions.receiveEditEvent(event)
  );
}

export function addEvent(event: Events.Any, credentials: string) {
  return (dispatch: Dispatch<Action>) => {
    dispatch(Actions.requestAddEvent(event));
    const url = `${config.baseUrl}/api/v1/events`;
    return handleCredentialsFailure(
      dispatch,
      // TODO: server should return events, and reload from there
      fetch(url, {
        body: JSON.stringify({
          events: [event]
        }),
        headers: {
          'Authorization': 'Basic ' + credentials,
          'Content-Type': 'application/json'
        },
        method: 'POST',
      }).then((response: any) => dispatch(Actions.receiveAddEvent(event)))
    );
  };
}

export function loadEvents(credentials: string) { // TODO: yuck
  return (dispatch: Dispatch<Action>) => {
    dispatch(Actions.requestEvents());
    const url = `${config.baseUrl}/api/v1/events`;
    return handleCredentialsFailure(
      dispatch,
      fetch(url, {
        headers: {
          'Authorization': 'Basic ' + credentials
        },
      }).then((response: any) => response.json())
        .then((events: any) => dispatch(Actions.receiveEvents(events)))
    );
  };
}

function handleCredentialsFailure(dispatch: Dispatch<Action>, req: Promise<any>): Promise<any> {
  return req.catch((error: any) => {
    dispatch(clearState('Please check your credentials.'));
  });
}

// Helper for simulating HTTP requests
function simulateAsyncRequest(
  reqAction: EventsAction,
  resAction: EventsAction
) {
  return (dispatch: Dispatch<Action>) => {
    dispatch(reqAction);
    return new Promise(resolve => {
      setTimeout(() => resolve(dispatch(resAction)), MILLIS_WAIT); // Simulate xhr
    });
  };
}
