import React, {Component} from 'react';
import './NavBar.css';
import 'bootstrap/dist/css/bootstrap.min.css';


class NavBar extends Component {
    render() {
        return (
            <nav className={'navbar navbar-expand-lg navbar-dark bg-dark sticky-top'}>
                <a className={'navbar-brand'} href="#"><strong>LUM </strong>
                    <img src={"http://icons.iconarchive.com/icons/iconsmind/outline/256/Newspaper-2-icon.png"}
                         className="App-logo" alt="logo" height={35} width={35}/>
                </a>

                <button className={"navbar-toggler"} type={"button"} data-toggler={"collapse"}
                        data-target={"#navbarSupportedContent"} aria-controls={"navbarSupportedContent"}
                        aria-expanded={"false"} aria-label={"Toggle navigation"}>
                    <span className={"navbar-toggler-icon"}/>
                </button>

                <div className={'collapse navbar-collapse'} id={'navbarSupportedContent'}>
                    <ul className={'navbar-nav mr-auto'}>
                        <li className={'nav-item active'}>
                        </li>
                    </ul>
                    <form className={'form-inline my-2 my-lg-0'}>
                        <input className={'form-control mr-sm-2'} type="search" placeholder="Search"
                               aria-label="Search"/>
                    </form>
                    <button className={'btn btn-outline-success my-2 my-sm-0'} onClick={this.props.changeSearcheType}>Search</button>
                </div>
            </nav>
        );
    }
}

export default NavBar;
