package api.endpoints;
import static io.restassured.RestAssured.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints {
	
	public static Response createUser(User payload)
	{
		Response res = given()
							.contentType(ContentType.JSON)
							.accept(ContentType.JSON)
							.body(payload)
						.when()
							.post(Routes.post_url);
		
		return res;
	}
	
	public static Response getUser(String UserName )
	{
		Response res = given()
							.pathParam("username", UserName)
						.when()
							.get(Routes.get_url);
		
		return res;
	}
	
	public static Response updateUser(String UserName, Response payload)
	{
		Response res = given()
							.contentType(ContentType.JSON)
							.accept(ContentType.JSON)
							.body(payload)
							.pathParam("username", UserName)
						.when()
							.put(Routes.update_url);		
		
		return res;
	}
	
	public static Response deleteUser(String UserName)
	{
		Response res = given()
							.pathParam("username", UserName)
						.when()
							.delete(Routes.delete_url);
		return res;
						
	}

}
