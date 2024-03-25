# Marketplace API

### Create User

POST `http://localhost:8080/users`
```JSON
{
    "email": "goa@aol.com",
    "password": "pass"
}
```


### Post Ad

POST `http://localhost:8080/users/{id}/post_ad`
```JSON
{
    "title": "Some Title",
    "description": "Some description",
    "password": "password"
}
```
