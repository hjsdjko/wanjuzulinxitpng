package com.service.impl;

import com.utils.StringUtil;
import com.service.DictionaryService;
import com.utils.ClazzDiff;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import com.dao.WanjuDao;
import com.entity.WanjuEntity;
import com.service.WanjuService;
import com.entity.view.WanjuView;

/**
 * 玩具 服务实现类
 */
@Service("wanjuService")
@Transactional
public class WanjuServiceImpl extends ServiceImpl<WanjuDao, WanjuEntity> implements WanjuService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<WanjuView> page =new Query<WanjuView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
