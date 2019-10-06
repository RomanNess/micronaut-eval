package micronaut.eval;

import micronaut.eval.model.HelloResponse;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.MutableHttpParameters;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class HelloControllerTest {

    @Inject
    @Client("/")
    RxHttpClient client;

    @Test
    void helloRoman() {
        HttpRequest<String> request = HttpRequest.GET("/hello");
        ((MutableHttpParameters) request.getParameters()).add("name", "Roman");
        HelloResponse response = client.toBlocking().retrieve(request, Argument.of(HelloResponse.class));

        assertNotNull(response);
        assertEquals("Hello Roman", response.getMessage());
    }

    @Test
    void helloAnonymous() {
        HttpRequest<String> request = HttpRequest.GET("/hello");
        HelloResponse response = client.toBlocking().retrieve(request, Argument.of(HelloResponse.class));

        assertNotNull(response);
        assertEquals("Hello anonymous", response.getMessage());
    }
}