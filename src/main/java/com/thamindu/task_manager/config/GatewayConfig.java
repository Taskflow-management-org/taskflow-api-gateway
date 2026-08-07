package com.thamindu.task_manager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
import static org.springframework.cloud.gateway.server.mvc.predicate.GatewayRequestPredicates.path;


@Configuration
public class GatewayConfig {

    @Bean
    public RouterFunction<ServerResponse> userServiceRoute(){
      return route("user-service")
              .route(path("/api/v1/auth/**"), http("http://localhost:8081"))
              .build();
    }

    @Bean
    public RouterFunction<ServerResponse> taskServiceRoute(){
        return route("task-service")
                .route(path("/api/v1/task/**"), http("http://localhost:8082"))
                .build();
    }

}
