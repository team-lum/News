import React, {Component} from 'react';
import './NavBar.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import logo from "../../logo.svg";

class NavBar extends Component {
    render() {
        return (
            <nav className={'navbar navbar-expand-lg navbar-light bg-light'}>
                <a className={'navbar-brand'} href="#">News</a>

                {/*<div className="App">*/}
                    {/*<header className="App-header">*/}
                        {/*<img src={logo} className="App-logo" alt="logo"/>*/}
                    {/*</header>*/}
                {/*</div>*/}

                <div className={'collapse navbar-collapse'} id="navbarSupportedContent">
                    <ul className={'navbar-nav mr-auto'}>
                        <li className={'nav-item active'}>
                        </li>
                    </ul>
                    <form className={'form-inline my-2 my-lg-0'}>
                        <input className={'form-control mr-sm-2'} type="search" placeholder="Search" aria-label="Search"/>
                            <button className={'btn btn-outline-success my-2 my-sm-0'}>Search</button>
                    </form>
                </div>
            </nav>
        );
    }
}

export default NavBar;
