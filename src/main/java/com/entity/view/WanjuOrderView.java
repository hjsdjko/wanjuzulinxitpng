package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.WanjuOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 玩具订单
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("wanju_order")
public class WanjuOrderView extends WanjuOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 订单类型的值
	*/
	@ColumnInfo(comment="订单类型的字典表值",type="varchar(200)")
	private String wanjuOrderValue;
	/**
	* 支付类型的值
	*/
	@ColumnInfo(comment="支付类型的字典表值",type="varchar(200)")
	private String wanjuOrderPaymentValue;

	//级联表 玩具
		/**
		* 玩具编号
		*/

		@ColumnInfo(comment="玩具编号",type="varchar(200)")
		private String wanjuUuidNumber;
		/**
		* 玩具名称
		*/

		@ColumnInfo(comment="玩具名称",type="varchar(200)")
		private String wanjuName;
		/**
		* 玩具照片
		*/

		@ColumnInfo(comment="玩具照片",type="varchar(200)")
		private String wanjuPhoto;
		/**
		* 玩具类型
		*/
		@ColumnInfo(comment="玩具类型",type="int(11)")
		private Integer wanjuTypes;
			/**
			* 玩具类型的值
			*/
			@ColumnInfo(comment="玩具类型的字典表值",type="varchar(200)")
			private String wanjuValue;
		/**
		* 玩具库存
		*/

		@ColumnInfo(comment="玩具库存",type="int(11)")
		private Integer wanjuKucunNumber;
		/**
		* 租赁价格/h
		*/
		@ColumnInfo(comment="租赁价格/h",type="decimal(10,2)")
		private Double wanjuNewMoney;
		/**
		* 玩具热度
		*/

		@ColumnInfo(comment="玩具热度",type="int(11)")
		private Integer wanjuClicknum;
		/**
		* 玩具介绍
		*/

		@ColumnInfo(comment="玩具介绍",type="longtext")
		private String wanjuContent;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer wanjuDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 身份证号
		*/

		@ColumnInfo(comment="身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;



	public WanjuOrderView() {

	}

	public WanjuOrderView(WanjuOrderEntity wanjuOrderEntity) {
		try {
			BeanUtils.copyProperties(this, wanjuOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 订单类型的值
	*/
	public String getWanjuOrderValue() {
		return wanjuOrderValue;
	}
	/**
	* 设置： 订单类型的值
	*/
	public void setWanjuOrderValue(String wanjuOrderValue) {
		this.wanjuOrderValue = wanjuOrderValue;
	}
	//当前表的
	/**
	* 获取： 支付类型的值
	*/
	public String getWanjuOrderPaymentValue() {
		return wanjuOrderPaymentValue;
	}
	/**
	* 设置： 支付类型的值
	*/
	public void setWanjuOrderPaymentValue(String wanjuOrderPaymentValue) {
		this.wanjuOrderPaymentValue = wanjuOrderPaymentValue;
	}


	//级联表的get和set 玩具

		/**
		* 获取： 玩具编号
		*/
		public String getWanjuUuidNumber() {
			return wanjuUuidNumber;
		}
		/**
		* 设置： 玩具编号
		*/
		public void setWanjuUuidNumber(String wanjuUuidNumber) {
			this.wanjuUuidNumber = wanjuUuidNumber;
		}

		/**
		* 获取： 玩具名称
		*/
		public String getWanjuName() {
			return wanjuName;
		}
		/**
		* 设置： 玩具名称
		*/
		public void setWanjuName(String wanjuName) {
			this.wanjuName = wanjuName;
		}

		/**
		* 获取： 玩具照片
		*/
		public String getWanjuPhoto() {
			return wanjuPhoto;
		}
		/**
		* 设置： 玩具照片
		*/
		public void setWanjuPhoto(String wanjuPhoto) {
			this.wanjuPhoto = wanjuPhoto;
		}
		/**
		* 获取： 玩具类型
		*/
		public Integer getWanjuTypes() {
			return wanjuTypes;
		}
		/**
		* 设置： 玩具类型
		*/
		public void setWanjuTypes(Integer wanjuTypes) {
			this.wanjuTypes = wanjuTypes;
		}


			/**
			* 获取： 玩具类型的值
			*/
			public String getWanjuValue() {
				return wanjuValue;
			}
			/**
			* 设置： 玩具类型的值
			*/
			public void setWanjuValue(String wanjuValue) {
				this.wanjuValue = wanjuValue;
			}

		/**
		* 获取： 玩具库存
		*/
		public Integer getWanjuKucunNumber() {
			return wanjuKucunNumber;
		}
		/**
		* 设置： 玩具库存
		*/
		public void setWanjuKucunNumber(Integer wanjuKucunNumber) {
			this.wanjuKucunNumber = wanjuKucunNumber;
		}

		/**
		* 获取： 租赁价格/h
		*/
		public Double getWanjuNewMoney() {
			return wanjuNewMoney;
		}
		/**
		* 设置： 租赁价格/h
		*/
		public void setWanjuNewMoney(Double wanjuNewMoney) {
			this.wanjuNewMoney = wanjuNewMoney;
		}

		/**
		* 获取： 玩具热度
		*/
		public Integer getWanjuClicknum() {
			return wanjuClicknum;
		}
		/**
		* 设置： 玩具热度
		*/
		public void setWanjuClicknum(Integer wanjuClicknum) {
			this.wanjuClicknum = wanjuClicknum;
		}

		/**
		* 获取： 玩具介绍
		*/
		public String getWanjuContent() {
			return wanjuContent;
		}
		/**
		* 设置： 玩具介绍
		*/
		public void setWanjuContent(String wanjuContent) {
			this.wanjuContent = wanjuContent;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


			/**
			* 获取： 是否上架的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 是否上架的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
			}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getWanjuDelete() {
			return wanjuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setWanjuDelete(Integer wanjuDelete) {
			this.wanjuDelete = wanjuDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 联系方式
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}


	@Override
	public String toString() {
		return "WanjuOrderView{" +
			", wanjuOrderValue=" + wanjuOrderValue +
			", wanjuOrderPaymentValue=" + wanjuOrderPaymentValue +
			", wanjuUuidNumber=" + wanjuUuidNumber +
			", wanjuName=" + wanjuName +
			", wanjuPhoto=" + wanjuPhoto +
			", wanjuKucunNumber=" + wanjuKucunNumber +
			", wanjuNewMoney=" + wanjuNewMoney +
			", wanjuClicknum=" + wanjuClicknum +
			", wanjuContent=" + wanjuContent +
			", wanjuDelete=" + wanjuDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			"} " + super.toString();
	}
}
