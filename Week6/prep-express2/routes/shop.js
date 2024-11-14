const express = require("express");
const router = express.Router();
const path = require('path');

router.get('/shop', (req, res, next) => {
    // res.status(404).send("<h2> Showing Products to show</h2>" );
    // res.sendFile(path.join(__dirname, '../public', 'showProducts.html'));
    console.log( __dirname );
    res.sendFile(path.join( __dirname, '../views', 'shop.html'));
});
router.get('/home', (req, res, next) => {
    res.status(404).send("<h2> Showing home page</h2>" );
});
module.exports = router;