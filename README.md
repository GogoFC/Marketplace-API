# Marketplace API



### Create a User

| Method | URI |
|---|---|
|`POST`| `http://localhost:8080/users`|

```JSON
{
    "email": "sawyer@aol.com",
    "password": "password"
}
```


### Post an Ad to a User via id number
| Method | URI |
|---|---|
|`POST` | `http://localhost:8080/users/{id}/post_ad` |
```json
{
    "title": "Some Title",
    "description": "Some description",
    "password": "password"
}
```



### List all Users with their posted Ads

| Method | URI |
|---|---|
| `GET` | `http://localhost:8080/users` |

### List all Ads which also shows to which User the listing belongs to.

| Method | URI |
|---|---|
| `GET` | `http://localhost:8080/ads` |


### List a specific Ad by id

| Method | URI |
|---|---|
| `GET` | `http://localhost:8080/ads/{id}` |



### Edit Ad by id (not authenticated)

| Method | URI |
|---|---|
| `PUT` | `http://localhost:8080/ads/{id}` |





### Delete User by id number (authenticated)

| Method | URI |
|---|---|
| `DELETE` | `http://localhost:8080/users/{id}` |

```json
{
    "password": "password"
}
```

### Delete an Ad by id (Semi-authenticated) 
All users are root users and with a valid password can delete any Ad)

| Method | URI |
|---|---|
| `DELETE` | `http://localhost:8080/ads/{ad_id}` |

user_id below
```json
{
    "password": "pass",
    "id": "152"
}
```
### Unpublish Ad 
Removes entry from joined column `user_id` from Table `ad`.

| Method | URI |
|---|---|
| `DELETE` | `http://localhost:8080/users/{user_id}/ads/{ad_id}/unpublish` |

### Re-post Ad 
Writes user's id back to `user_id` joined column in `ad` Table.

| Method | URI |
|---|---|
| `POST` | `http://localhost:8080/users/{user_id}/ads/{ad_id}/unpublish` |

