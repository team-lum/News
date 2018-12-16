import React, {Component} from 'react';
import NavBar from './components/navbar/NavBar.js'
import Footer from "./components/footer/Footer";
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Article from "./components/article/Article";
import ArticleService from "./service/ArticleService";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
          articles: []
        };
        ArticleService.getArticles(0, 3, json => {
            this.setState({
                articles: json.content
            })
        });
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
                            this.state.articles.map(article =>
                                <li className={'list'} key={article.publishedAt}>
                                    <Article news={article}/>
                                </li>
                            )
                        }
                    </ul>
                </div>
                <div>
                    <Footer api_version={this.state.api_version}/>
                </div>

            </React.Fragment>
        );
    }
}

export default App;
