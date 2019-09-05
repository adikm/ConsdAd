import {Button, Card, Elevation} from '@blueprintjs/core';
import React from 'react';
import '@blueprintjs/core/lib/css/blueprint.css';
import '@blueprintjs/icons/lib/css/blueprint-icons.css';
import './App.css';
import {OfferTileList} from './components/OfferTileList';

const App: React.FC = () => {
  return (
    <OfferTileList/>
  );
};

export default App;
