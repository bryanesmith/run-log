/*eslint-disable no-unused-vars*/
import React from 'react';
/*eslint-enable no-unused-vars*/

import { MODAL_RUN } from '../modals/runModal/actions';
import { MODAL_CROSS_TRAIN } from '../modals/crossTrainModal/actions';
import { MODAL_RUN_CROSS_TRAIN } from '../modals/runCrossTrainModal/actions';
import { MODAL_SHOES } from '../modals/shoesModal/actions';
import { deleteEvent } from '../../events/actions';
import { showModal } from '../modals/actions';

import { connect } from 'react-redux';

class EventRow extends React.Component {

  constructor(props) {
    super(props);
  }

  handleDelete() {
    this.props.deleteEvent(this.props.event['@id']);
  }

  handleEdit() {
    const type = this.props.event['@type'];
    if ('Run' === type) {
      this.props.showModal(MODAL_RUN, this.props.event);
    } else if ('CrossTrain' === type) {
      this.props.showModal(MODAL_CROSS_TRAIN, this.props.event);
    } else if ('Run+CrossTrain' === type) {
      this.props.showModal(MODAL_RUN_CROSS_TRAIN, this.props.event);
    } else if ('Shoes' === type) {
      this.props.showModal(MODAL_SHOES, this.props.event);
    } else {
      console.error(`Unrecognized event type: ${type}`);
    }
  }

  render() {
    return this.props.children({
      handleDelete: this.handleDelete.bind(this),
      handleEdit: this.handleEdit.bind(this)
    });
  }

}

export default connect(null, {deleteEvent, showModal})(EventRow);
