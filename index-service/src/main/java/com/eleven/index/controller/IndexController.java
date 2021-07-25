package com.eleven.index.controller;

import com.alibaba.fastjson.JSON;

import com.eleven.index.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class IndexController {
    // 服务间Http调用工具
    @Autowired
    private RestTemplate restTemplate;
    // Eureka元数据获取工具
    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * @Description:
     *      使用RestTemplate调用远程微服务;
     *          -- 该方式不能使用@LoadBalanced声明RestTemplate,否则会报错.
     *      通过IP/PORT的形式获取远程微服务;
     * @Author: Eleven
     * @Date: 2021/7/24 0:51
     */
    @GetMapping("/")
    public String query() {
        // 从Eureka注册中心获取test-service服务
        List<ServiceInstance> testServiceList = discoveryClient.getInstances("test-service");
        ServiceInstance testService = testServiceList.get(0);
        String urlService = "http://" + testService.getHost() + ":" + testService.getPort() + "/test/service/test/query";
        return restTemplate.getForObject(urlService, String.class);
    }

    /**
     * @Description:
     *      使用Ribbon结合RestTemplate调用远程微服务;
     *          -- 使用@LoadBalanced声明RestTemplate.
     *      通过服务名称获取远程微服务;
     *          -- 如果Eureka注册中心注册了多个服务名称相同的微服务,采用该方式会根据负载均衡选择合适的微服务进行调用.
     * @Author: Eleven
     * @Date: 2021/7/24 0:55
     */
    @GetMapping("/query/ribbon")
    public String queryWithRiboon() {
        // 从Eureka注册中心获取test-service服务
        List<ServiceInstance> testServiceList = discoveryClient.getInstances("test-service");
        ServiceInstance testService = testServiceList.get(0);
        String application = "http://" + testService.getServiceId() + "/test/service/test/query";
        return restTemplate.getForObject(application, String.class);
    }

}
