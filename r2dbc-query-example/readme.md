# Query By Example

GET -> `http://localhost:8080/customer/search?firstName=Tara`

Response:

```json
[
    {
        "id": 1,
        "firstName": "Tara",
        "lastName": "Wheeliker",
        "email": "twheeliker0@storify.com",
        "country": "Brazil",
        "isActive": false
    }
]
```

GET -> `http://localhost:8080/customer/search?firstName=Tara&lastName=Dacks`

No Response for the above HTTP GET as no such data exists.

GET -> `http://localhost:8080/customer/search?firstName=Dela&lastName=Dacks`

Response:

```
[
    {
        "id": 5,
        "firstName": "Dela",
        "lastName": "Dacks",
        "email": "ddacks4@hao123.com",
        "country": "China",
        "isActive": false
    }
]
```
