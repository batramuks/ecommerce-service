http://localhost:8082/

#######################################################################
DB Scripts
Insert into PRODUCT (PRODUCT_ID,NAME,PRICE) values ('4','Bag','2000');
Insert into PRODUCT (PRODUCT_ID,NAME,PRICE) values ('1','laptop','45000');
Insert into PRODUCT (PRODUCT_ID,NAME,PRICE) values ('2','mobile','10000');
Insert into PRODUCT (PRODUCT_ID,NAME,PRICE) values ('3','smart watch','30000');

#################################################################
To Create a product

POST http://localhost:8082/product
Request:
{
"productName": "Bag",
"productPrice" : 2000
}

###################################################################
To GET all products

GET http://localhost:8082/products
Response
{
"products": [
{
"productId": "4",
"productName": "Bag",
"productPrice": 2000.0
},
{
"productId": "1",
"productName": "laptop",
"productPrice": 45000.0
},
{
"productId": "2",
"productName": "mobile",
"productPrice": 10000.0
},
{
"productId": "3",
"productName": "smart watch",
"productPrice": 30000.0
}
]
}
#####################################################################
To Add Items in the Cart of the User

POST http://localhost:8082/add
Request:
{
"userName": "batramuks",
"cartItem": [
{
"productId": 1,
"quantity" : 3
},
{
"productId": 2,
"quantity" : 3
}
]

}
################################################################
TobPlace order by username and cartId

POST http://localhost:8082/placeorder
Request:
{
"username":"batramuks",
"cartId":7

}

##################################################################

To Get Orders by username

GET http://localhost:8082/orders/batramuks
Response:
{
"orderResponse": [
{
"username": "batramuks",
"email": "batra.muks@gmail.com",
"orderId": 6,
"orderItem": [
{
"productId": "1",
"productName": "laptop",
"productPrice": 45000.0,
"quantity": 3
},
{
"productId": "2",
"productName": "mobile",
"productPrice": 10000.0,
"quantity": 3
}
],
"totalPrice": 165000.0,
"createdDate": "2022-12-02T01:26:16.000+00:00"
}
]
}
##########################################################################
