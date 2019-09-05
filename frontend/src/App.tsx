import {Button, Card, Elevation} from '@blueprintjs/core';
import React from 'react';
import '@blueprintjs/core/lib/css/blueprint.css';
import '@blueprintjs/icons/lib/css/blueprint-icons.css';
import './App.css';

const App: React.FC = () => {
  return (
    <Card interactive={true} elevation={Elevation.TWO}>
      <h5><a href="#">Card heading</a></h5>
      <p>Card content</p>
      <Button>Submit</Button>
    </Card>
  );
};

export default App;
