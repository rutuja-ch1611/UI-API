package testScripts;

import org.json.simple.JSONObject;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ApiTest {
    @Test
    public void getUserDetails(){
        baseURI="https://reqres.in/api";
        given().get("/users").then().statusCode(200).body("data[2].first_name",equalTo("Emma"));
    }
    @Test
    public void createAnEntry(){

        JSONObject req=new JSONObject();
        req.put("name","TestUser");
        req.put("job","Doctor");
        System.out.println(req.toJSONString());
        baseURI="https://reqres.in/api";
        given().body(req.toJSONString()).when().post("/users").then().statusCode(201).log().all();

    }


    }


