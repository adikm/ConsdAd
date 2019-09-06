import {Card, Elevation} from '@blueprintjs/core';
import React from 'react';

export class OfferTileComponent extends React.Component {
  render() {
    return (
      <Card interactive={true} elevation={Elevation.TWO} className='offer-tile'>
        <div>
          <h5>{this.props.title}</h5>
          <hr/>
          <p>{this.trimContentToMaxLength()}</p>
        </div>
        <a>Pokaż więcej</a>
      </Card>
    );
  }

  trimContentToMaxLength() {
    if (this.props.content.length >= 200) {
      return this.props.content.slice(0, 196) + '...';
    } else {
      return this.props.content;
    }
  }
}
