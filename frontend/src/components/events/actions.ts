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
  public type: 'SEND_DELETE_EVENT';
}

class CrudAction implements Action {
  public event: Events.Any;
  public type:
    | 'SEND_EDIT_EVENT'
    | 'RECEIVE_EDIT_EVENT'
    | 'SEND_SAVE_EVENT';
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

  requestSaveEvent(event: Events.Any): CrudAction {
    return {
      event,
      type: 'SEND_SAVE_EVENT',
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

const Urls = {
  events: `${config.baseUrl}/api/v1/events`,
}; // Urls

function commonHeaders(credentials: string): any {
  return {
    'Authorization': 'Basic ' + credentials,
    'Content-Type': 'application/json'
  };
}

/**
 * TODO: delete from server, then fetch events
 */
export function deleteEvent(eventId: string, credentials: string) {
  return (dispatch: Dispatch<Action>) => {
    dispatch(Actions.requestDeleteEvent(eventId));
    return handleCredentialsFailure(
      dispatch,
      fetch(Urls.events, {
        body: JSON.stringify({
          events: [{ '@id': eventId }]
        }),
        headers: commonHeaders(credentials),
        method: 'DELETE',
      }).then((response: any) => {
        // Delegate to loadEvent to refetch data
        loadEvents(credentials)(dispatch);
      })
    );
  };
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
    dispatch(Actions.requestSaveEvent(event));
    return handleCredentialsFailure(
      dispatch,
      fetch(Urls.events, {
        body: JSON.stringify({
          events: [event]
        }),
        headers: commonHeaders(credentials),
        method: 'PUT',
      }).then((response: any) => {
        // Delegate to loadEvent to refetch data
        loadEvents(credentials)(dispatch);
      })
    );
  };
}

export function loadEvents(credentials: string) { // TODO: yuck
  return (dispatch: Dispatch<Action>) => {
    dispatch(Actions.requestEvents());
    return handleCredentialsFailure(
      dispatch,
      fetch(Urls.events, {
        headers: commonHeaders(credentials),
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
