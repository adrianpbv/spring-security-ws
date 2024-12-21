package com.adrianj.springsec11.filters;

import com.adrianj.springsec11.constants.ApplicationConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

// TODO 6 Create JWTTokenValidatorFilter, to verify the JWT token and inform Spring Security that authentication is successful
//don't try to perform the authentication one more time.
public class JWTTokenValidatorFilter extends OncePerRequestFilter {
    /**
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // TODO 9. Verify the JWT token is valid
        String jwt = request.getHeader(ApplicationConstants.JWT_HEADER);
        if (null != jwt) { // if the header where the JWT token is stored is not null
            try {
                Environment env = getEnvironment();
                if (null != env) {
                    String secret = env.getProperty(ApplicationConstants.JWT_SECRET_KEY,
                            ApplicationConstants.JWT_SECRET_DEFAULT_VALUE);
                    SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8)); // generate the secret key
                    if (null != secretKey) {
                        Claims claims = Jwts.parser().verifyWith(secretKey)
                                .build()
                                .parseSignedClaims(jwt)// returns an exception if the token is invalid
                                .getPayload();
                        String username = String.valueOf(claims.get("username"));
                        String authorities = String.valueOf(claims.get("authorities")); // authorities is a comma separated string, next use commaSeparatedStringToAuthorityList to get objects GrantedAuthority
                        Authentication authentication = new UsernamePasswordAuthenticationToken(username, null,
                                AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));// by creating this object the authentication is completed for Spring, see its constructor: super.setAuthenticated(true);
                        SecurityContextHolder.getContext().setAuthentication(authentication); // pass in the authentication object so Spring Security can use now that the user is authenticated
                    }
                }

            } catch (ExpiredJwtException expiredJwtException) {
                throw new RuntimeException("Expired JWT Token"); // return CustomException that can be used on the UI
            } catch (Exception exception) {
                throw new BadCredentialsException("Invalid Token received!");
            }
        }
        filterChain.doFilter(request, response); // invoke the next filter inside the SecurityFilterChain
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return request.getServletPath().equals("/user"); // to not execute the filter when the user is trying to log-in
    }

}
