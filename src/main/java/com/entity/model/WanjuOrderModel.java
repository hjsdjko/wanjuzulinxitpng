package com.entity.model;

import com.entity.WanjuOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 玩具订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WanjuOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单号
     */
    private String wanjuOrderUuidNumber;


    /**
     * 玩具
     */
    private Integer wanjuId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 购买数量
     */
    private Integer buyNumber;


    /**
     * 租赁时间/h
     */
    private Integer wanjuOrderNumber;


    /**
     * 实付价格
     */
    private Double wanjuOrderTruePrice;


    /**
     * 订单类型
     */
    private Integer wanjuOrderTypes;


    /**
     * 支付类型
     */
    private Integer wanjuOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 获取：订单号
	 */
    public String getWanjuOrderUuidNumber() {
        return wanjuOrderUuidNumber;
    }


    /**
	 * 设置：订单号
	 */
    public void setWanjuOrderUuidNumber(String wanjuOrderUuidNumber) {
        this.wanjuOrderUuidNumber = wanjuOrderUuidNumber;
    }
    /**
	 * 获取：玩具
	 */
    public Integer getWanjuId() {
        return wanjuId;
    }


    /**
	 * 设置：玩具
	 */
    public void setWanjuId(Integer wanjuId) {
        this.wanjuId = wanjuId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：购买数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 设置：购买数量
	 */
    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 获取：租赁时间/h
	 */
    public Integer getWanjuOrderNumber() {
        return wanjuOrderNumber;
    }


    /**
	 * 设置：租赁时间/h
	 */
    public void setWanjuOrderNumber(Integer wanjuOrderNumber) {
        this.wanjuOrderNumber = wanjuOrderNumber;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getWanjuOrderTruePrice() {
        return wanjuOrderTruePrice;
    }


    /**
	 * 设置：实付价格
	 */
    public void setWanjuOrderTruePrice(Double wanjuOrderTruePrice) {
        this.wanjuOrderTruePrice = wanjuOrderTruePrice;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getWanjuOrderTypes() {
        return wanjuOrderTypes;
    }


    /**
	 * 设置：订单类型
	 */
    public void setWanjuOrderTypes(Integer wanjuOrderTypes) {
        this.wanjuOrderTypes = wanjuOrderTypes;
    }
    /**
	 * 获取：支付类型
	 */
    public Integer getWanjuOrderPaymentTypes() {
        return wanjuOrderPaymentTypes;
    }


    /**
	 * 设置：支付类型
	 */
    public void setWanjuOrderPaymentTypes(Integer wanjuOrderPaymentTypes) {
        this.wanjuOrderPaymentTypes = wanjuOrderPaymentTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：订单创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
