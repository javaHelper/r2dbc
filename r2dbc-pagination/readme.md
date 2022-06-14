# R2DBC Pagination

`http://localhost:8080/product/all?page=0&size=3`

Response:

```json
{
    "content": [
        {
            "id": 97,
            "description": "product-100",
            "price": 972
        },
        {
            "id": 45,
            "description": "product-45",
            "price": 971
        },
        {
            "id": 78,
            "description": "product-82",
            "price": 962
        }
    ],
    "pageable": {
        "sort": {
            "unsorted": true,
            "sorted": false,
            "empty": true
        },
        "pageNumber": 0,
        "pageSize": 3,
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "totalElements": 100,
    "totalPages": 34,
    "last": false,
    "numberOfElements": 3,
    "size": 3,
    "first": true,
    "sort": {
        "unsorted": true,
        "sorted": false,
        "empty": true
    },
    "number": 0,
    "empty": false
}
```

`http://localhost:8080/product/pagenation?page=0&size=10`

Response:

```json
{
    "content": [
        {
            "id": 26,
            "description": "product-25",
            "price": 7
        },
        {
            "id": 27,
            "description": "product-26",
            "price": 8
        },
        {
            "id": 69,
            "description": "product-69",
            "price": 9
        },
        {
            "id": 40,
            "description": "product-41",
            "price": 10
        },
        {
            "id": 13,
            "description": "product-11",
            "price": 11
        },
        {
            "id": 63,
            "description": "product-63",
            "price": 16
        },
        {
            "id": 31,
            "description": "product-28",
            "price": 16
        },
        {
            "id": 82,
            "description": "product-81",
            "price": 19
        },
        {
            "id": 68,
            "description": "product-66",
            "price": 29
        },
        {
            "id": 75,
            "description": "product-75",
            "price": 31
        }
    ],
    "pageable": {
        "sort": {
            "sorted": true,
            "unsorted": false,
            "empty": false
        },
        "pageNumber": 0,
        "pageSize": 10,
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "totalElements": 100,
    "totalPages": 10,
    "last": false,
    "numberOfElements": 10,
    "size": 10,
    "sort": {
        "sorted": true,
        "unsorted": false,
        "empty": false
    },
    "first": true,
    "number": 0,
    "empty": false
}
```
