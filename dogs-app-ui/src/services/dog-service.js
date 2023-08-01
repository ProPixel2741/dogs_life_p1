import http from './axios-common';

export function getAllDogs() {
    return http.get("/dogs");
}

export function getDogInfo(id) {
    return http.get("/dogs/" + id);
}