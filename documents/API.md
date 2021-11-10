## API

#### Web URLs

|Web URL                           | HTTP Action | Operation                | 
|----------------------------------|-------------|--------------------------|
|`http://localhost:8080/index.html`| GET         | Returns `index.html` page|

#### Explore Rest APIs

| RESTful URL                      | HTTP Action | Noun |Business Operation |Sample Valid Request Body | 
|----------------------------------|-------------|------|-------------------|--------------------------|
|`/api/person`                     |GET          |person|get all persons    |                          |  
|`/api/person`                     |POST         |person|create person      |[JSON](#person)           |  
|`/api/person/{id}`                |PUT          |person|update person      |[JSON](#person)           | 
|`/api/person/{id}`                |GET          |person|get person by id   |                          |  
|`/api/person/{id}`                |DELETE       |person|delete person by id|                          | 

##### Sample Valid JSON Request Body

###### <a id="person">Person -> /api/person</a>

```json
{
    "name": "Johnny",
    "email": "example-johnny@domain.com",
    "mobileNumber": "1234771",
    "address": {
        "city": "Wisokyburghh-update",
        "zipcode": "9077-777"
    }
}
```
