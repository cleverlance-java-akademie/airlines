docker-build:
	docker rmi airlines --force
	chmod +x ./mvnw
	./mvnw install
	docker build -t airlines -f Dockerfile .
