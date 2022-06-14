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

GET -> `http://localhost:8080/customer/insensativeSearch?firstName=dela&lastName=dacks`

```json
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

GET -> `http://localhost:8080/customer/insensitiveSearchForSpecificField?firstName=Dela&lastName=dacks`

```json
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

GET -> `http://localhost:8080/customer/matching-any?firstName=Tara&lastName=dacks`

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
    },
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

GET -> `http://localhost:8080/customer/searchEndsWith?email=com`

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
    },
    {
        "id": 2,
        "firstName": "Daisy",
        "lastName": "Klulisek",
        "email": "dklulisek1@constantcontact.com",
        "country": "Peru",
        "isActive": true
    },
    {
        "id": 5,
        "firstName": "Dela",
        "lastName": "Dacks",
        "email": "ddacks4@hao123.com",
        "country": "China",
        "isActive": false
    },
    {
        "id": 6,
        "firstName": "Brita",
        "lastName": "Doughton",
        "email": "bdoughton5@tmall.com",
        "country": "China",
        "isActive": false
    },
    {
        "id": 8,
        "firstName": "Vincenty",
        "lastName": "Ianinotti",
        "email": "vianinotti7@freewebs.com",
        "country": "Israel",
        "isActive": false
    },
    {
        "id": 10,
        "firstName": "Foss",
        "lastName": "Bifield",
        "email": "fbifield9@statcounter.com",
        "country": "Philippines",
        "isActive": false
    }
]
```

GET -> `http://localhost:8080/customer/searchForNull?firstName=null`

```json
[
    {
        "id": 4,
        "firstName": null,
        "lastName": "Pinckstone",
        "email": "mpinckstone3@prlog.org",
        "country": "Philippines",
        "isActive": true
    }
]
```
GET -> `http://localhost:8080/customer/search?country=BR`

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
