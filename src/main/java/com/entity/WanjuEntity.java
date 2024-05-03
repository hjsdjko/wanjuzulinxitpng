package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 玩具
 *
 * @author 
 * @email
 */
@TableName("wanju")
public class WanjuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WanjuEntity() {

	}

	public WanjuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 玩具编号
     */
    @ColumnInfo(comment="玩具编号",type="varchar(200)")
    @TableField(value = "wanju_uuid_number")

    private String wanjuUuidNumber;


    /**
     * 玩具名称
     */
    @ColumnInfo(comment="玩具名称",type="varchar(200)")
    @TableField(value = "wanju_name")

    private String wanjuName;


    /**
     * 玩具照片
     */
    @ColumnInfo(comment="玩具照片",type="varchar(200)")
    @TableField(value = "wanju_photo")

    private String wanjuPhoto;


    /**
     * 玩具类型
     */
    @ColumnInfo(comment="玩具类型",type="int(11)")
    @TableField(value = "wanju_types")

    private Integer wanjuTypes;


    /**
     * 玩具库存
     */
    @ColumnInfo(comment="玩具库存",type="int(11)")
    @TableField(value = "wanju_kucun_number")

    private Integer wanjuKucunNumber;


    /**
     * 租赁价格/h
     */
    @ColumnInfo(comment="租赁价格/h",type="decimal(10,2)")
    @TableField(value = "wanju_new_money")

    private Double wanjuNewMoney;


    /**
     * 玩具热度
     */
    @ColumnInfo(comment="玩具热度",type="int(11)")
    @TableField(value = "wanju_clicknum")

    private Integer wanjuClicknum;


    /**
     * 玩具介绍
     */
    @ColumnInfo(comment="玩具介绍",type="longtext")
    @TableField(value = "wanju_content")

    private String wanjuContent;


    /**
     * 是否上架
     */
    @ColumnInfo(comment="是否上架",type="int(11)")
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "wanju_delete")

    private Integer wanjuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：玩具编号
	 */
    public String getWanjuUuidNumber() {
        return wanjuUuidNumber;
    }
    /**
	 * 设置：玩具编号
	 */

    public void setWanjuUuidNumber(String wanjuUuidNumber) {
        this.wanjuUuidNumber = wanjuUuidNumber;
    }
    /**
	 * 获取：玩具名称
	 */
    public String getWanjuName() {
        return wanjuName;
    }
    /**
	 * 设置：玩具名称
	 */

    public void setWanjuName(String wanjuName) {
        this.wanjuName = wanjuName;
    }
    /**
	 * 获取：玩具照片
	 */
    public String getWanjuPhoto() {
        return wanjuPhoto;
    }
    /**
	 * 设置：玩具照片
	 */

    public void setWanjuPhoto(String wanjuPhoto) {
        this.wanjuPhoto = wanjuPhoto;
    }
    /**
	 * 获取：玩具类型
	 */
    public Integer getWanjuTypes() {
        return wanjuTypes;
    }
    /**
	 * 设置：玩具类型
	 */

    public void setWanjuTypes(Integer wanjuTypes) {
        this.wanjuTypes = wanjuTypes;
    }
    /**
	 * 获取：玩具库存
	 */
    public Integer getWanjuKucunNumber() {
        return wanjuKucunNumber;
    }
    /**
	 * 设置：玩具库存
	 */

    public void setWanjuKucunNumber(Integer wanjuKucunNumber) {
        this.wanjuKucunNumber = wanjuKucunNumber;
    }
    /**
	 * 获取：租赁价格/h
	 */
    public Double getWanjuNewMoney() {
        return wanjuNewMoney;
    }
    /**
	 * 设置：租赁价格/h
	 */

    public void setWanjuNewMoney(Double wanjuNewMoney) {
        this.wanjuNewMoney = wanjuNewMoney;
    }
    /**
	 * 获取：玩具热度
	 */
    public Integer getWanjuClicknum() {
        return wanjuClicknum;
    }
    /**
	 * 设置：玩具热度
	 */

    public void setWanjuClicknum(Integer wanjuClicknum) {
        this.wanjuClicknum = wanjuClicknum;
    }
    /**
	 * 获取：玩具介绍
	 */
    public String getWanjuContent() {
        return wanjuContent;
    }
    /**
	 * 设置：玩具介绍
	 */

    public void setWanjuContent(String wanjuContent) {
        this.wanjuContent = wanjuContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 设置：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getWanjuDelete() {
        return wanjuDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setWanjuDelete(Integer wanjuDelete) {
        this.wanjuDelete = wanjuDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Wanju{" +
            ", id=" + id +
            ", wanjuUuidNumber=" + wanjuUuidNumber +
            ", wanjuName=" + wanjuName +
            ", wanjuPhoto=" + wanjuPhoto +
            ", wanjuTypes=" + wanjuTypes +
            ", wanjuKucunNumber=" + wanjuKucunNumber +
            ", wanjuNewMoney=" + wanjuNewMoney +
            ", wanjuClicknum=" + wanjuClicknum +
            ", wanjuContent=" + wanjuContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", wanjuDelete=" + wanjuDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
