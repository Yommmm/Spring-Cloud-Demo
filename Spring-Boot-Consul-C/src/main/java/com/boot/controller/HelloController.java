package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/v1/consul/hello")
public class HelloController {
	
	@Autowired
    private LoadBalancerClient loadBalancer;
	
    @Autowired
    private DiscoveryClient discoveryClient;

	/**
	 * 获取所有服务
	 */
    @RequestMapping("/services")
    public Object services() {
        return discoveryClient.getInstances("Spring-Boot-Consul-P");
    }

    /**
     * 从所有服务中选择一个服务（轮询）
     */
    @RequestMapping("/discover")
    public Object discover() {
        return loadBalancer.choose("Spring-Boot-Consul-P").getUri().toString();
    }
    
    @RequestMapping("/call")
    public String call() {
        ServiceInstance serviceInstance = loadBalancer.choose("Spring-Boot-Consul-P");
        System.out.println("服务地址：" + serviceInstance.getUri());
        System.out.println("服务名称：" + serviceInstance.getServiceId());

        String callServiceResult = new RestTemplate().getForObject(serviceInstance.getUri().toString() + "/v1/consul/hello", String.class);
        System.out.println(callServiceResult);
        return callServiceResult;
    }

	@GetMapping
	public String hello() {
		return "Hello Consul Application";
	}
	
}
