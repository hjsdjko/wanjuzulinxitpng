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
import com.dao.WanjuCommentbackDao;
import com.entity.WanjuCommentbackEntity;
import com.service.WanjuCommentbackService;
import com.entity.view.WanjuCommentbackView;

/**
 * 玩具评价 服务实现类
 */
@Service("wanjuCommentbackService")
@Transactional
public class WanjuCommentbackServiceImpl extends ServiceImpl<WanjuCommentbackDao, WanjuCommentbackEntity> implements WanjuCommentbackService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<WanjuCommentbackView> page =new Query<WanjuCommentbackView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
