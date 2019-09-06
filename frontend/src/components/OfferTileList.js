import React, {Component} from 'react';
import {OfferTileComponent} from './OfferTileComponent';
import {get, post} from '../utils/httpRequests'

const mockOffers = {
  advertisements: [{
    title: 'test',
    content: 'content testowy',
    user: {},
    id: 1,
    tags: ['ogloszenie']
  },
    {
      title: 'test2',
      content: '',
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
    },
    {
      title: 'test4',
      content: 'content testowy4',
      user: {},
      id: 1,
      tags: ['ogloszenie']
    }]
};

export default class OfferTileList extends Component {
  constructor(props) {
    super(props);
    this.offers = [];
    this.state = {
      popupOpened: false,
      filterText: '',
      offers: []
    };
  }

  componentDidMount() {
    console.log("co");
    this.getOffers();
  }

  render() {
    return (
      <div className='offer-list'>
        {this.state.offers.map((ad, index) => {
          return (<OfferTileComponent {...ad} key={index}> </OfferTileComponent>)
        })}
      </div>
    )
  }

  getOffers() {
    get('http://localhost:8888/advertisements', {})
      .then(res => res.json())
      .then(res => {
        this.setState({offers: res});
      });
  }

  addOffer() {
    post('http://localhost:8888/advertisements', {
      method: 'POST',
    })
  }
}
