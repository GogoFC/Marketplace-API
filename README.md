# Marketplace API



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

### List all Ads which also shows to which User the listing belongs to.

`GET` `http://localhost:8080/ads`

### List a specific Ad by id

`GET` `http://localhost:8080/ads/{id}`

---








### Edit Ad by id (not authenticated)

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

`DELETE` `http://localhost:8080/ads/{ad_id}`

user_id below
```json
{
    "password": "pass",
    "id": "152"
}
```
### Unpublish Ad 
Removes entry from joined column

`DELETE` `http://localhost:8080/users/{user_id}/ads/{ad_id}/unpublish`

### Re-post Ad 
Writes user's id to `user_id` joined column in 'ad' Table.

`POST` `http://localhost:8080/users/{user_id}/ads/{ad_id}/unpublish`

