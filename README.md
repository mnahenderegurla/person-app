Build: use maven commands mvn clean install
Run: go to PersonAppApplication java file right click and run as java application
1. Add Person (id, firstName, lastName)
Request:
http://localhost:8080/person/create
Method: POST
Request body: {"id":"32332","firstName":"wewew","lastName":"sdsd"}

2. Edit Person (firstName, lastName)
Request:
http://localhost:8080/person/update/32332
Method: PUT
RequestBody: {"firstName":"mahendde","lastName":"errt"}
3. Delete Person (id)
Request:
http://localhost:8080/person/delete/32332
Method: DELETE

4. Add Address to person [multiple required] (id, street, city, state,postalCode)
Request:
http://localhost:8080/person/address/add
Mathod: POST
RequestBody:
{
  "pid": "32332",
  "addresses": [
    {
      "id": "a100001",
      "street": "street one",
      "city": "city one",
      "state": "state one",
      "postal": "post 001"
    },
    {
      "id": "a100002",
      "street": "street two",
      "city": "city two",
      "state": "state two",
      "postal": "post 002"
    }
  ]
}

5. Edit Address (street, city, state, postalCode)
Request: http://localhost:8080/person/address/update/a100001
Method:PUT
RequestBody:
{
      "street": "street one ext",
      "city": "city one ext",
      "state": "state one ext",
      "postal": "post 001 ext"
}

6. Delete Address (id)
Request:
http://localhost:8080/person/address/delete/a100002
Method: DELETE

7. Count Number of Persons
Request: http://localhost:8080/personsCount
Method: GET

8. List Persons
Request:
http://localhost:8080/persons
Mathod: GET
