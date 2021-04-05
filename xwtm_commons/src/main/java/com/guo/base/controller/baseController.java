package com.guo.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 类描述：
 *
 * @ClassName baseController
 * @Description TODO
 * @Author 郭佳
 * @Date 2021/3/20 19:46
 * @Version 1.0
 */
@Controller
public class baseController {
	@Autowired
	protected HttpServletRequest request;
	@Autowired
	protected HttpServletResponse response;
	@Autowired
	protected HttpSession session;
}