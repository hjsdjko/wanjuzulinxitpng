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
 * 玩具订单
 *
 * @author 
 * @email
 */
@TableName("wanju_order")
public class WanjuOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WanjuOrderEntity() {

	}

	public WanjuOrderEntity(T t) {
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
     * 订单号
     */
    @ColumnInfo(comment="订单号",type="varchar(200)")
    @TableField(value = "wanju_order_uuid_number")

    private String wanjuOrderUuidNumber;


    /**
     * 玩具
     */
    @ColumnInfo(comment="玩具",type="int(11)")
    @TableField(value = "wanju_id")

    private Integer wanjuId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 购买数量
     */
    @ColumnInfo(comment="购买数量",type="int(11)")
    @TableField(value = "buy_number")

    private Integer buyNumber;


    /**
     * 租赁时间/h
     */
    @ColumnInfo(comment="租赁时间/h",type="int(11)")
    @TableField(value = "wanju_order_number")

    private Integer wanjuOrderNumber;


    /**
     * 实付价格
     */
    @ColumnInfo(comment="实付价格",type="decimal(10,2)")
    @TableField(value = "wanju_order_true_price")

    private Double wanjuOrderTruePrice;


    /**
     * 订单类型
     */
    @ColumnInfo(comment="订单类型",type="int(11)")
    @TableField(value = "wanju_order_types")

    private Integer wanjuOrderTypes;


    /**
     * 支付类型
     */
    @ColumnInfo(comment="支付类型",type="int(11)")
    @TableField(value = "wanju_order_payment_types")

    private Integer wanjuOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="订单创建时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
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
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "WanjuOrder{" +
            ", id=" + id +
            ", wanjuOrderUuidNumber=" + wanjuOrderUuidNumber +
            ", wanjuId=" + wanjuId +
            ", yonghuId=" + yonghuId +
            ", buyNumber=" + buyNumber +
            ", wanjuOrderNumber=" + wanjuOrderNumber +
            ", wanjuOrderTruePrice=" + wanjuOrderTruePrice +
            ", wanjuOrderTypes=" + wanjuOrderTypes +
            ", wanjuOrderPaymentTypes=" + wanjuOrderPaymentTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
