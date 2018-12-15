import React, {Component} from 'react';
import NavBar from './components/navbar/NavBar.js'
import Footer from "./components/footer/Footer";
import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import VersionService from "./service/VersionService";
import Article from "./components/article/Article";
import News from "./model/News";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            articles: [
                new News("Vovan",
                    "IT",
                    "https://amp.businessinsider.com/images/5c1436bf2a5b74245b1b458b-960-480.jpg",
                    "https://amp.businessinsider.com/images/5c1436bf2a5b74245b1b458b-960-480.jpg",
                    "212.1298.1987",
                    "jhbvjdbvjdbv"),
                new News("Vovan",
                    "IT",
                    "https://amp.businessinsider.com/images/5c1436bf2a5b74245b1b458b-960-480.jpg",
                    "https://amp.businessinsider.com/images/5c1436bf2a5b74245b1b458b-960-480.jpg",
                    "212.1298.1987",
                    "jhbvjdbvjdbv")
            ]
        };
        VersionService.getVersion(json => {
            this.setState({
                api_version: json.value
            });
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
