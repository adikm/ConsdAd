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
  },
    {
      title: 'test2',
      content: 'content testowy2',
      user: {},
      id: 1,
      tags: ['ogloszenie']
    },
    {
      title: 'test3',
      content: 'content testowy3',
      user: {},
      id: 1,
      tags: ['ogloszenie']
    },
    {
      title: 'test3',
      content: 'content testowy3',
      user: {},
      id: 1,
      tags: ['ogloszenie']
    }]
};

export const OfferTileList: React.FC = () => {
  return (
    <div className='offer-list'>
      {mockOffers.advertisements.map((ad, index) => {
        return (<OfferTileComponent {...ad} key={index}> </OfferTileComponent>)
      })}
    </div>
  )
};
