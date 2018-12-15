import {version_url} from "../Urls";

class VersionService {
    static getVersion() {
        return fetch(version_url)
            .then(response => response.json())
            .catch(error => console.log(error));
    }

    static getVersion(callback) {
        return fetch(version_url)
            .then(response => response.json())
            .then(json => callback(json))
            .catch(error => console.log(error));
    }
}

export default VersionService;