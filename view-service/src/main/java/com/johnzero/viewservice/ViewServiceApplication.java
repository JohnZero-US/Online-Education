package com.johnzero.viewservice;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
//断路器
@EnableHystrix
//断路器监控
//@EnableHystrixDashboard
//@EnableCircuitBreaker
public class ViewServiceApplication {

    /**
     * 刷新远程配置路径: http[s]://{HOSTNAME}:{PORT}/actuator/bus-refresh
     * <p>
     * 断路器监控地址: http[s]://{HOSTNAME}:{PORT}/actuator/hystrix.stream
     */

    public static void main(String[] args) {
        SpringApplication.run(ViewServiceApplication.class, args);
    }


    /**
     * Restful微服务 负载均衡
     *
     * @return
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * @return
     */
    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

}
