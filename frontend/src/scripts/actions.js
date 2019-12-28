export const CLEAR_STATE = 'CLEAR_STATE';

export function clearState(message) {
  return {
    type: CLEAR_STATE,
    message
  };
}
