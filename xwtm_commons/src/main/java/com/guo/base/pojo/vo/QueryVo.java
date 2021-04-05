package com.guo.base.pojo.vo;

import java.io.Serializable;

/**
 * 类描述：
 *
 * @ClassName QueryVo
 * @Description 分页条件查询视图对象
 * @Author 郭佳
 * @Date 2021/3/21 11:05
 * @Version 1.0
 */
public class QueryVo<E> implements Serializable {
	private static final long serialVersionUID = -1970812223706038538L;
	private E query;                          //查询条件
	private PageVo<E> pageVo;                 //分页视图

	public QueryVo(E query, PageVo<E> pageVo) {
		this.query = query;
		this.pageVo = pageVo;
	}

	public E getQuery() {
		return query;
	}

	public void setQuery(E query) {
		this.query = query;
	}

	public PageVo<E> getPageVo() {
		return pageVo;
	}

	public void setPageVo(PageVo<E> pageVo) {
		this.pageVo = pageVo;
	}
}