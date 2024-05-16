# Assignment By Abhiram Deshpande
### API endpoints designed 
## Local Endpoints
* `/auth`  [**Public API**]
  * `/signup` - To sign up user. Once signed up, returns 201 with JWT response. 
  * `/login` - Upon successfull login, returns JWT reponse.
 
* `/home` [**Private API - Needs Authentication**]
  * `/get-user/{userName}` - To get all details about user. Needs a valid/registered userName as a path parameter

* `/update` [**Private API - Needs Authentication**]
  * `/update-first-name/{newFirstName}` - To get all details about user. Needs a valid/registered userName as a path parameter
  * `/update-last-name/`- To update last name. New last name would be sent through HTTP Body.
  * `/update-password/` - To update password. New password would be sent through HTTP Body.
  * `/update-mobile-number/` - To update mobile number. New mobile number would be sent through HTTP Body.

  * `/home` [**Private API - Needs Authentication**]
    * `/get-user/{userName}` - To get all details about user. Needs a valid/registered userName as a path parameter.

## Web Service Endpoints

* `/fetch-coin-data` [**Private API - Needs Authentication**]
  * This API fetched the coin data on given URL on the behalf of principal (user). API Headers and API key are provided by backend.
