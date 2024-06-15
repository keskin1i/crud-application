// src/App.js
import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import personList from './components/personList';
import personForm from './components/personForm';
import personDetail from './components/personDetail';

function App() {
    return (
        <Router>
            <div>
                <h1>Contact Management System</h1>
                <Switch>
                    <Route exact path="/" component={personList} />
                    <Route path="/add" component={personForm} />
                    <Route path="/edit/:id" component={personForm} />
                    <Route path="/details/:id" component={personDetail} />
                </Switch>
            </div>
        </Router>
    );
}

export default App;
