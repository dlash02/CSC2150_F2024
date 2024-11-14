const express = require("express");
const router = express.Router();
const path = require('path');

router.get('/add-product', (req, res,
                                        next) => {
    // res.status(404).send("<h2> Showing add-product to show</h2>" );
    console.log( __dirname );
    // res.sendFile(path.join(__dirname, '../public', 'addProduct.html'));
    res.sendFile(path.join(__dirname, '../views', 'add-product.html'));
});
router.post('/product', (req, res,
                            next) => {
    console.log( "Add product" );

    console.log( req.body );
    let title = req.body.title;
    let item = `<span style='color:red'> title=${title} </span>`;
    res.send(`$<h2> Added Product: </h2> ${item} `);
});
module.exports = router;