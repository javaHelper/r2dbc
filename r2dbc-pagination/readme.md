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

