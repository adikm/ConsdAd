import {Button, Card, Elevation} from '@blueprintjs/core';
import React from 'react';
import {AdvertisementModel} from '../models/AdvertisementModel';

export const OfferTileComponent: React.FC = (ad: AdvertisementModel) => {
  return (
    <Card interactive={true} elevation={Elevation.TWO}>
      <h5>{ad.title}</h5>
      <p>{ad.content}</p>
      <Button>Show more</Button>
    </Card>
  )
};
