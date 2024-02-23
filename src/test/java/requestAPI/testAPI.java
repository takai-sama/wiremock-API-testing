package requestAPI;

import helper.Endpoint;
import helper.utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;

import static helper.Models.*;
import static org.assertj.core.api.Assertions.assertThat;


public class testAPI {
    String setURL;
    String idUpdate = "4";
    Response res;
    public void prepareURL(String url){
        if(url.equals("GET") || url.equals("POST")){
            setURL= Endpoint.endpoint;
        } else if (url.equals("UPDATE") || url.equals("DELETE")){
            setURL= Endpoint.endpoint+idUpdate;
        }else{
            System.out.println("Wrong Request");
        }

        System.out.println("Endpoint : "+setURL);
    }

    public void sendReqGetUsers() {
        res= getUsers(setURL);
        System.out.println(res.getBody().asString());
    }
    public void sendReqPostUser(){
        res= postUser(setURL);
        System.out.println(res.getBody().asString());
    }
    public void validationStatusCode(int status_code) {
        assertThat(res.statusCode()).isEqualTo(status_code);
    }


        public void validationResponseBodyGetUsers() {
        List<Object> id = res.jsonPath().getList("id");
        List<Object> firstname = res.jsonPath().getList("firstname");
        List<Object> lastname = res.jsonPath().getList("lastname");
        List<Object> age = res.jsonPath().getList("age");
        List<Object> email = res.jsonPath().getList("email");
        assertThat(id.get(0)).isNotNull();
        assertThat(firstname.get(0)).isNotNull();
        assertThat(lastname.get(0)).isNotNull();
        assertThat(age.get(0)).isNotNull();
        assertThat(email.get(0)).isNotNull();
    }
    public void validationResponseBodyPostUser() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        String id = jsonPathEvaluator.get("id");
        String firstName = jsonPathEvaluator.get("firstname");
        String lastName = jsonPathEvaluator.get("lastname");
        String age = jsonPathEvaluator.get("age");
        String email = jsonPathEvaluator.get("email");
        assertThat(id).isNotNull();
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(age).isNotNull();
        assertThat(email).matches("(.+\\@.+\\..+)");
    }

    public void validationResponseJsonWithJSONSchema(String filename) {
        File JSONFile = utility.getJSONSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

    public void sendReqDeleteUser(){
        res=deleteUser(setURL);
        System.out.println("Id deleted : " + res.getBody().asString());
    }
    public void sendReqUpdateData(){
        res=updateUser(setURL);
        System.out.println(res.getBody().asString());
    }

    public void validationResponseBodyUpdateData() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        String id = jsonPathEvaluator.get("id");
        String firstName = jsonPathEvaluator.get("firstname");
        String lastName = jsonPathEvaluator.get("lastname");
        String age = jsonPathEvaluator.get("age");
        String email = jsonPathEvaluator.get("email");
        assertThat(id).isNotNull();
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(age).isNotNull();
        assertThat(email).matches("(.+\\@.+\\..+)");
    }
}
