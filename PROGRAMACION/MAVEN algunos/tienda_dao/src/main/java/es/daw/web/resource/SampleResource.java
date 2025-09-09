package es.daw.web.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import static jakarta.ws.rs.core.MediaType.TEXT_PLAIN;

@Path("sample")
public class SampleResource{

    @GET
    @Produces(TEXT_PLAIN)
    public Response message() {
        return Response.ok("Hi Jakarta EE 9").build();
    }

}