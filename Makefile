
build:
	./mvnw package

package: build
	docker build -t micronaut-eval .

run: package
	docker run --rm -p 8080:8080 micronaut-eval

clean:
	./mvnw clean