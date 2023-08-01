import axios from "axios";
import http from './axios-common';

export default axios.create({
    baseURL: "http://127.0.0.1:8080",
    headers: {
        "Content-type": "application/json"
    }
});