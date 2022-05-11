//package com.ya.gateway.init;
//
//import java.util.List;
//import java.util.Properties;
//import javax.annotation.PostConstruct;
//
//import com.ya.gateway.common.GatewayConstant;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
//import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
//import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
//import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.TypeReference;
//import com.alibaba.nacos.api.PropertyKeyConst;
//
//import static com.ya.gateway.common.GatewayConstant.CONFIG_DATA_ID_GATEWAY_SENTINEL;
//import static com.ya.gateway.common.GatewayConstant.CONFIG_GROUP;
//
///**
// * sentinel数据持久化到nacos
// */
//@Configuration
//public class SentinelDataSourceNacos {
//
//	// nacos server addr
//	@Value("${spring.cloud.nacos.config.server-addr}")
//	private String serverAddr;
//
//	// nacos group
//	//private static final String groupId = "DEFAULT_GROUP";
//
//	// 如果更改为 true，则应配置 NACOS_NAMESPACE_ID
//	private final static boolean isDemoNamespace = false;
//	//如果要使用命名空间，请填写命名空间 ID。例如：
//	private static final String NACOS_NAMESPACE_ID = "${namespace}";
//
//	@PostConstruct
//	public void initRules() {
//		if (isDemoNamespace) {
//			loadMyNamespaceRules();
//		} else {
//			loadRules();
//		}
//	}
//
//	private void loadRules() {
//		ReadableDataSource<String, List<FlowRule>> flowRuleDataSource = new NacosDataSource<>(serverAddr, CONFIG_GROUP,
//				CONFIG_DATA_ID_GATEWAY_SENTINEL, source -> JSON.parseObject(source, new TypeReference<List<FlowRule>>() {
//				}));
//		FlowRuleManager.register2Property(flowRuleDataSource.getProperty());
//	}
//
//	private void loadMyNamespaceRules() {
//		Properties properties = new Properties();
//		properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
//		properties.put(PropertyKeyConst.NAMESPACE, NACOS_NAMESPACE_ID);
//
//		ReadableDataSource<String, List<FlowRule>> flowRuleDataSource = new NacosDataSource<>(properties, CONFIG_GROUP,
//				CONFIG_DATA_ID_GATEWAY_SENTINEL, source -> JSON.parseObject(source, new TypeReference<List<FlowRule>>() {
//				}));
//		FlowRuleManager.register2Property(flowRuleDataSource.getProperty());
//	}
//
//}