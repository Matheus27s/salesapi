# 👜 Sales API
Serviço geração de vendas

## Endpoints
**POST** Create Sale - url: http://localhost:8080/sale](http://localhost:8080/sale
```json
body
{
    "date": "2021-03-06",
    "value": 20.0,
    "sellerName": "Maria da Costa"
}
```
- - -

**POST** Create Seller - url: http://localhost:8080/seller
```json
body
{
    "name": "Maria da Costa"
}
```
- - -


**GET** Get All Sellers - url: http://localhost:8080/seller/2021-03-03/2021-03-06](http://localhost:8080/seller/2021-03-03/2021-03-06
