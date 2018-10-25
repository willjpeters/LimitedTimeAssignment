package assessment;

import org.json.simple.JSONObject;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@SuppressWarnings("unused")
public class Step
{
	RequestSpecification request = RestAssured.given();
	
	@Given("^that the database of items can be accessed with a status code of (\\d+)$")
	public void that_the_database_of_items_can_be_accessed_with_a_status_code_of(int arg1)
	{
		
		Response response = request.get("http://10.0.10.10:9966/petclinic/api/owners");
		System.out.println("PRE-STATUS CODE");
		response.then().statusCode(200);
		response.prettyPrint();
		System.out.println("GET ALL SUCCESSFUL");
	}
	
	@SuppressWarnings("unchecked")
	@When("^a new user is added to the system$")
	public void a_new_user_is_added_to_the_system()
	{
		request.header("Content-Type", "application/json;charset=UTF-8");
		JSONObject ownerPost = new JSONObject();
		ownerPost.put("address", "421 Wayne Street");
		ownerPost.put("city", "Los Angeleso");
		ownerPost.put("firstName", "Jasono");
		ownerPost.put("id", "17");
		ownerPost.put("lastName", "Javaco");
		ownerPost.put("pets", "");
		ownerPost.put("telephone", "01749876966");
		
		request.body(ownerPost);
		
		Response response = request.post("http://10.0.10.10:9966/petclinic/api/owners");
		System.out.println("PRE-STATUS CODE");
		response.then().statusCode(201);
		response.prettyPrint();
		System.out.println("POST SUCCESSFUL");
	}

	@SuppressWarnings("unchecked")
	@When("^their information is updated$")
	public void their_information_is_updated()
	{
		request.header("Content-Type", "application/json;charset=UTF-8");
		JSONObject ownerPut = new JSONObject();
		Response response = request.put("http://10.0.10.10:9966/petclinic/api/owners/16");
		ownerPut.put("address", "4202 Waynely Streety");
		ownerPut.put("city", "Los Angeles");
		ownerPut.put("firstName", "Jasonery");
		ownerPut.put("id", "16");
		ownerPut.put("lastName", "Javacky");
		ownerPut.put("pets", "");
		ownerPut.put("telephone", "01749876966");
		request.body(ownerPut);
//		Response response = request.put("http://10.0.10.10:9966/petclinic/api/owners/16");
		System.out.println("PRE-STATUS CODE");
		response.then().statusCode(204);
		response.prettyPrint();
		System.out.println("PUT SUCCESSFUL");
	}

	@When("^then this entry may be deleted$")
	public void then_this_entry_may_be_deleted()
	{
		Response response = request.delete("http://10.0.10.10:9966/petclinic/api/owners/7");
		System.out.println("PRE-STATUS CODE");
		response.then().statusCode(204);
		response.prettyPrint();
		System.out.println("DELETE SUCCESSFUL");
	}

	@Then("^the error code (\\d+) is returned, as this entry does not exist anymore$")
	public void the_error_code_is_returned_as_this_entry_does_not_exist_anymore(int arg1)
	{
		String id = "7";
		Response response = request.get("http://10.0.10.10:9966/petclinic/api/owners/" + id);
		System.out.println("PRE-STATUS CODE");
		response.then().statusCode(404);
		response.prettyPrint();
		System.out.println("GET ONE SUCCESSFUL");
	}
}
