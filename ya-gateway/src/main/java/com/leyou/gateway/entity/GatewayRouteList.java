package com.leyou.gateway.entity;

import lombok.Data;
import org.springframework.cloud.gateway.route.RouteDefinition;

import java.util.List;

/**
 * 路由定义模型
 * @date 2019-03-23 21:26:35
 */
@Data
public class GatewayRouteList {
private static final long serialVersionUID = 1L;

	List<RouteDefinition> routes;
  
}
