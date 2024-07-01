package stepDefination;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;

import pojo.Location;
import static org.junit.Assert.*;
import pojo.SerializationPayload;
import resources.APIresource;
import resources.TestDataBuild;
import resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class stepDefination extends Utils {
	ResponseSpecification resres;
	RequestSpecification response;
	static String Place_id;
	
	Response response1;
	TestDataBuild data =new TestDataBuild();
	
	@Given("Add place payload with {string} {string} {string}")
	public void Add_place_payload_with(String name, String Language, String Address) throws IOException {

		
		
	 response= given().spec(RequestSpecification())
				.body(data.AddplacePayload(name, Language, Address));
	}
	
	@When("user calls {string} with {string} https request")
	public void user_calls_with_post_https_request(String resource, String method) {
		//constructor will be called with value of resource which you passed on feature file.
		
		APIresource resoureAPI	=APIresource.valueOf(resource);
		System.out.println(resoureAPI.getResource());
		resres= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if (method.equalsIgnoreCase("POST"))
		 response1 =response.when().post(resoureAPI.getResource());
				//.then().spec(resres).extract().response();
		
		else if (method.equalsIgnoreCase("Get"))
			response1 =response.when().get(resoureAPI.getResource());
		
		
	}
	
	@Then("the Api call got success with status code {int}")
	public void the_Api_call_got_success_with_status_code(Integer int1) {
		assertEquals (response1.getStatusCode(), 200);
		
	}
	
	@Then("{string} in response body is {string}")
	public void in_response_body ( String keyvalue, String Expectedvalue)
	{
		
		assertEquals(getJsonPath(response1, keyvalue), Expectedvalue);
		  
		
	}
	
	@Then("verify place_id created maps to {string} using {string} ")
	public void verify_place_id_created_maps_to_using(String Expectedname, String resource) throws IOException {
		Place_id=getJsonPath(response1, "place_id");
		response=given().spec(RequestSpecification()).queryParam("place_id", Place_id);
		user_calls_with_post_https_request(resource,"Get");
		String ActulaName=getJsonPath(response1, "name");
		assertEquals(ActulaName,Expectedname);	
	}
	
@When("Deleteplace payload")
public void Deleteplace_payload() throws IOException {
	response=given().spec(RequestSpecification()).body(data.deleteplacepaylod(Place_id));
	
	
}
	

}
