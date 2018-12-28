import React, {Component} from 'react';
import './NavBar.css';
import 'bootstrap/dist/css/bootstrap.min.css';


class NavBar extends Component {
    render() {
        return (
            <nav className={'navbar navbar-expand-lg navbar-dark bg-dark sticky-top'}>
                <a className={'navbar-brand'} href={'https://github.com/team-lum/News'}><strong>LUM </strong>
                    <img src={"http://icons.iconarchive.com/icons/iconsmind/outline/256/Newspaper-2-icon.png"}
                         className="App-logo" alt="logo" height={35} width={35}/>
                </a>

                <div className={'col text-right'}>
                    <ul className={'list'}>
                        <li className={'link'}>
                            <a className={'text-muted'} href={'https://newsapi.org/'}>All news provided by NewsAPI</a>
                        </li>
                        <li className={'link'}>
                            <span className={' text-muted'}>Version : {this.props.api_version}</span>
                        </li>
                    </ul>
                </div>
            </nav>
        );
    }
}

export default NavBar;
