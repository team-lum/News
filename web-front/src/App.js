import React, {Component} from 'react';
import NavBar from './components/navbar/NavBar.js'
import Footer from "./components/footer/Footer";
import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import VersionService from "./service/VersionService";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {};
        VersionService.getVersion(json => {
            this.setState({
                api_version: json.value
            });
        });
    }

    render() {
        return (
            <React.Fragment>
                <NavBar/>
                <div className="App">
                    <header className="App-header">
                        <img src={logo} className="App-logo" alt="logo"/>
                    </header>
                </div>
                <Footer api_version={this.state.api_version}/>
            </React.Fragment>
        );
    }
}

export default App;
