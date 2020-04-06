package com.mingqian.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: mingqian
 * @DATE: 2020/4/6 10:03
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_mingqian",
                r -> r.path("/guonei")
                        .uri("https://news.baidu.com/guinie")).build();

        return routes.build();

        // http://localhost:9527/guonei (guonei是访问的uri)
    }

    @Bean
    public RouteLocator customerRouteLocator2(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_mingqian2",
                r -> r.path("/game")
                        .uri("https://news.baidu.com/game")).build();

        return routes.build();

        // http://localhost:9527/game (game是访问的uri)
    }
}
