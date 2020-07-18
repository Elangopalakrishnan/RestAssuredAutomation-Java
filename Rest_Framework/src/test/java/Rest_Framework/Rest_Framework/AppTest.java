package Rest_Framework.Rest_Framework;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
/**
 * RestApi test for simple App.
 */
public class AppTest 
{
    /**
     * This test will get the Heart beat of the application
     * And healcheck of the Application Components
     *
     * HTTP Method - GET
     */
	
	@Test
	public void test_GetHeartbeat()
	{
		given()
		.when()
		.get("https://restapifortesting.getsandbox.com:443/heartbeat")
		.then()
		.assertThat()
		.contentType("application/json")
		.and()
		.statusCode(200)
		.and()
		.body("status",equalTo("Success") );
	}	
	
	@Test
	public void test_GetHealcheck()
	{	
		given()
		.when()
		.get("https://restapifortesting.getsandbox.com:443/healthcheck")
		.then()
		.assertThat()
		.contentType("application/json")
		.and()
		.statusCode(200)
		.and()
		.body("Application.UI", equalTo("Healthy"))
		.and()
		.body("Application.Connectors", equalTo("Healthy"))
		.and()
		.body("Application.WebServices", equalTo("Healthy"))
		.and()
		.body("Application.DBs", equalTo("Healthy"));	
	}	
}
