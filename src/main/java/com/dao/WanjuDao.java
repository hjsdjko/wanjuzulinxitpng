package com.dao;

import com.entity.WanjuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WanjuView;

/**
 * 玩具 Dao 接口
 *
 * @author 
 */
public interface WanjuDao extends BaseMapper<WanjuEntity> {

   List<WanjuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
