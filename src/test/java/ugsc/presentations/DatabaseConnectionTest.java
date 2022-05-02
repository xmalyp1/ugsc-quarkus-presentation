package ugsc.presentations;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ugsc.presentations.model.Greeting;
import ugsc.presentations.service.GreetingService;

import javax.inject.Inject;

@QuarkusTest
public class DatabaseConnectionTest {

    @Inject
    GreetingService greetingService;

    @TestTransaction
    @Test
    public void testPersistGreeting_failOtherwise(){
        Greeting greeting = new Greeting("Test Greeting rolled back","Patrik M");
        greeting.persist();
        Assertions.assertTrue(greeting.isPersistent());
    }

    @Test
    public void testFetchGreeting_failOtherwise(){
        Assertions.assertTrue(greetingService.getGreetings().isEmpty());
    }

}
