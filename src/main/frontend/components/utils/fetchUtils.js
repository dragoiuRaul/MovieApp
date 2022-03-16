class FetchUtils {

	static get(url) {
		return fetch(url, {
			method: 'GET',
			headers: {
				'Accept-Language': window.navigator.userLanguage || window.navigator.language,
				'Accept': 'application/json'
			}
		});
	}

	static post(url, bodyData) {
		return fetch(url, {
			method: 'POST',
			headers: {
				'Accept-Language': window.navigator.userLanguage || window.navigator.language,
				'Accept': 'application/json'
			},
			body: JSON.stringify(bodyData)
		});

	}
	static put(url, bodyData) {
		return fetch(url, {
			method: 'PUT',
			headers: {
				'Accept-Language': window.navigator.userLanguage || window.navigator.language,
				'Accept': 'application/json'
			},
			body: JSON.stringify(bodyData)
		});

	}
	static delete(url) {
		return fetch(url, {
			method: 'DELETE',
			headers: {
				'Accept-Language': window.navigator.userLanguage || window.navigator.language,
				'Accept': 'application/json'
			}
		});
	}
}
export default FetchUtils;