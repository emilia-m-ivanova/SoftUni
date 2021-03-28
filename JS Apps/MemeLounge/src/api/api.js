import {showNotification} from "../views/notification.js";

export const settings = {
    host: ''
};

async function createRequest(url, options) {
    const response = await fetch(url, options);
    if (!response.ok) {
        const err = await response.json();
        showNotification(err.message);
        throw new Error(err.message);
    }
    try{
        const data = await response.json();
        return data;
    }catch (err){
    }
}

function createOptions(method, data) {
    const result = {
        method,
        headers: {}
    };
    if (data) {
        result.headers['Content-Type'] = 'application/json';
        result.body = JSON.stringify(data);
    }
    if (sessionStorage.getItem('token')) {
        result.headers['X-Authorization'] = sessionStorage.getItem('token');
    }
    return result;
}

export async function get(url) {
    return createRequest(url, createOptions('get'));
}

export async function post(url, body) {
    return createRequest(url, createOptions('post', body));
}

export async function put(url, body) {
    return createRequest(url, createOptions('put', body));
}

export async function del(url) {
    return createRequest(url, createOptions('delete'));
}

export async function login(email, password) {
    const response = await post(settings.host + '/users/login', {email, password});
    sessionStorage.setItem('token', response.accessToken);
    sessionStorage.setItem('username', response.username);
    sessionStorage.setItem('email', response.email);
    sessionStorage.setItem('userId', response._id);
    sessionStorage.setItem('gender', response.gender);

    return response;
}

export async function register(email, password, gender) {
    const response = await post(settings.host + '/users/register', {email, password, gender});

    sessionStorage.setItem('token', response.accessToken);
    sessionStorage.setItem('username', response.username);
    sessionStorage.setItem('email', response.email);
    sessionStorage.setItem('userId', response._id);
    sessionStorage.setItem('gender', response.gender);


    return response;
}

export async function logout() {
    const response = await get(settings.host + '/users/logout');

    sessionStorage.removeItem('token');
    sessionStorage.removeItem('username');
    sessionStorage.removeItem('email');
    sessionStorage.removeItem('userId');
    sessionStorage.removeItem('gender');
}