import {
  SEND_LOGIN,
  RECEIVE_LOGIN_SUCCESS,
  RECEIVE_LOGIN_FAIL,
  SEND_CHECK_SESSION,
  RECEIVE_CHECK_SESSION_SUCCESS,
  RECEIVE_CHECK_SESSION_FAIL,
  STORE_CREDENTIALS,
  VALIDATE_CREDENTIALS
} from './actions';

const INITIAL_STATE = {
  loading: false,
  authenticated: false,
  message: null,
};

/**
 * Constructs initiate state. message parameter optional, and used to display
 *   message on login screen.
 */
export function initialState(message) {
  return {
    ...INITIAL_STATE,
    message
  };
}

export default function(state = INITIAL_STATE, action) {
  switch (action.type) {
    case STORE_CREDENTIALS:
      return {
        ...state,
        loading: false,
        authenticated: true,
        credentials: action.credentials,
        message: null
      };
    case VALIDATE_CREDENTIALS:
      if (!!state.credentials) {
        return {
          ...state,
          loading: false,
          authenticated: true,
          message: null
        };
      } else {
        return {
          ...state,
          loading: false,
          authenticated: false,
          message: null
        };
      }
    case SEND_LOGIN:
      return {
        ...state,
        loading: true,
        authenticated: false,
        message: null,
      };
    case RECEIVE_LOGIN_SUCCESS:
      return {
        ...state,
        loading: false,
        authenticated: true,
        message: null,
      };
    case RECEIVE_LOGIN_FAIL:
      return {
        ...state,
        loading: false,
        authenticated: false,
        message: action.message,
      };
    case SEND_CHECK_SESSION:
      return {
        ...state,
        loading: true
      };
    case RECEIVE_CHECK_SESSION_SUCCESS:
      return {
        ...state,
        loading: false,
        authenticated: true,
      };
    case RECEIVE_CHECK_SESSION_FAIL:
      return {
        ...state,
        loading: false,
        authenticated: false,
      };
    default:
      return state;
  }
}
