@api
Feature: Users Test Suite

  @get
  Scenario: Get List Data Users Valid
    Given SetURL endpoint "GET"
    When Send request get list users
    Then Verify that status code is equals 200
    Then Verify response json with JSONSchema "validateGetJsonSchema.json"
    Then Verify that response body get is valid


  @post
  Scenario: Create New Data User Valid
    Given SetURL endpoint "POST"
    When Send request post user
    Then Verify that status code is equals 201
    Then Verify response json with JSONSchema "validatePostJsonSchema.json"
    Then Verify that response body post is valid


  @update
  Scenario: Update Data User Valid
    Given SetURL endpoint "UPDATE"
    When Send request put users
    Then Verify that status code is equals 200
    Then Verify response json with JSONSchema "validatePostJsonSchema.json"
    Then Verify that response body update is valid


  @delete
  Scenario: Delete Data User Valid
    Given SetURL endpoint "DELETE"
    When Send request delete user
    Then Verify that status code is equals 204
