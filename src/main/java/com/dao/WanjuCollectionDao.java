package com.dao;

import com.entity.WanjuCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WanjuCollectionView;

/**
 * 玩具收藏 Dao 接口
 *
 * @author 
 */
public interface WanjuCollectionDao extends BaseMapper<WanjuCollectionEntity> {

   List<WanjuCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
