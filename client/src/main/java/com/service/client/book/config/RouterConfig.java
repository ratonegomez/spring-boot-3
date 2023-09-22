package com.service.client.book.config;

import com.service.client.book.client.BookClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RouterConfig {

    @Bean
    RouteLocator gateway(RouteLocatorBuilder rlb) {
        return rlb
                .routes()
                .route(rs ->rs.path("/proxy")
                                .filters(fs -> fs
                                        .setPath("/api/books")
                                        .addResponseHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*")
                                        .retry(10)
                                )
                                .uri("http://localhost:8080/")
                )
                .build();
    }

    @Bean
    BookClient client(WebClient.Builder builder) {
        return HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(
                        builder.baseUrl("http://localhost:8080/api/books").build()
                ))
                .build()
                .createClient(BookClient.class);
    }
}
