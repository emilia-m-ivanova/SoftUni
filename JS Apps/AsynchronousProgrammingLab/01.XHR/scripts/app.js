function loadRepos() {
    const httpRequest = new XMLHttpRequest();
    const url = 'https://api.github.com/users/testnakov/repos';
    httpRequest.addEventListener('readystatechange', function () {
        if (httpRequest.readyState === 4 && httpRequest.status === 200) {
            document.getElementById("res").textContent = httpRequest.responseText;
        }

    });
    httpRequest.open("GET", url);
    httpRequest.send();
}