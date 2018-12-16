import React, {Component} from 'react';
import './Alert.css';
import 'bootstrap/dist/css/bootstrap.min.css';

class Alert extends Component{

    render() {
        let title = this.props.title;
        let message = this.props.message;
        return (
            (message || title) &&
            <div className="alert alert-danger alert-dismissible fade show text-center" role="alert">
                <strong>{title}</strong> <br/> {message}.
            </div>
        );
    }

}

export default Alert;