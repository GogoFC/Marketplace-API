# Marketplace API

### Create a User

POST `http://localhost:8080/users`
```JSON
{
    "email": "sawyer@aol.com",
    "password": "password"
}
```


### Post an Ad to a User via id number

POST `http://localhost:8080/users/{id}/post_ad`
```JSON
{
    "title": "Some Title",
    "description": "Some description",
    "password": "password"
}
```

### Delete User by id number

http://localhost:8080/users/{id}

```json
{
    "password": "password"
}
```

### Edit user by id number (not authenticated)

`PUT` `http://localhost:8080/ads/{id}`

### List all Users with their posted Ads

GET `http://localhost:8080/users`

#### List all Ads which also shows to which User the listing belongs to.

GET `http://localhost:8080/ads`


http://localhost:8080/users/152/ads/202/publish

