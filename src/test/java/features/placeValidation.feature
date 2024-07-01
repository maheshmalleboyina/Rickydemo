Feature: Validating the API'S on servers

@AddPalce @regression
Scenario Outline: validate that place is being added on server by Addplace API
Given: Add place payload with "<name>" "<Language>" "<Address>"
When: user calls "AddPalceAPI" with "post" https request
Then:  the Api call got success with status code "200"
And: "Status" in response body is "Ok"
And: "scope" in response body is "APP"
And: verify place_id created maps to "<name>" using "getPalceAPI"

Examples:
        |name  | Language  | Address  |
        |mahesh|English    |new market|
#       |ram   |spanish    |old market|

@deletePalce @regression  
Scenario: verify if delete placeAPI funcitonality is working
Given: Deleteplace payload
When: when user calls "deletePalceAPI" with "post" http request
Then:  the Api call got success with status code "200"
And: "Status" in response body is "Ok" 


