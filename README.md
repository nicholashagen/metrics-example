Metrics Example with Spring Boot
===============

This code base is an example of using CodaHale Metrics (fka Yammer Metrics) [http://metrics.codahale.com] and Spring Boot [http://projects.spring.io/spring-boot/].

# Running the Example

1. Clone or fork the repository locally
2. Run ``gradlew runJar`` on *nix/Mac or ``gradlew.bat runJar`` on Windows
3. Open browser to http://localhost:8080/test/api

# About the Example

This uses Spring Boot to bootstrap the Web Application using embedded Jetty.  This happens in the ``com.sample.metrics.Application`` class.  This class also contains the ``@EnableMetrics`` annotation used to enable the Metrics plugin for Spring.  We also expose the ``MetricRegistry`` using a variety of other plugins and configure it using a JMX reporter. Using this plugin we can now simply add ``@Timed`` to any public Spring bean method and automatically create a timer that wraps the method.  The ``RestProvider`` and ``TestController`` provide examples of this.  The ``RestProvider`` is used with an ``InstrumentedHttpClient`` to automatically instrument the Apache HTTP Client used to fetch API responses.  The ``TestController`` is a simple Spring MVC endpoint to test everything.
