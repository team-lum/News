import React, {Component} from 'react';
import './Article.css';
import 'bootstrap/dist/css/bootstrap.min.css';

class Article extends Component {
    render() {
        const article = this.props.news;
        return (
            <div className={'article jumbotron'}>

                <div>
                    <a className={'link'} href={article.url} target={'_blank'}>
                        <h2 className={'title'}>
                            {article.title}
                        </h2>
                    </a>
                </div>


                <div>
                    <div className={'text-center'}>
                        {article.content}
                    </div>
                    <div className={'text-center'}>
                        <a href={article.url} target={'_blank'}>
                            <img className={'img'} src={article.urlToImage}/>
                        </a>
                    </div>
                </div>


                <div className={'row'}>
                    <div className={'col text-left'}>
                        Author: {article.author}
                    </div>
                    <div className={'col text-right'}>
                        Published at: {article.publishedAt}
                    </div>
                </div>
            </div>
        );
    }
}

export default Article;
