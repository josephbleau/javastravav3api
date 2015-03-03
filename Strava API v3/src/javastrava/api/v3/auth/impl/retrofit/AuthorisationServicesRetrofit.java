package javastrava.api.v3.auth.impl.retrofit;

import javastrava.api.v3.auth.model.TokenResponse;
import javastrava.api.v3.service.exception.BadRequestException;
import javastrava.api.v3.service.exception.UnauthorizedException;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * <p>
 * Retrofit implementation of the Strava REST interface for authorisation
 * </p>
 *
 * @author Dan Shannon
 *
 */
public interface AuthorisationServicesRetrofit {
	/**
	 * @see javastrava.api.v3.auth.AuthorisationServices#tokenExchange(java.lang.Integer, java.lang.String, java.lang.String)
	 * 
	 * @param clientId
	 *            application's ID, obtained during registration
	 * @param clientSecret
	 *            application's secret, obtained during registration
	 * @param code
	 *            authorisation code
	 * @return Returns an access_token and a detailed representation of the current athlete.
	 * @throws BadRequestException Where the request does not contain all the required information
	 * @throws UnauthorizedException If client secret is invalid
	 */
	@FormUrlEncoded
	@POST("/oauth/token")
	public TokenResponse tokenExchange(@Field("client_id") final Integer clientId, @Field("client_secret") final String clientSecret,
			@Field("code") final String code) throws BadRequestException, UnauthorizedException;
}
