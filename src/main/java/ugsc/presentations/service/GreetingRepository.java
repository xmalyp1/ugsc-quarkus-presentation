package ugsc.presentations.service;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.smallrye.common.constraint.NotNull;
import ugsc.presentations.model.Greeting;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class GreetingRepository implements PanacheRepository<Greeting> {

    public List<Greeting> findByUser(@NotNull String user){
        return find("user",user).list();
    }

}
