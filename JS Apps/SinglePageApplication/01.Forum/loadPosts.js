export {appendPosts, setUpLoad}

let container;
let homePage;
let contentPage;

function setUpLoad(containerParam,homeParam, contentParam) {
    container = containerParam;
    homePage = homeParam;
    contentPage = contentParam;
}

async function appendPosts() {
    homePage.style.display = '';
    contentPage.style.display = 'none';
    const url = 'http://localhost:3030/jsonstore/collections/myboard/posts';
    const response = await fetch(url);
    const data = await response.json();
    if (!response.ok) {
        return alert(data.message);
    }
    const content = Object.values(data)
        .map(e => {
            return `       <!-- comment  -->
       <div class="topic-container">
                    <div class="topic-name-wrapper">
                        <div class="topic-name">
                            <a href="#" class="normal">
                                <h2 id="${e._id}">${e.topicName}</h2>
                            </a>
                            <div class="columns">
                                <div>
                                    <p>Date: <time>${e.date}</time></p>
                                    <div class="nick-name">
                                        <p>Username: <span>${e.username}</span></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>`
        }).join('');
    container.innerHTML = content;
}