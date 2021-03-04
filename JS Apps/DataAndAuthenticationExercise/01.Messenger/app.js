const url = 'http://localhost:3030/jsonstore/messenger';

function attachEvents() {
    const author = document.querySelector('input[name="author"]');
    const content = document.querySelector('input[name="content"]');
    document.getElementById('refresh').addEventListener('click', refreshChat);
    document.getElementById('submit').addEventListener('click', () => submitMessage(author, content));
}

async function refreshChat() {
    const messages = document.getElementById('messages');
    const response = await fetch(url);
    const parsed = await response.json();
    messages.textContent = Object.values(parsed)
        .map(e => e.author + ': ' + e.content)
        .join('\n');
}

async function submitMessage(author, content) {
    try {
        if(author.value==''||content.value==''){
            throw new Error('Please fill in all fields');
        }
        const response = await fetch(url, {
            method: 'post',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({author: author.value, content: content.value})
        });
        const parsed = await response.json();
        if (response.ok) {
            await refreshChat();
            author.value = '';
            content.value = '';
        } else {
            throw new Error(parsed.message);
        }
    }catch (err){
        alert(err.message);
    }
}

attachEvents();