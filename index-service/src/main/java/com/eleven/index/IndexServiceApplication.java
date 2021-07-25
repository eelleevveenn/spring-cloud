package com.eleven.index;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class IndexServiceApplication {

    /**
     * 使用Spring提供的RestTemplate发送Http请求
     *      @Bean: 将RestTemplate注册到Spring容器进行管理
     *      @LoadBalanced: Ribbon提供的负载均衡的注解
     *          -- Ribbon的作用：（1）服务调用;（2）负载均衡;
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(IndexServiceApplication.class, args);
    }

}
