package org.mql.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }
//    @Bean
//    RouteLocator routeLocator(RouteLocatorBuilder builder){
//        return builder.routes()
//                .route((r) -> r.path("/departments/**").uri("lb://DEPARTMENT-SERVICE").id("r1"))
//                .route((r) -> r.path("/formations/**").uri("lb://FORMATION-SERVICE").id("r2"))
//                .build();
//    }
    @Bean
    DiscoveryClientRouteDefinitionLocator definitionLocator(
            ReactiveDiscoveryClient reactiveDiscoveryClient,
            DiscoveryLocatorProperties properties){
        return  new DiscoveryClientRouteDefinitionLocator(reactiveDiscoveryClient,properties);
    }
}
