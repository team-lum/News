import React, {Component} from 'react';
import './Footer.css';
import 'bootstrap/dist/css/bootstrap.min.css';

class Footer extends Component {
    render() {
        return (
            <footer className={'footer bg-light'}>
                <div className={'container-fluid'}>
                    <div className={'float-lg-left'}>
                        <span className={'text-muted'}>Version : {this.props.api_version}</span>
                    </div>
                </div>
            </footer>
        );
    }
}

export default Footer;
