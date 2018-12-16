import React, {Component} from 'react';
import './Footer.css';
import 'bootstrap/dist/css/bootstrap.min.css';

class Footer extends Component {
    render() {
        return (
            <footer className={'footer bg-light'}>
                <div className={'container-fluid'}>
                    <div className={'row'}>
                        <div className={'col text-left'}>
                            <span className={' text-muted'}>Version : {this.props.api_version}</span>
                        </div>
                        <div className={'col text-right'}>
                            <ul>
                                <li className={'link'}>
                                    <a className={'text-muted'} href={'https://github.com/team-lum/News'}> Contact
                                        us</a>
                                </li>
                                <li className={'link'}>
                                    <a className={'text-muted'} href={'https://newsapi.org/'}>All news provided by
                                        NewsAPI</a>
                                </li>

                            </ul>
                        </div>

                    </div>
                </div>
            </footer>
        );
    }
}

export default Footer;
