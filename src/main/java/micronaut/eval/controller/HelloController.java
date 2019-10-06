package micronaut.eval.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import micronaut.eval.model.HelloResponse;
import micronaut.eval.service.HelloService;

import javax.inject.Inject;

@Controller("/hello")
public class HelloController {

    private final HelloService helloService;

    @Inject
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public HelloResponse hello(@QueryValue(value = "name", defaultValue = "anonymous") String name) {
        return helloService.hello(name);
    }
}