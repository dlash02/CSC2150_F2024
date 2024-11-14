const express = require("express");
const app = express();
const bodyParser = require('body-parser');
const path = require('path');  // add path
app.use( bodyParser.urlencoded({extended: false}));  // middleware and parses body
app.use(express.static(path.join(__dirname, 'public')));  // add middleware
let h = "<html><head> <title> my Title</title></head><body>";
let fe = "</form> </body> </html>";

app.get( '/add-product', (req, res,next ) => {
    res.sendFile(path.join(__dirname, 'public', 'addProduct.html'));
});

app.post( '/product', (req, res,next ) => {
    console.log( "Add product" );

    console.log( req.body );
    let title = req.body.title;
    let item = `<span style='color:red'> title=${title} </span>`;
    res.send(`${h} <h2> Welcome product </h2> ${item} ${fe}`);
});
app.use( '/', (req, res,next ) => {
    console.log("At /");
    res.sendFile(path.join(__dirname, 'public', 'showProducts.html'));
});
let port = 3001;
console.log( `listen on http://localhost:${port}`);
app.listen( port )