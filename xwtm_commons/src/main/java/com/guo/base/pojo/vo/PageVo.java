package com.guo.base.pojo.vo;

import com.guo.util.ConstantUtil;

import java.io.Serializable;
import java.util.List;

/**
 * 类描述：
 *
 * @ClassName pageVo
 * @Description TODO
 * @Author 郭佳
 * @Date 2021/3/20 19:48
 * @Version 1.0
 */
public class PageVo<E> implements Serializable {
	private static final long serialVersionUID = 5399920481292148416L;
	private Integer pageNum;                 //当前页数
	private Integer pageSize;                //每页显示数量
	private List<E> lists;                   //分页集合
	private Integer totalpage;               //总页数
	private Long totalCount;                 //总数量

	public PageVo(Integer pageNum, Integer pageSize) {
		if (pageNum != null && pageNum > 0){
			this.pageNum = pageNum;
		} else {
			this.pageNum = ConstantUtil.PAGE_NUM;
		}

		if (pageSize != null && pageSize > 0){
			this.pageSize = pageSize;
		} else {
			this.pageSize = ConstantUtil.PAGE_SIZE;
		}
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<E> getLists() {
		return lists;
	}

	public void setLists(List<E> lists) {
		this.lists = lists;
	}

	public Integer getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(Integer totalpage) {
		this.totalpage = totalpage;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
}