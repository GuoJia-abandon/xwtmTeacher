package com.guo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 类描述：
 *
 * @ClassName XwtmRegisterCenterStarter
 * @Description 西安文理教师工作量管理系统注册中心
 * @Author 郭佳
 * @Date 2021/3/20 19:32
 * @Version 1.0
 */
@EnableEurekaServer
@SpringBootApplication
public class XwtmRegisterCenterStarter {
	public static void main(String[] args) {
		SpringApplication.run(XwtmRegisterCenterStarter.class,args);
	}
}