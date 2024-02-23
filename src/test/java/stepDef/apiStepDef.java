package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import requestAPI.testAPI;

public class apiStepDef {
    testAPI testapi;

    public apiStepDef() {
        this.testapi = new testAPI();
    }

    @Given("SetURL endpoint {string}")
    public void seturlEndpoint(String url) {
        testapi.prepareURL(url);
    }
    @When("Send request get list users")
    public void sendRequestGetListUsers() {
        testapi.sendReqGetUsers();
    }

    @Then("Verify that status code is equals {int}")
    public void verifyThatStatusCodeIsEquals(int status) {
        testapi.validationStatusCode(status);
    }

    @Then("Verify that response body post is valid")
    public void verifyThatResponseBodyPostIsValid() {
        testapi.validationResponseBodyPostUser();
    }

    @Then("Verify response json with JSONSchema {string}")
    public void verifyResponseJsonWithJSONSchema(String schema) {
        testapi.validationResponseJsonWithJSONSchema(schema);
    }

    @When("Send request post user")
    public void sendRequestPostUser() {
        testapi.sendReqPostUser();
    }

    @When("Send request put users")
    public void sendRequestPutUsers() {
        testapi.sendReqUpdateData();
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        testapi.sendReqDeleteUser();
    }

    @Then("Verify that response body get is valid")
    public void verifyThatResponseBodyGetIsValid() {
        testapi.validationResponseBodyGetUsers();
    }

    @Then("Verify that response body update is valid")
    public void verifyThatResponseBodyUpdateIsValid() {
        testapi.validationResponseBodyUpdateData();
    }

}
