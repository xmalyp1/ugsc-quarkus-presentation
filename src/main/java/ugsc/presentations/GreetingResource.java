package ugsc.presentations;

import io.smallrye.mutiny.Uni;
import ugsc.presentations.model.Greeting;
import ugsc.presentations.model.GreetingDTO;
import ugsc.presentations.service.GreetingService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/greeting")
public class GreetingResource {

    @Inject
    GreetingService greetingService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    /*
    @GET
    @Path("latest")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Greeting> getLatestGreeting(){
        return Uni.createFrom().item(greetingService.getLatestResult());
    }
    */

    @GET
    @Path("latest")
    @Produces(MediaType.APPLICATION_JSON)
    public GreetingDTO getLatestGreeting(){
        return greetingService.getLatestResult();
    }


    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Greeting> getAll(){
        return greetingService.getGreetings();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Greeting generateGreeting(GreetingDTO greetingDTO){
        return greetingService.createGreeting(greetingDTO);
    }
}