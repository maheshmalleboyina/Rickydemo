package resources;

public enum APIresource {
	
	AddPalceAPI("/maps/api/place/add/json"),
	getPalceAPI("/maps/api/place/get/json"),
	deletePalceAPI("/maps/api/place/delete/json");
	private String resource;
	
	APIresource(String resource){
		this.resource=resource;
		
	}
	
	public String getResource()
	{
		return resource;
	}

}
