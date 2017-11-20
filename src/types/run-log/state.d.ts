/**
 * All type information for application state.
 */
declare namespace State {

  export interface Events {
    public data: Events.Any[];
    public loading?: boolean;
  }

  export interface Modals {
    public editEvent?: Events.Any;
    public ui: { showModal?: ModalTypes.Any };
  }
}
