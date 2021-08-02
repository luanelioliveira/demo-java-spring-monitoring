# Monitoring Doc

## Prometheus

### Application Properties

Add the properties in `application.yml`
```yaml
management:
  endpoint:
    metrics:
      enabled: true
    prometheus:
      enabled: true
  endpoints:
    web:
      base-path: /management
      exposure:
        include: health, metrics, prometheus
  metrics:
    export:
      prometheus:
        enabled: true
```

### Maven

Add the dependencies in `pom.xml`
```xml
<!-- micrometer -->
<dependency>
  <groupId>io.micrometer</groupId>
  <artifactId>micrometer-registry-prometheus</artifactId>
</dependency>

<!-- prometheus client -->
<dependency>
  <groupId>io.prometheus</groupId>
  <artifactId>simpleclient_hotspot</artifactId>
  <version>0.6.0</version>
</dependency>
```

More info https://github.com/prometheus/client_java

### Docker Compose Template

Create the docker compose file and save as `docker-compose.yml`
```yaml
version: '3.7'
services:
  prometheus:
    image: prom/prometheus:latest
    container_name: prometheus
    volumes:
      - ./prometheus.yml:/etc/prometheus/prometheus.yml
    command:
      - --config.file=/etc/prometheus/prometheus.yml
    ports:
      - "9090:9090"
```

### Configuration Template

Create a prometheus config file and save as `prometheus.yml`
```yaml
global:
  scrape_interval: 15s 
  evaluation_interval: 15s 

scrape_configs:
  - job_name: '<application-name>'
    scrape_interval: 15s
    metrics_path: "/management/prometheus"
    static_configs:
      - targets: ['host.docker.internal:8080']
```

### Run

```bash
$ docker-compose up

# Prometheus is running in http://localhost:9090
```


## Grafana

### Docker Compose Template

Create the docker compose file and save as `docker-compose.yml`
```yaml
version: '3.7'
services:
  grafana:
    image: grafana/grafana:latest
    container_name: grafana
    ports:
      - "3000:3000"
```

### Run

```bash
$ docker-compose up

# Grafana is running in http://localhost:3000
```

### Template

Dashboards
```bash
https://grafana.com/grafana/dashboards
```

Template JVM (Micrometer)
```bash
https://grafana.com/grafana/dashboards/4701
```

In a Spring Boot setting, this could look like this:
```java
@Bean
MeterRegistryCustomizer<MeterRegistry> configurer(
    @Value("${spring.application.name}") String applicationName) {
    return (registry) -> registry.config().commonTags("application", applicationName);
}
```

```yaml
management:
  metrics:
    tags:
      application: ${spring.application.name}
```



How do I import this dashboard?
```
https://grafana.com/docs/grafana/next/dashboards/export-import/
```
