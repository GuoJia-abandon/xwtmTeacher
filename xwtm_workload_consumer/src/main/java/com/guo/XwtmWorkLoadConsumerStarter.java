package com.guo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 类描述：
 *
 * @ClassName XwtmSystemConsumerStarter
 * @Description TODO
 * @Author 郭佳
 * @Date 2021/3/20 22:17
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class XwtmWorkLoadConsumerStarter {
	public static void main(String[] args) {
		SpringApplication.run(XwtmWorkLoadConsumerStarter.class,args);
	}
}