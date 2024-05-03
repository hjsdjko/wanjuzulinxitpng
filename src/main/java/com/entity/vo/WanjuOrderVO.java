package com.entity.vo;

import com.entity.WanjuOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 玩具订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("wanju_order")
public class WanjuOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单号
     */

    @TableField(value = "wanju_order_uuid_number")
    private String wanjuOrderUuidNumber;


    /**
     * 玩具
     */

    @TableField(value = "wanju_id")
    private Integer wanjuId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 购买数量
     */

    @TableField(value = "buy_number")
    private Integer buyNumber;


    /**
     * 租赁时间/h
     */

    @TableField(value = "wanju_order_number")
    private Integer wanjuOrderNumber;


    /**
     * 实付价格
     */

    @TableField(value = "wanju_order_true_price")
    private Double wanjuOrderTruePrice;


    /**
     * 订单类型
     */

    @TableField(value = "wanju_order_types")
    private Integer wanjuOrderTypes;


    /**
     * 支付类型
     */

    @TableField(value = "wanju_order_payment_types")
    private Integer wanjuOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：订单号
	 */
    public String getWanjuOrderUuidNumber() {
        return wanjuOrderUuidNumber;
    }


    /**
	 * 获取：订单号
	 */

    public void setWanjuOrderUuidNumber(String wanjuOrderUuidNumber) {
        this.wanjuOrderUuidNumber = wanjuOrderUuidNumber;
    }
    /**
	 * 设置：玩具
	 */
    public Integer getWanjuId() {
        return wanjuId;
    }


    /**
	 * 获取：玩具
	 */

    public void setWanjuId(Integer wanjuId) {
        this.wanjuId = wanjuId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：购买数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 获取：购买数量
	 */

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 设置：租赁时间/h
	 */
    public Integer getWanjuOrderNumber() {
        return wanjuOrderNumber;
    }


    /**
	 * 获取：租赁时间/h
	 */

    public void setWanjuOrderNumber(Integer wanjuOrderNumber) {
        this.wanjuOrderNumber = wanjuOrderNumber;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getWanjuOrderTruePrice() {
        return wanjuOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setWanjuOrderTruePrice(Double wanjuOrderTruePrice) {
        this.wanjuOrderTruePrice = wanjuOrderTruePrice;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getWanjuOrderTypes() {
        return wanjuOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setWanjuOrderTypes(Integer wanjuOrderTypes) {
        this.wanjuOrderTypes = wanjuOrderTypes;
    }
    /**
	 * 设置：支付类型
	 */
    public Integer getWanjuOrderPaymentTypes() {
        return wanjuOrderPaymentTypes;
    }


    /**
	 * 获取：支付类型
	 */

    public void setWanjuOrderPaymentTypes(Integer wanjuOrderPaymentTypes) {
        this.wanjuOrderPaymentTypes = wanjuOrderPaymentTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
