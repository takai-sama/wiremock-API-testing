package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;


public class Models {
    private static RequestSpecification request;
    public static void setupHeader(){
        request = RestAssured.given()
                .header("Content-Type","application/json")
                .header("Accept","application/json");
    }
    public static Response getUsers(String endpoint){
        setupHeader();
        return request.when().get(endpoint);
    }
    public static Response postUser(String endpoint){
        String firstname ="Adi";
        String lastname ="Putra";
        String age = "25";
        String email = "adi@gmail.com";
        JSONObject payload = new JSONObject();
        payload.put("firstname",firstname);
        payload.put("lastname",lastname);
        payload.put("age", age);
        payload.put("email", email);
        setupHeader();
        return request.body(payload.toString()).when().post(endpoint);
    }
    public static Response deleteUser(String endpoint){
        setupHeader();
        return request.when().delete(endpoint);
    }

    public static Response updateUser(String endpoint){
        setupHeader();
        String firstname ="Adi-edit";
        String lastname ="Putra-edit";
        String age = "25";
        String email = "adi@gmail.com";
        JSONObject payload = new JSONObject();
        payload.put("firstname",firstname);
        payload.put("lastname",lastname);
        payload.put("age",age);
        payload.put("email",email);
        return request.body(payload.toString()).when().put(endpoint);
    }
}
