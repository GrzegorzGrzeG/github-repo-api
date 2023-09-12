# github-repo-api
## Description
Simple api for checking user repositories and their recent commits
## How to use
Run `http://localhost:8080/{username}` where `{username}` is the name of the user you looking for.
## Exception handler
* If you enter non-existent user, you will get
`{
    “status”: 404
    “Message”: User does not exist
}`
* If you provide a different format than `Accept: application/json` in header or do not provice you will get
`{
    “status”: 406
    “Message”: Wrong response format
}`
