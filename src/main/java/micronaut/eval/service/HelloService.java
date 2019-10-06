package micronaut.eval.service;

import micronaut.eval.model.HelloResponse;

import javax.inject.Singleton;

@Singleton
public class HelloService {

    public HelloResponse hello(String name) {
        return new HelloResponse(String.format("Hello %s", name));
    }
}
