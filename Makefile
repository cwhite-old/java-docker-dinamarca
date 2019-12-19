APP_NAME=dinamarca-services
ENVIRONMENT=local
SPRING_OPTS="-Dspring.profiles.active=${ENVIRONMENT}"

run: stop build-application build-docker start open

build-application:
	./gradlew build

build-docker:
	export ENVIRONMENT="$(ENVIRONMENT)"; \
	export SPRING_OPTS="${SPRING_OPTS}"; \
	docker-compose build

start:
	export ENVIRONMENT="$(ENVIRONMENT)"; \
	export SPRING_OPTS="${SPRING_OPTS}"; \
	docker-compose up -d

stop:
	docker-compose down

open:
	docker exec -it $(APP_NAME) touch /var/log/dinamarca-services/dinamarca-services.log
	docker exec -it $(APP_NAME) tail -f /var/log/dinamarca-services/dinamarca-services.log
