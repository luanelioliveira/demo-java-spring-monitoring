test:
	mvn -B -f pom.xml clean test

build:
	mvn -f pom.xml clean package

run:
	mvn -f pom.xml spring-boot:run

compose-up:
	docker-compose up --build -D

lint:
	mvn fmt:format -f pom.xml

lint-validate:
	mvn fmt:check -f pom.xml
