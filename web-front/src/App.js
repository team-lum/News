import React, {Component} from 'react';
import NavBar from './components/navbar/NavBar.js'
import Footer from "./components/footer/Footer";
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Article from "./components/article/Article";
import Http from "./service/Http";
import Alert from "./components/alert/Alert"
import {articleUrl, versionUrl} from "./Urls";

class App extends Component {

    constructor(props) {
        super(props);

        this.state = {
            articles: [],
            page: 0,
            pageSize: 3,
            errors: [{
                title: 'Warning',
                message:'Some'
            }]
        };

        this.http = new Http();

        this.http.get(`${articleUrl}?page=${this.state.page}&size=${this.state.pageSize}`, (json) =>
            this.setState({
                articles: json.content
            })
        );

        this.http.get(versionUrl, (json) =>
            this.setState({
                api_version: json.value
            })
        );

        setTimeout(() => this.setState({
            errors: []
        }), 5000)
    }

    render() {
        return (
            <React.Fragment>
                <div>
                    <NavBar/>
                </div>
                <div className={'articleList container'}>
                    <ul>
                        {
                            this.state.articles.map((article) =>
                                <li className={'list'} key={article.publishedAt}>
                                    <Article news={article}/>
                                </li>
                            )
                        }
                    </ul>
                </div>
                <div>
                    {
                        this.state.errors.map((error) => <Alert message={error.message} title={error.title}/>)
                    }
                </div>

                <div className={'divFooter'}>
                    <Footer api_version={this.state.api_version}/>
                </div>

            </React.Fragment>
        );
    }
}

export default App;
