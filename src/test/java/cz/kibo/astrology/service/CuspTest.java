package cz.kibo.astrology.service;

import static junit.framework.TestCase.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import spark.Spark;

public class CuspTest {
	
	@BeforeClass
	public static void beforeClass() {
		API newRoutes = new API();
        newRoutes.setupEndpoints();
		
		Spark.awaitInitialization();
	}
		 
	@AfterClass
	public static void afterClass() {
	    Spark.stop();
	}
		
	@Test
	public void corruptedJSON(){
		String reguestJSON = "}";
		
		URLResponse res = new URLResponse("POST", API.API_CONTEXT +"/cusps", reguestJSON);
		
		assertEquals(200, res.getStatus());
		assertEquals( "application/json", res.getHeaders().get("Content-Type").get(0));		
		assertEquals("{\"error\":\"A JSONObject text must begin with '{' at 1 [character 2 line 1]\"}", res.getBody());	
	}
	
	@Test
    public void cuspsEmptyTopo(){
		String reguestJSON = "{\"event\":\"20120710160000\", \"houses\":\"Placidus\"}";
		
		URLResponse res = new URLResponse("POST", API.API_CONTEXT +"/cusps", reguestJSON);
					
		assertEquals(200, res.getStatus());
		assertEquals( "application/json", res.getHeaders().get("Content-Type").get(0));		
		assertEquals("{\"error\":\"Property 'topo' not found.\"}", res.getBody());					
	}
	
	@Test
    public void cuspsEmptyHouses(){
		String reguestJSON = "{\"event\":\"20120710160000\", \"topo\":[1.2,2.3,3.3]}";
		
		URLResponse res = new URLResponse("POST", API.API_CONTEXT +"/cusps", reguestJSON);
					
		assertEquals(200, res.getStatus());
		assertEquals( "application/json", res.getHeaders().get("Content-Type").get(0));		
		assertEquals("{\"error\":\"Property 'houses' not found.\"}", res.getBody());					
	}
	
	@Test
    public void cuspsIncorrectHouses(){
		String reguestJSON = "{\"event\":\"20120710160000\", \"topo\":[1.2,2.3,3.3], \"houses\":\"Pla\"}";
		
		URLResponse res = new URLResponse("POST", API.API_CONTEXT +"/cusps", reguestJSON);
					
		assertEquals(200, res.getStatus());
		assertEquals( "application/json", res.getHeaders().get("Content-Type").get(0));		
		assertEquals("{\"error\":\"Unknown houses system: Pla\"}", res.getBody());					
	}
	
	@Test
    public void cuspsRequest(){
		String reguestJSON = "{\"event\":\"20120710160000\", \"topo\":[1.2,2.3,3.3], \"houses\":\"Placidus\"}";
		
		URLResponse res = new URLResponse("POST", API.API_CONTEXT +"/cusps", reguestJSON);
					
		assertEquals(200, res.getStatus());
		assertEquals( "application/json", res.getHeaders().get("Content-Type").get(0));		
		// Cusps for topo [1.2, 2.3, 3.3]. These values changed when parseTopo stopped
		// truncating coordinates to whole degrees, which had turned this into [1, 2, 3].
		assertEquals("{\"cusps\":[260.0725906560187,288.0490414266004,317.521378760032,349.3166151623188,21.70842912053911,52.08708445916466,80.07259065601869,108.04904142660041,137.521378760032,169.31661516231878,201.7084291205391,232.08708445916469]}", res.getBody());
	}
	
	@Test
    public void cuspsRequestSidereal(){
		String reguestJSON = "{\"event\":\"20120710160000\", \"topo\":[1.2,2.3,3.3], \"houses\":\"Placidus\", \"zodiac\":\"Krishnamurti\"}";
		
		URLResponse res = new URLResponse("POST", API.API_CONTEXT +"/cusps", reguestJSON);
					
		assertEquals(200, res.getStatus());
		assertEquals( "application/json", res.getHeaders().get("Content-Type").get(0));		
		assertEquals("{\"cusps\":[236.13268761974527,264.109138390327,293.5814757237586,325.3767121260454,357.7685260842657,28.147181422891244,56.132687619745276,84.109138390327,113.5814757237586,145.37671212604536,177.7685260842657,208.14718142289126]}", res.getBody());
	}
	
	@Test
    public void cuspsRequestBadSidereal(){
		String reguestJSON = "{\"event\":\"20120710160000\", \"topo\":[1.2,2.3,3.3], \"houses\":\"Placidus\", \"zodiac\":\"Krishnamurto\"}";
		
		URLResponse res = new URLResponse("POST", API.API_CONTEXT +"/cusps", reguestJSON);
					
		assertEquals(200, res.getStatus());
		assertEquals( "application/json", res.getHeaders().get("Content-Type").get(0));		
		assertEquals("{\"error\":\"Unknown sidereal mode: Krishnamurto\"}", res.getBody());					
	}
	
	@Test
    public void nonExistingData(){
		String reguestJSON = "{\"event\":\"99990710160000\", \"topo\":[1.2,2.3,3.3], \"houses\":\"Placidus\"}";
		
		URLResponse res = new URLResponse("POST", API.API_CONTEXT +"/cusps", reguestJSON);
					
		assertEquals(200, res.getStatus());
		assertEquals( "application/json", res.getHeaders().get("Content-Type").get(0));		
		assertEquals("{\"cusps\":[265.1769853669326,293.4294436604981,323.3771666908637,355.3772533725829,27.430193453993354,57.32957433238698,85.17698536693263,113.42944366049812,143.3771666908637,175.3772533725829,207.43019345399335,237.329574332387]}", res.getBody());
	}

}
