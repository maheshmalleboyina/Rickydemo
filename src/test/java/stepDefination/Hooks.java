package stepDefination;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	@Before("deletePalce")
	public void beforedleteScenario() throws IOException {
		//excute only if place id is null
		stepDefination m=new stepDefination();
		
		if(stepDefination.Place_id==null) {
		m.Add_place_payload_with("mahesh", "maha", "make");
		m.user_calls_with_post_https_request("AddPalceAPI", "POST");
		m.verify_place_id_created_maps_to_using("mahesh", "getPalceAPI");
	}}

}
