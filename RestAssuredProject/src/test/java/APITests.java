import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class APITests {

    //Este metodo Get -> pega todas as informações do JSON;
    @Test
    public void Get1(){

        RestAssured.baseURI = "https://reqres.in/api/users?page=2";

        RestAssured.given().param("page", "2")
        .when()
                .get()
                .then()
                .assertThat()
                .log()
                .all()
                .statusCode(200);


        System.out.println("\n\n");

    }

    //Este metodo Get -> pega apenas o Body (ou seja, os dados mais importantes que seram manipulados pelo sistema) do JSON;
    @Test
    public void Get2(){

        RestAssured.baseURI = "https://reqres.in/api/users?page=2";

        Response response = RestAssured.given().param("page", "2").when().get();

        System.out.println(response.getBody().asString());

        System.out.println("getStatusCode " +response.getStatusCode());
        System.out.println("ContentType " +response.contentType());
        System.out.println("Time " +response.getTime());
        System.out.println("Cookies " +response.getCookies());

        System.out.println("\n\n");

    }


    @Test
    public void Post(){

        RestAssured.baseURI = "https://reqres.in/api/users";

        String json = "{\n" + "   \"name\": \"Leandro\",\n" + "    \"job\": \"Dev\"\n" + "}";

        RestAssured.given().body(json).post().then().log().all().assertThat().statusCode(201);

        System.out.println("\n\n");

    }

    @Test
    public void Put(){

        JSONObject request = new JSONObject();

        request.put("name", "Leandro");
        request.put("job", "Programador");

        System.out.println(request.toString());

        baseURI = "https://reqres.in/api";

                given().
                  header("Content-Type", "application/json").
                  contentType(ContentType.JSON).
                  accept(ContentType.JSON).
                  body(request.toString()).
                when().
                  put("/users/2").
                then().
                  statusCode(200).
                  log().all();

    }


    @Test
    public void Patch(){

        JSONObject request = new JSONObject();

        request.put("name", "Leandro Ucuamba");
        request.put("job", "Dev");

        System.out.println(request.toString());

        baseURI = "https://reqres.in";

                given().
                  header("Content-Type", "application/json").
                  contentType(ContentType.JSON).
                  accept(ContentType.JSON).
                  body(request.toString()).
                when().
                  patch("api/users/2").
                then().
                  statusCode(200).
                  log().all();

    }



    @Test
    public void Delete(){

        baseURI = "https://reqres.in";


                when().
                   delete("api/users/2").
                then().
                   statusCode(204).
                   log().all();

    }



}
