import React, {Component} from 'react';
import './NavBar.css';
import 'bootstrap/dist/css/bootstrap.min.css';



class NavBar extends Component {
    render() {
        return (
            <nav className={'navbar navbar-expand-lg navbar-light bg-dark'}>
                <a className={'brand navbar-brand'} href="#"><strong>NEWS</strong></a>

                {/*<div className="App">*/}
                    {/*<header className="App-header">*/}
                        {/*<img url={'src/logo.png'} className="App-logo" alt="logo"/>*/}
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
