async function loadCommits() {
    const username = document.getElementById('username').value;
    const repository = document.getElementById('repo').value;
    const ulElement = document.getElementById('commits');
    ulElement.innerHTML = '';
    const url = `https://api.github.com/repos/${username}/${repository}/commits`

    try {
        const promise = await fetch(url);
        if (!promise.ok) {
            throw new Error(`${promise.status} (${promise.statusText})`);
        }
        const commits = await promise.json();
        commits.forEach(e => {
            const element = document.createElement('li');
            element.textContent = `${e.commit.author.name}: ${e.commit.message}`;
            ulElement.appendChild(element);
        });
    }catch (err){
        const element = document.createElement('li');
        element.textContent = `Error: ${err.message}`;
        ulElement.appendChild(element);
    }
}