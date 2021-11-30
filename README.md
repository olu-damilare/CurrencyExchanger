# Currency Exchanger

This is a springboot web app that generates the latest exchange rate for over 150 currencies. Currencies are represented as their standard format in three letters like USD, NGN.

## Request

HTTP method = POST

```

    {
    
    "currency1": "USD",
    
    "currency2": "NGN"

       }


```
Currency 1 is the base currency against which you want to obtain the rate. In reference to the request example, NGN1 = USD409.64625.

## Response

Response type = application/json

```
{

"rate": 409.64625
}

```

## Error codes

OK - 200
BAD REQUEST = 400

In an instance where you get a 400 status code, ensure the currency representation is valid.

## Author
[@olu-damilare](https://github.com/olu-damilare)