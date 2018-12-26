import React from 'react';
import ReactDOM from 'react-dom';
import Article from "./Article";

it('renders without crashing', () => {
  const div = document.createElement('div');
  const article = {};
  ReactDOM.render(<Article news={article}/>, div);
  ReactDOM.unmountComponentAtNode(div);
});
