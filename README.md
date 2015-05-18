##Use dagger 2 in an application without dependency injection

###Launch the application : 
```
java -cp target/classes:target/dependency/* fr.xebia.App
```

###Get one user by id: 
```
GET http://localhost:8080/users/:id
```

###List slots:
```
GET http://localhost:8080/slots
```

###Create one new slot:
```
POST http://localhost:8080/slots 
Content-Type application/json
{
  "title": "Dagger 12",
  "pitch": "dans quelques annees",
  "speaker": {
    "login": "Jeremie"
  },
  "creationDate": "2025-05-19"
}
```
