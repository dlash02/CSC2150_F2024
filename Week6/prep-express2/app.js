const http = require("http");

const express = require("express");

const app = express();

let port = 3000;
const server = http.createServer(app);
console.log(`Listening on http://localhost:${port}`);
server.listen(port);