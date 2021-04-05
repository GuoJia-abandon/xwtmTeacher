package com.guo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 类描述：
 *
 * @ClassName XwtmSystemProviderStarter
 * @Description TODO
 * @Author 郭佳
 * @Date 2021/3/20 20:49
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.guo.*.dao")
public class XwtmSystemProviderStarter {
	public static void main(String[] args) {
		SpringApplication.run(XwtmSystemProviderStarter.class,args);
	}
}