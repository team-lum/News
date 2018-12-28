import React, {Component} from 'react';
import NavBar from './components/navbar/NavBar.js'
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Article from "./components/article/Article";
import Http from "./service/Http";
import {articleUrl, versionUrl} from "./Urls";
import ReactCSSTransitionGroup from 'react-addons-css-transition-group';

class App extends Component {

    _timer;

    constructor(props) {
        super(props);

        this.state = {
            articles: [],
            page: 0,
            pageSize: 3,
            searchKeyword: '',
            loading: false,
            timer: undefined
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

    getVersion = () => {
        this.http.get(
            versionUrl,
            (json) =>
                this.setState({
                    api_version: json.value
                })
        );
    };

    getArticles = () => {
        this.setState({loading: true});
        this.http.get(
            `${articleUrl}${this.state.searchKeyword ? `/search?keyword=${this.state.searchKeyword}&` : '?'}page=${this.state.page}&size=${this.state.pageSize}`,
            (json) =>
                this.setState(previousState => ({
                    articles: [...previousState.articles, ...json.content],
                    loadMoreVisible: json.content.last,
                    loading: false
                }))
        );
    };

    nextPage = () => {
        this.setState(prevState => ({
            page: prevState.page + 1
        }));
        this.getArticles();
    };

    listenScrollEvent = () => {
        if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
            this.nextPage();
        }
    };

    handleSearchChange = (event) => {
        this.setState({searchKeyword: event.target.value});
        if (this._timer !== false) {
            clearTimeout(this._timer)
        }
        this._timer = setTimeout(() => {
            this.setState({
                articles: [],
                page: 0
            });
            this.getArticles();
            this._timer = false;
        }, 300)
    };


    render() {
        return (
            <React.Fragment>
                <div>
                    <NavBar api_version={this.state.api_version}/>
                </div>

                <div className={'container search'}>
                    <form>
                        <div className={'form-group'}>
                            <input className={'form-control'} type="search" placeholder="Search" aria-label="Search"
                                   value={this.state.searchKeyword}
                                   onChange={this.handleSearchChange}
                            />
                        </div>
                    </form>
                </div>

                <div className={'articleList container'}>
                    <ul>
                        <ReactCSSTransitionGroup
                            transitionName="newsTransition"
                            transitionEnterTimeout={500}
                            transitionLeaveTimeout={300}>
                            {
                                this.state.articles.map((article) =>
                                    <li className={'list'} key={article.publishedAt}>
                                        <Article news={article}/>
                                    </li>
                                )
                            }
                        </ReactCSSTransitionGroup>
                    </ul>
                </div>
            </React.Fragment>
        );
    }
}

export default App;
