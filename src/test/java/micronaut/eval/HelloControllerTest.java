package micronaut.eval;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.MutableHttpParameters;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import micronaut.eval.model.HelloResponse;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

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

        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Hello Roman");
    }

    @Test
    void helloAnonymous() {
        HttpRequest<String> request = HttpRequest.GET("/hello");
        HelloResponse response = client.toBlocking().retrieve(request, Argument.of(HelloResponse.class));

        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Hello anonymous");
    }
}