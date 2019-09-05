import React, {Component} from 'react';
import {AdvertisementList} from '../models/AdvertisementList';
import {OfferTileComponent} from './OfferTileComponent';

const mockOffers: AdvertisementList = {
  advertisements: [{
    title: 'test',
    content: 'content testowy',
    user: {},
    id: 1,
    tags: ['ogloszenie']
  }]
};

export const OfferTileList: React.FC = () => {
  return (
    <>
      {mockOffers.advertisements.map((ad, index) => {
        <OfferTileComponent ad={ad} key={index}> </OfferTileComponent>
      })}
    </>
  )
};
