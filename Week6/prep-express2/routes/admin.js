const express = require('express');
const router = express.Router();
const path = require('path');
// const rootDir = require("../util/path.js");
//change app.get to router.get
// /admin/add-product => GET
const products = [];

router.get('/add-product', (req, res, next) => {
    res.sendFile(path.join(__dirname, '../', 'views', 'add-product.html'));
    // res.sendFile(path.join( 'add-product.html'));
   // res.render('addproduct', {pageTitle: 'Add Products', from : 'addproduct'});
});

router.post( '/product', (req, res,next ) => {
    // let h = "<html> <head><title> MyPage </title></head><body>";
    // let fe = "</form></body></html>";
    console.log( "Add product" );

    console.log( req.body );
    let title = req.body.title;
    products.push( {title: title}); // add object to array
   let item = `<span style='color:red'> title=${title} </span>`;
    //res.send(`${h} <h2> Welcome product </h2> ${item} ${fe}`);
    res.redirect("/shop")
});
// export 2 variables instead of 1
//module.exports = router;
exports.routes = router;
// exports.products = products;