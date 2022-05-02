package ugsc.presentations.service;

import io.quarkus.logging.Log;
import io.quarkus.panache.common.Sort;
import ugsc.presentations.model.Greeting;
import ugsc.presentations.model.GreetingDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class GreetingService {

    public List<Greeting> getGreetings(){
       Log.debug("Calling get all greeting");
       return Greeting.listAll(Sort.descending("timestamp"));
    }

    @Transactional
    public Greeting createGreeting(GreetingDTO greetingDTO){
        Greeting greeting = new Greeting(greetingDTO.getMessage(),greetingDTO.getUser());
        greeting.persist();
        return greeting;
    }

    public GreetingDTO getLatestResult(){
        return   Greeting.findAll(Sort.descending("timestamp"))
                .project(GreetingDTO.class)
                .firstResultOptional()
                .orElse(null);
    }

}
