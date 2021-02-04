function getArticleGenerator(articles) {
    const content = document.querySelector('#content');
    return () => {
        if (articles.length>0) {
            const newElement = document.createElement('article');
            newElement.textContent = articles.shift();
            content.appendChild(newElement);
        }
    }
}
