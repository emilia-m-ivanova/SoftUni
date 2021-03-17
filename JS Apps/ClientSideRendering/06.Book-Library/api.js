const url = 'http://localhost:3030/jsonstore/collections/books';

export async function getAllBooks() {
    const response = await fetch(url);
    const parsed = await response.json();
    if (response.ok) {
        return Object.entries(parsed).map(([k, v]) => {
            return {[k]: v}
        })
    } else {
        return alert(parsed.message);
    }
}

export async function addBook(data) {
    const response = await fetch(url, {
        method: 'post',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    });
    if (!response.ok) {
        const error = await response.json();
        return error.message;
    }
}

export async function editBook(data, id) {
    const response = await fetch(url + `/${id}`, {
        method: 'put',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    });
    if (!response.ok) {
        const error = await response.json();
        return error.message;
    }
}

export async function del(id) {
    const response = await fetch(url + `/${id}`, {
        method: 'delete'
    })
    if (!response.ok) {
        const error = await response.json();
        return error.message;
    }
}