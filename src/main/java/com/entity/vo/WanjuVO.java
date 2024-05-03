package com.entity.vo;

import com.entity.WanjuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 玩具
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("wanju")
public class WanjuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 玩具编号
     */

    @TableField(value = "wanju_uuid_number")
    private String wanjuUuidNumber;


    /**
     * 玩具名称
     */

    @TableField(value = "wanju_name")
    private String wanjuName;


    /**
     * 玩具照片
     */

    @TableField(value = "wanju_photo")
    private String wanjuPhoto;


    /**
     * 玩具类型
     */

    @TableField(value = "wanju_types")
    private Integer wanjuTypes;


    /**
     * 玩具库存
     */

    @TableField(value = "wanju_kucun_number")
    private Integer wanjuKucunNumber;


    /**
     * 租赁价格/h
     */

    @TableField(value = "wanju_new_money")
    private Double wanjuNewMoney;


    /**
     * 玩具热度
     */

    @TableField(value = "wanju_clicknum")
    private Integer wanjuClicknum;


    /**
     * 玩具介绍
     */

    @TableField(value = "wanju_content")
    private String wanjuContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "wanju_delete")
    private Integer wanjuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：玩具编号
	 */
    public String getWanjuUuidNumber() {
        return wanjuUuidNumber;
    }


    /**
	 * 获取：玩具编号
	 */

    public void setWanjuUuidNumber(String wanjuUuidNumber) {
        this.wanjuUuidNumber = wanjuUuidNumber;
    }
    /**
	 * 设置：玩具名称
	 */
    public String getWanjuName() {
        return wanjuName;
    }


    /**
	 * 获取：玩具名称
	 */

    public void setWanjuName(String wanjuName) {
        this.wanjuName = wanjuName;
    }
    /**
	 * 设置：玩具照片
	 */
    public String getWanjuPhoto() {
        return wanjuPhoto;
    }


    /**
	 * 获取：玩具照片
	 */

    public void setWanjuPhoto(String wanjuPhoto) {
        this.wanjuPhoto = wanjuPhoto;
    }
    /**
	 * 设置：玩具类型
	 */
    public Integer getWanjuTypes() {
        return wanjuTypes;
    }


    /**
	 * 获取：玩具类型
	 */

    public void setWanjuTypes(Integer wanjuTypes) {
        this.wanjuTypes = wanjuTypes;
    }
    /**
	 * 设置：玩具库存
	 */
    public Integer getWanjuKucunNumber() {
        return wanjuKucunNumber;
    }


    /**
	 * 获取：玩具库存
	 */

    public void setWanjuKucunNumber(Integer wanjuKucunNumber) {
        this.wanjuKucunNumber = wanjuKucunNumber;
    }
    /**
	 * 设置：租赁价格/h
	 */
    public Double getWanjuNewMoney() {
        return wanjuNewMoney;
    }


    /**
	 * 获取：租赁价格/h
	 */

    public void setWanjuNewMoney(Double wanjuNewMoney) {
        this.wanjuNewMoney = wanjuNewMoney;
    }
    /**
	 * 设置：玩具热度
	 */
    public Integer getWanjuClicknum() {
        return wanjuClicknum;
    }


    /**
	 * 获取：玩具热度
	 */

    public void setWanjuClicknum(Integer wanjuClicknum) {
        this.wanjuClicknum = wanjuClicknum;
    }
    /**
	 * 设置：玩具介绍
	 */
    public String getWanjuContent() {
        return wanjuContent;
    }


    /**
	 * 获取：玩具介绍
	 */

    public void setWanjuContent(String wanjuContent) {
        this.wanjuContent = wanjuContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getWanjuDelete() {
        return wanjuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setWanjuDelete(Integer wanjuDelete) {
        this.wanjuDelete = wanjuDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
