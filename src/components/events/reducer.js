import { LOAD_EVENTS, RECEIVE_EVENTS, ADD_EVENT, REMOVE_EVENT } from './actions';

const INITIAL_STATE = {
  loaded: false,
  data: []
};

/**
 * Reducer function for books application.
 */
export default function(state = INITIAL_STATE, action) {
  switch (action.type) {
  case ADD_EVENT:
    return Object.assign({}, state, {
      data: [ action.event, ...state.data ]
    });
  case REMOVE_EVENT:
    return Object.assign({}, state, {
      data: state.data.filter(e => e['@id'] !== action.eventId)
    });
  case LOAD_EVENTS:
    return Object.assign({}, state, {
      loading: true
    });
  case RECEIVE_EVENTS:
    return Object.assign({}, state, {
      loading: false,
      data: action.payload.events
    });
  default:
    return state;
  }
}
