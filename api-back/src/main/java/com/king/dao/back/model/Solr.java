package com.king.dao.back.model;


import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;

import com.king.common.util.MutiSort;

/**
  *该代码由付为地的编码机器人自动生成
  *时间：2017-09-21 13:44:39
*/
public class Solr  extends MutiSort {

    private static final long serialVersionUID = 1L;

    // Fields

    private String id;
    private Integer price;//价格
    private String title;//标题
    private String name;//称呼
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createtime;//创建时间
    
    // Constructors

    /** default constructor */
    public Solr() {
    }

    // Property accessors

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getCreatetime() {
        return this.createtime;
    }

}