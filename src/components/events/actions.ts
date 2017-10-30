import { Action, Dispatch } from 'redux';

import SampleEvents from 'run-log/sample-events.json';
import { randomUuid } from 'run-log/scripts/utils/uuid';

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
  public type: 'SEND_EDIT_EVENT' | 'RECEIVE_EDIT_EVENT' | 'SEND_ADD_EVENT' | 'RECEIVE_ADD_EVENT';
}

class SendGetAction implements Action {
  public type: 'SEND_GET_EVENTS';
}

class ReceiveGetAction implements Action {
  public payload: any; // TODO: payload type
  public receivedAt: number;
  public type: 'RECEIVE_GET_EVENTS';
}

export type TEventAction = FavoriteAction | DeleteAction | CrudAction | SendGetAction | ReceiveGetAction;

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

  receiveEditEvent(event: Events.Any): CrudAction { // TODO: event type
    return {
      event,
      type: 'RECEIVE_EDIT_EVENT',
    };
  },

  requestAddEvent(event: any): CrudAction { // TODO: event type
    return {
      event,
      type: 'SEND_ADD_EVENT',
    };
  },

  receiveAddEvent(event: any): CrudAction { // TODO: event type
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

  receiveEvents(json: any): ReceiveGetAction { // TODO: json type
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
export function deleteEvent(eventId: any) { // TODO: event type
  return simulateAsyncRequest(Actions.requestDeleteEvent(eventId), Actions.receiveDeleteEvent(eventId));
}

/**
 * TODO: post to server, then fetch events
 */
export function editEvent(event: Events.Any) {
  return simulateAsyncRequest(Actions.requestEditEvent(event), Actions.receiveEditEvent(event));
}

/**
 * TODO: post to server, then fetch events
 */
export function addEvent(event: Events.Any) {
  event['@id'] = `urn:uuid:${randomUuid()}`; // TODO: server does this
  return simulateAsyncRequest(Actions.requestAddEvent(event), Actions.receiveAddEvent(event));
}

/**
 * TODO: get from server
 */
export function loadEvents() {
  return simulateAsyncRequest(Actions.requestEvents(), Actions.receiveEvents(SampleEvents));
}

// Helper for simulating HTTP requests
function simulateAsyncRequest(reqAction: TEventAction, resAction: TEventAction) {
  return (dispatch: Dispatch<Action>) => {
    dispatch(reqAction);
    return new Promise((resolve) => {
      setTimeout(() => resolve(dispatch(resAction)), MILLIS_WAIT); // Simulate xhr
    });
  };
}
