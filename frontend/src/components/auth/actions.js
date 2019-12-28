// import config from 'run-log/config.json';

export const SEND_LOGIN = 'SEND_LOGIN',
  RECEIVE_LOGIN_SUCCESS = 'RECEIVE_LOGIN_SUCCESS',
  RECEIVE_LOGIN_FAIL = 'RECEIVE_LOGIN_FAIL',
  SEND_CHECK_SESSION = 'SEND_CHECK_SESSION',
  RECEIVE_CHECK_SESSION_SUCCESS = 'RECEIVE_CHECK_SESSION_SUCCESS',
  RECEIVE_CHECK_SESSION_FAIL = 'RECEIVE_CHECK_SESSION_FAIL',
  STORE_CREDENTIALS = 'STORE_CREDENTIALS',
  VALIDATE_CREDENTIALS = 'VALIDATE_CREDENTIALS';

//
// TODO: Temporarily disabling login, sessions XHRs. Application will instead
//       store token in state. This is not very secure; there's a note in the
//       README explaining this.
//

// function sendLoginAction(username, password) {
//   return {
//     type: SEND_LOGIN,
//     username,
//     password,
//   };
// }

// function receiveLoginAction({ ok, statusText }) {
//   return {
//     type: ok ? RECEIVE_LOGIN_SUCCESS : RECEIVE_LOGIN_FAIL,
//     message: statusText,
//   };
// }

// export function login(username, password) {
//   return dispatch => {
//     dispatch(sendLoginAction(username, password));
//     const url = `${
//       config.baseUrl
//     }/api/v1/login?user=${username}&password=${password}`;
//     fetch(url, {
//       credentials: 'include',
//     }).then(res => dispatch(receiveLoginAction(res)));
//   };
// }

function storeCredentialsAction(username, password) {
  const token = btoa(username + ':' + password);
  return {
    type: STORE_CREDENTIALS,
    credentials: token
  };
}

export function login(username, password) {
  return dispatch => dispatch(storeCredentialsAction(username, password));
}

// function sendCheckSessionAction() {
//   return {
//     type: SEND_CHECK_SESSION
//   };
// }

// function receiveCheckSessionAction(ok) {
//   return {
//     type: ok ? RECEIVE_CHECK_SESSION_SUCCESS : RECEIVE_CHECK_SESSION_FAIL
//   };
// }

// export function checkSession() {
//   return dispatch => {
//     dispatch(sendCheckSessionAction());
//     const url = `${config.baseUrl}/api/v1/session`;
//     return fetch(url, {
//       credentials: 'include',
//     }).then(res => dispatch(receiveCheckSessionAction(res.ok)))
//       .catch(() => dispatch(receiveCheckSessionAction(false)));
//   };
// }

// Simulates 350ms request followed by authentication found
// export function checkSession() {
//   return simulateAsyncRequest(
//     sendCheckSessionAction(), receiveCheckSessionAction(true)
//   );
// }

function validateCredentialsAction() {
  return {
    type: VALIDATE_CREDENTIALS
  };
}

export function checkSession() {
  return dispatch => dispatch(validateCredentialsAction());
}

// function simulateAsyncRequest(reqAction, resAction) {
//   return dispatch => {
//     dispatch(reqAction);
//     return new Promise(resolve => {
//       setTimeout(() => resolve(dispatch(resAction)), 350); // Simulate xhr
//     });
//   };
// }
