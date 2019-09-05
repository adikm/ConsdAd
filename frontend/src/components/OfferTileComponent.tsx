import {Button, Card, Elevation} from '@blueprintjs/core';
import React, {ReactNode} from 'react';
import {AdvertisementModel} from '../models/AdvertisementModel';

export class OfferTileComponent extends React.Component<AdvertisementModel> {
  public render(): ReactNode {
    return (
      <Card interactive={true} elevation={Elevation.TWO}>
        <h5>{this.props.title}</h5>
        <p>{this.props.content}</p>
        <Button>Pokaż</Button>
      </Card>
    );
  }
}
