# Marketplace API

--- 

### Create a User

`POST` `http://localhost:8080/users`
```JSON
{
    "email": "sawyer@aol.com",
    "password": "password"
}
```


### Post an Ad to a User via id number

`POST` `http://localhost:8080/users/{id}/post_ad`
```json
{
    "title": "Some Title",
    "description": "Some description",
    "password": "password"
}
```
---

### List all Users with their posted Ads

`GET` `http://localhost:8080/users`

#### List all Ads which also shows to which User the listing belongs to.

`GET` `http://localhost:8080/ads`

---



### Edit user by id number (not authenticated)

`PUT` `http://localhost:8080/ads/{id}`

---


http://localhost:8080/users/152/ads/202/publish

### Delete User by id number (authenticated)

`DELETE` `http://localhost:8080/users/{id}`

```json
{
    "password": "password"
}
```

### Delete an Ad by id 
(Semi-authenticated. All users are root users and with a valid password can delete any Ad)

`DELETE` `http://localhost:8080/ads/{id}`

---
