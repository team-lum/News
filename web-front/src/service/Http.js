class Http {

    get(url, errorHandler = (exception) => alert(exception)) {
        return fetch(url)
            .then((response) => response.json())
            .catch((error) => errorHandler(error));
    }

    get(url, callback, errorHandler = (exception) => alert(exception)) {
        return fetch(url)
            .then((response) => response.json())
            .then((json) => callback(json))
            .catch((error) => errorHandler(error));
    }
}

export default Http;