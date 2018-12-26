import React, {Component} from 'react';
import NavBar from './components/navbar/NavBar.js'
import Footer from "./components/footer/Footer";
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Article from "./components/article/Article";
import Http from "./service/Http";
import {articleUrl, versionUrl} from "./Urls";

class App extends Component {

    constructor(props) {
        super(props);

        this.state = {
            articles: [],
            page: 0,
            pageSize: 3,
            search: false
        };

        this.http = new Http();

    }

    componentDidMount() {
        this.nextPage();
        this.getVersion();
        window.addEventListener('scroll', this.listenScrollEvent);
    }

    componentWillUnmount() {
        window.removeEventListener('scroll', this.listenScrollEvent);
    }

    getVersion = () =>  {
        this.http.get(
            versionUrl,
            (json) =>
                this.setState({
                    api_version: json.value
                })
        );
    };

    getArticles = () => {
        this.http.get(`${articleUrl}?page=${this.state.page}&size=${this.state.pageSize}`,
            (json) =>
                this.setState(previousState => ({
                    articles: [...previousState.articles, ...json.content],
                    loadMoreVisible: json.content.last
                }))
        );
    };

    nextPage = () =>  {
        this.setState( prevState => ({
            page: prevState.page + 1
        }));
        this.getArticles();
    };

    listenScrollEvent = () =>  {
        if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
            this.nextPage();
        }
    };

    setSearchType = () => {
        this.setState(prevState => ({
            search: !prevState.search
        }));
    };


    render() {
        return (
            <React.Fragment>
                <div>
                    <NavBar changeSearcheType={this.setSearchType}/>
                </div>
                <div className={'articleList container'} >
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


                <div className={'divFooter'}>
                    <Footer api_version={this.state.api_version}/>
                </div>

            </React.Fragment>
        );
    }
}

export default App;
