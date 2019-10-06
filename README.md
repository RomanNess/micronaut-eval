# micronaut-eval
Me testing out micronaut 1.2.3 as a alternative to Spring Boot for lightweight services.

The focus is to evaluate if ...
1. I can setup a modern microservice with typical requirements.
2. I can solve the typical problems that I already have a solution for in Spring Boot.

## Requirements
- [x] bootstrap new projects easily 
    - install `mn` cli, e.g. with `skdman`; then run `mn create-app your-app-name`
- [x] build with Maven 
    - `--build maven` flag for `mn` 
- [x] json support 
    - works out-of-the-box with Jackson
- [x] logging 
    - works out-of-the-box with logback
- [ ] assertj assertions
- [ ] lombok
- [ ] more requirements tbd

## Problems
- [ ] integration tests for rest endpoints (mockMvc style)
  - minimal solution with micronaut HttpClient (out-of-the-box)
  - use `rest-assured` without mockmvc? (provides a convenient DSL & jsonpath matching but has a hamcrest dependency)
  - both solutions require you to handle rollback/cleanup after calling endpoints that write data 
- [ ] more problems tbd