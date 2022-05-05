package ugsc.presentations;

import io.quarkus.logging.Log;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.*;
import ugsc.presentations.model.Greeting;
import ugsc.presentations.service.GreetingService;

import javax.inject.Inject;

@QuarkusTest
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class DatabaseConnectionTest {

    @Inject
    GreetingService greetingService;

    @TestTransaction
    @Test
    @Order(value = 1)
    public void testCreateGreeting_failOtherwise(){
        Greeting greeting = new Greeting("Test Greeting rolled back","Patrik M");
        greeting.persist();
        Assertions.assertTrue(greeting.isPersistent());
        Log.info("Persisted entity in test, but rollback is performed");
    }

    @Test
    @Order(value = 2)
    public void testFetchGreeting_failOtherwise(){
        Assertions.assertTrue(greetingService.getGreetings().isEmpty());
        Log.info("Empty DB.");
    }

}
