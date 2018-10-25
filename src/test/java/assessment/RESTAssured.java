package assessment;

import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// import com.qa.Constants;
// import com.qa.restassuredtest.Constants;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

// @SuppressWarnings("unused")
public class RESTAssured
{
	
	RequestSpecification request = RestAssured.given();
	static ExtentReports extent;
	ExtentTest test;
	
	@Before
	public void setup()
	{
		extent = new ExtentReports("C:\\Users\\Admin\\Desktop\\Assessment - MASTER FILES\\Selenium_Report.html", true);
	}
	
	@Test
	public void getMethods()
	{
	test = extent.startTest("Access test (1) initialised");
	test.log(LogStatus.INFO, "Pet clinic owner database access");
	Response response = request.get("http://10.0.10.10:9966/petclinic/api/owners");
	System.out.println("PRE-STATUS CODE");
	response.then().statusCode(200);
	response.prettyPrint();
	System.out.println("GET ALL SUCCESSFUL");
	
	extent.endTest(test);
	}
	
	@After
	public void teardown()
	{
		extent.flush();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void postMethod()
	{
	test = extent.startTest("Access test (2) initialised");
	test.log(LogStatus.INFO, "New entry post");
	request.header("Content-Type", "application/json;charset=UTF-8");
	JSONObject ownerPost = new JSONObject();
	ownerPost.put("address", "425 Wayne Street");
	ownerPost.put("city", "Los Angeles");
	ownerPost.put("firstName", "J");
	ownerPost.put("id", "19");
	ownerPost.put("lastName", "Dudeson");
	ownerPost.put("pets", "koala");
	ownerPost.put("telephone", "01758766966");
	
	request.body(ownerPost);
	
	Response response = request.post("http://10.0.10.10:9966/petclinic/api/owners");
	System.out.println("PRE-STATUS CODE");
	response.then().statusCode(201);
	response.prettyPrint();
	System.out.println("POST SUCCESSFUL");
	
	extent.endTest(test);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void putMethod()
	{
	test = extent.startTest("Access test (3) initialised");
	test.log(LogStatus.INFO, "New entry edit");
	request.header("Content-Type", "application/json;charset=UTF-8");
	JSONObject ownerPut = new JSONObject();
	@SuppressWarnings("unused")
	Response putthing = request.put("http://10.0.10.10:9966/petclinic/api/owners/19");
	ownerPut.put("address", "426 Wayne Street");
	ownerPut.put("city", "London");
	ownerPut.put("firstName", "Jacobby");
	ownerPut.put("id", "19");
	ownerPut.put("lastName", "Dudeson");
	ownerPut.put("pets", "it's not a koala, it's a snake!");
	ownerPut.put("telephone", "01749876967");
	request.body(ownerPut);
	Response putthing2 = request.put("http://10.0.10.10:9966/petclinic/api/owners/19");
	System.out.println("PRE-STATUS CODE");
	putthing2.then().statusCode(201);
	putthing2.prettyPrint();
	System.out.println("PUT SUCCESSFUL");
	
	extent.endTest(test);
	}
	
	@Test
	public void deleteMethod()
	{
	test = extent.startTest("Access test (4) initialised");
	test.log(LogStatus.INFO, "New entry deletion");
	Response Delete3 = request.delete("http://10.0.10.10:9966/petclinic/api/owners/19");
	System.out.println("PRE-STATUS CODE");
	Delete3.then().statusCode(204);
	Delete3.prettyPrint();
	System.out.println("DELETE SUCCESSFUL");
	
	extent.endTest(test);
	}
	
	@Test
	// this final test exists basically to confirm that the file we have just deleted is definitely gone forever.
	// it is successful if we receive error code 404 back.
	// string id no. here should always be equal to id used in the delete method test above.
	public void getOneMethod()
	{
	test = extent.startTest("Access test (5) initialised");
	test.log(LogStatus.INFO, "Confirmation that the new entry has been deleted");
	String id = "19";
	Response response = request.get("http://10.0.10.10:9966/petclinic/api/owners/" + id);
	System.out.println("PRE-STATUS CODE");
	response.then().statusCode(404);
	response.prettyPrint();
	System.out.println("GET ONE SUCCESSFUL");
	
	extent.endTest(test);
	}
}
