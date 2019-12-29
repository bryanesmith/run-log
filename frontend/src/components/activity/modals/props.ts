import { Action } from 'redux';

/**
 * Modal classes' props
 */
export interface IModalProps {
  eventType: EventTypes.Any;
  modalTitle: string;
  modalType: ModalTypes.Any;
}

/**
 * Modal classes' mapStateToProps
 */
export interface IModalS2P {
  authenticate: any; // TODO: define State.Authenticate
  events: State.Events;
  modals: State.Modals;
}

/**
 * Modal classes' mapDispatchToProps
 */
export interface IModalD2P {
  addEvent(e: Events.Any, t: string): Promise<any>;
  editEvent(e: Events.Any): Promise<any>;
  hideModal(): Action;
}
