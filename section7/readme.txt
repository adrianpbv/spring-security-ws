** Section 7 **
Notes:
1. Accept only https traffic using Spring Security
See: ProjectSecurityProdConfig.java -> .requiresChannel(rcc -> rcc.anyRequest().requiresSecure())

2. Exception Handling in Spring Boot Security
See:
CustomAccessDeniedHandler.java
ProjectSecurityProdConfig.java -> .exceptionHandling(ehc -> ehc.accessDeniedHandler(new CustomAccessDeniedHandler()))

3. Define custom authentication entry point
- To handle the 401 related exceptions.  It is going to help to send your own custom JSON response
in case of httpBasic (no url with login or error page).
- For the normal UI login flow we don't have to implement these kind of entry points.
- Check subsection # where a LoginURLAuthenticationEntryPoint is used with a custom html page.
See:
CustomBasicAuthenticationEntryPoint.java
ProjectSecurityProdConfig.java -> .exceptionHandling(ehc -> ehc.authenticationEntryPoint(new CustomBasicAuthenticationEntryPoint()))

Error Code:
401 - Unauthorized
403 - Forbidden

4. Define CustomAccessDeniedHandler
- Useful for Rest APIs, similar to the CustomBasicAuthenticationEntryPoint where you define the Json response..
 See:
CustomAccessDeniedHandler.java
ProjectSecurityProdConfig.java -> .exceptionHandling(ehc -> ehc.accessDeniedHandler(new CustomAccessDeniedHandler()))

Exception Handling in Spring Security framework
Base: ExceptionTranslationFilter
AuthenticationException -> AuthenticationEntryPoint
AccessDeniedException -> AccessDeniedHandler

5. Sessions, max concurrent sessions
The user is limited to a number of sessions and the login is not allowed after the number of session have reached the limit.
Add method expiredUrl("/expiredUrl") to show the user about the number of concurrent session they can have.
Add "/expiredUrl" and "invalidSession" to permitAll()
See: ProjectSecurityProdConfig.java -> http.sessionManagement(smc -> smc.invalidSessionUrl("/invalidSession").maximumSessions(1).maxSessionsPreventsLogin(true))

6. Session Fixation Attack protection with Spring Security
See: ProjectSecurityProdConfig.java -> .sessionManagement ((session) → session
                                       .sessionFixation((sessionFixation) → sessionFixation.newSession());
by default is changeSessionId

7. Authentication Events:
Create a bean to react when an authentication event triggers.
@EventListener onSuccess and onFailure
DefaultAuthenticationEventPublisher is responsible of triggering the authentication events.
See: AuthenticationEvents.java

***********
Form Login Configurations for MVC or monolithic apps
Define html pages. See project eazySchoolEnd
ProjectSecurityConfig.java
.formLogin(flc -> flc.loginPage("/login")
                        .usernameParameter("userid")
                        .passwordParameter("secretPwd")
                        .defaultSuccessUrl("/dashboard")
                        .failureUrl("/login?error=true")
                        .successHandler(authenticationSuccessHandler)
                        .failureHandler(authenticationFailureHandler))
                .logout(loc -> loc.logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).clearAuthentication(true)
                        .deleteCookies("JSESSIONID"))

See how Spring MVC communicate with the view. usernameParameter is taken on the html code.
Perform logic to hide views when the user is authenticated.



















