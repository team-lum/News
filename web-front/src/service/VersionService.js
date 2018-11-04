import {version_url} from "../Urls";

class VersionService {
    static getVersion() {
        return fetch(version_url)
            .then(response => response.json());
    }

    static getVersion(callback) {
        return fetch(version_url)
            .then(response => response.json())
            .then(json => callback(json));
    }
}

export default VersionService;