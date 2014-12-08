package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;

import com.danshannon.strava.api.service.GearServices;
import com.danshannon.strava.api.service.exception.UnauthorizedException;
import com.danshannon.strava.api.service.impl.retrofit.GearServicesImpl;

/**
 * <p>Unit tests for {@link GearServicesImpl}</p>
 * 
 * @author Dan Shannon
 *
 */
public class GearServicesImplTest {
	private static String VALID_TOKEN; 
	private static String INVALID_TOKEN;
	private static String VALID_TOKEN_WITHOUT_WRITE_ACCESS;
	private static final String PROPERTIES_FILE = "test-config.properties";

	/**
	 * <p>Loads the properties from the test configuration file</p>
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Properties properties = TestUtils.loadPropertiesFile(PROPERTIES_FILE);
		VALID_TOKEN = properties.getProperty("test.activityServicesImplTest.validToken");
		INVALID_TOKEN = properties.getProperty("test.activityServicesImplTest.invalidToken");
		VALID_TOKEN_WITHOUT_WRITE_ACCESS = properties.getProperty("test.activityServicesImplTest.validTokenWithoutWriteAccess");
	}
	
	/**
	 * <p>Test we get a {@link GearServicesImpl service implementation} successfully with a valid token</p>
	 * 
	 * @throws UnauthorizedException If token is not valid
	 */
	@Test
	public void testImplementation_validToken() throws UnauthorizedException {
		GearServices service = GearServicesImpl.implementation(VALID_TOKEN);
		assertNotNull("Got a NULL service for a valid token", service);
	}
	
	/**
	 * <p>Test that we don't get a {@link GearServicesImpl service implementation} if the token isn't valid</p>
	 */
	@Test
	public void testImplementation_invalidToken() {
		GearServices service = null;
		try {
			service = GearServicesImpl.implementation(INVALID_TOKEN);
		} catch (UnauthorizedException e) {
			// This is the expected behaviour
		}
		assertNull("Got a service for an invalid token!",service);
	}

	/**
	 * <p>Test that we don't get a {@link GearServicesImpl service implementation} if the token has been revoked by the user</p>
	 */
	@Test
	public void testImplementation_revokedToken() {
		// TODO Not yet implemented
		fail("Not yet implemented");
	}
	
	/**
	 * <p>Test that when we ask for a {@link GearServicesImpl service implementation} for a second time, we get the SAME ONE as the first time (i.e. the caching strategy is working)</p>
	 */
	@Test
	public void testImplementation_implementationIsCached() throws UnauthorizedException {
		GearServices service = GearServicesImpl.implementation(VALID_TOKEN);
		GearServices service2 = GearServicesImpl.implementation(VALID_TOKEN);
		assertEquals("Retrieved multiple service instances for the same token - should only be one",service,service2);
	}
	
	/**
	 * <p>Test that when we ask for a {@link GearServicesImpl service implementation} for a second, valid, different token, we get a DIFFERENT implementation</p>
	 * 
	 * @throws UnauthorizedException Thrown when security token is invalid
	 */
	@Test
	public void testImplementation_differentImplementationIsNotCached() throws UnauthorizedException {
		// TODO Not yet implemented
		fail("Not yet implemented");
	}
	
	// Test cases
	// 1. Valid gear
	// 2. Invalid gear
	// 3. Gear which doesn't belong to the current athlete
	@Test
	public void testGetGear(Integer id) {
		// TODO Not yet implemented
		fail("Not yet implemented");		
	}
}
