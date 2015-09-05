package com.user.authentication;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.user.service.AuthenticationService;

/**
 * Created by ukulkom on 8/31/15.
 */
@Path("/login")
public class AuthenticationResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage(@QueryParam("username") String username, @QueryParam("password") String password) {

        System.out.println(username + " " + password);

        if(username.equals("Omkar") && password.equals("password"))
        {
            return "Success";
        }
        else {
            return "Login failure";
        }
    }

    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces({"application/json", "application/xml", "text/plain"})
    public String authenticateUser(@FormParam("username") String username,
                                   @FormParam("password") String password)
    {
        if(username.equals("Omkar") && password.equals("password"))
        {
            AuthenticationService as = new AuthenticationService();

            as.authenticate();
            return "Success with Post in Resource";
        }
        else {
            return "Login failure with Post";
        }
    }
}