import {article_url} from "../Urls";

class ArticleService {
    static getArticles(page, size, callback) {
        return fetch(`${article_url}?page=${page}&size=${size}`)
            .then(response => response.json())
            .then(json => callback(json))
            .catch(error => console.log(error))
    }
}

export default ArticleService;