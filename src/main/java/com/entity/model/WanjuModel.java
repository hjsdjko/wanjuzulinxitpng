package com.entity.model;

import com.entity.WanjuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 玩具
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WanjuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 玩具编号
     */
    private String wanjuUuidNumber;


    /**
     * 玩具名称
     */
    private String wanjuName;


    /**
     * 玩具照片
     */
    private String wanjuPhoto;


    /**
     * 玩具类型
     */
    private Integer wanjuTypes;


    /**
     * 玩具库存
     */
    private Integer wanjuKucunNumber;


    /**
     * 租赁价格/h
     */
    private Double wanjuNewMoney;


    /**
     * 玩具热度
     */
    private Integer wanjuClicknum;


    /**
     * 玩具介绍
     */
    private String wanjuContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer wanjuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
