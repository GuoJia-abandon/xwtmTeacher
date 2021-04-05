package com.guo.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guo.base.pojo.vo.PageVo;

import java.util.List;

/**
 * 类描述：
 *
 * @ClassName PageUtil
 * @Description 分页工具类
 * @Author 郭佳
 * @Date 2021/3/21 10:58
 * @Version 1.0
 */
public class PageUtil<E> {
	public void parseFromPageInfoToPageVO(List<E> list, PageVo<E> pageVo){
		PageInfo<E> pageInfo = new PageInfo<>(list);
		pageVo.setLists(pageInfo.getList());
		//pageVo.setTotalCount(pageInfo.getTotal());
		pageVo.setTotalpage(pageInfo.getPages());
	}
}