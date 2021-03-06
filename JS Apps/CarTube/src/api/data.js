import * as api from './api.js';

api.settings.host = 'http://localhost:3030'

export const login = api.login;
export const register = api.register;
export const logout = api.logout;

export async function getItems() {
    return await api.get(api.settings.host + '/data/cars?sortBy=_createdOn%20desc')
}

export async function getItem(id) {
    return await api.get(api.settings.host + '/data/cars/' + id)
}

export async function getItemsByOwner(userId) {
    return await api.get(api.settings.host + `/data/cars?where=_ownerId%3D%22${userId}%22&sortBy=_createdOn%20desc`);
}

export async function getItemsByYear(year) {
    return await api.get(api.settings.host + `/data/cars?where=year%3D${year}`);
}

export async function deleteItem(id) {
    return await api.del(api.settings.host + '/data/cars/' + id);
}

export async function addItem(item) {
    return await api.post(api.settings.host + `/data/cars`, item);
}

export async function editItem(id, item) {
    return await api.put(api.settings.host + `/data/cars/` + id, item);
}
