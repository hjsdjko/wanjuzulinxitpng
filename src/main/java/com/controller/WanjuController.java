
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 玩具
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/wanju")
public class WanjuController {
    private static final Logger logger = LoggerFactory.getLogger(WanjuController.class);

    private static final String TABLE_NAME = "wanju";

    @Autowired
    private WanjuService wanjuService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private LiuyanService liuyanService;//留言板
    @Autowired
    private NewsService newsService;//公告信息
    @Autowired
    private WanjuCollectionService wanjuCollectionService;//玩具收藏
    @Autowired
    private WanjuCommentbackService wanjuCommentbackService;//玩具评价
    @Autowired
    private WanjuOrderService wanjuOrderService;//玩具订单
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("wanjuDeleteStart",1);params.put("wanjuDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = wanjuService.queryPage(params);

        //字典表数据转换
        List<WanjuView> list =(List<WanjuView>)page.getList();
        for(WanjuView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WanjuEntity wanju = wanjuService.selectById(id);
        if(wanju !=null){
            //entity转view
            WanjuView view = new WanjuView();
            BeanUtils.copyProperties( wanju , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody WanjuEntity wanju, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,wanju:{}",this.getClass().getName(),wanju.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<WanjuEntity> queryWrapper = new EntityWrapper<WanjuEntity>()
            .eq("wanju_name", wanju.getWanjuName())
            .eq("wanju_types", wanju.getWanjuTypes())
            .eq("wanju_kucun_number", wanju.getWanjuKucunNumber())
            .eq("shangxia_types", wanju.getShangxiaTypes())
            .eq("wanju_delete", wanju.getWanjuDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WanjuEntity wanjuEntity = wanjuService.selectOne(queryWrapper);
        if(wanjuEntity==null){
            wanju.setWanjuClicknum(1);
            wanju.setShangxiaTypes(1);
            wanju.setWanjuDelete(1);
            wanju.setInsertTime(new Date());
            wanju.setCreateTime(new Date());
            wanjuService.insert(wanju);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WanjuEntity wanju, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,wanju:{}",this.getClass().getName(),wanju.toString());
        WanjuEntity oldWanjuEntity = wanjuService.selectById(wanju.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(wanju.getWanjuPhoto()) || "null".equals(wanju.getWanjuPhoto())){
                wanju.setWanjuPhoto(null);
        }

            wanjuService.updateById(wanju);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<WanjuEntity> oldWanjuList =wanjuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<WanjuEntity> list = new ArrayList<>();
        for(Integer id:ids){
            WanjuEntity wanjuEntity = new WanjuEntity();
            wanjuEntity.setId(id);
            wanjuEntity.setWanjuDelete(2);
            list.add(wanjuEntity);
        }
        if(list != null && list.size() >0){
            wanjuService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<WanjuEntity> wanjuList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            WanjuEntity wanjuEntity = new WanjuEntity();
//                            wanjuEntity.setWanjuUuidNumber(data.get(0));                    //玩具编号 要改的
//                            wanjuEntity.setWanjuName(data.get(0));                    //玩具名称 要改的
//                            wanjuEntity.setWanjuPhoto("");//详情和图片
//                            wanjuEntity.setWanjuTypes(Integer.valueOf(data.get(0)));   //玩具类型 要改的
//                            wanjuEntity.setWanjuKucunNumber(Integer.valueOf(data.get(0)));   //玩具库存 要改的
//                            wanjuEntity.setWanjuNewMoney(data.get(0));                    //租赁价格/h 要改的
//                            wanjuEntity.setWanjuClicknum(Integer.valueOf(data.get(0)));   //玩具热度 要改的
//                            wanjuEntity.setWanjuContent("");//详情和图片
//                            wanjuEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            wanjuEntity.setWanjuDelete(1);//逻辑删除字段
//                            wanjuEntity.setInsertTime(date);//时间
//                            wanjuEntity.setCreateTime(date);//时间
                            wanjuList.add(wanjuEntity);


                            //把要查询是否重复的字段放入map中
                                //玩具编号
                                if(seachFields.containsKey("wanjuUuidNumber")){
                                    List<String> wanjuUuidNumber = seachFields.get("wanjuUuidNumber");
                                    wanjuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> wanjuUuidNumber = new ArrayList<>();
                                    wanjuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("wanjuUuidNumber",wanjuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //玩具编号
                        List<WanjuEntity> wanjuEntities_wanjuUuidNumber = wanjuService.selectList(new EntityWrapper<WanjuEntity>().in("wanju_uuid_number", seachFields.get("wanjuUuidNumber")).eq("wanju_delete", 1));
                        if(wanjuEntities_wanjuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WanjuEntity s:wanjuEntities_wanjuUuidNumber){
                                repeatFields.add(s.getWanjuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [玩具编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        wanjuService.insertBatch(wanjuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }



    /**
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<WanjuView> returnWanjuViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = wanjuOrderService.queryPage(params1);
        List<WanjuOrderView> orderViewsList =(List<WanjuOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(WanjuOrderView orderView:orderViewsList){
            Integer wanjuTypes = orderView.getWanjuTypes();
            if(typeMap.containsKey(wanjuTypes)){
                typeMap.put(wanjuTypes,typeMap.get(wanjuTypes)+1);
            }else{
                typeMap.put(wanjuTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("wanjuTypes",type);
            PageUtils pageUtils1 = wanjuService.queryPage(params2);
            List<WanjuView> wanjuViewList =(List<WanjuView>)pageUtils1.getList();
            returnWanjuViewList.addAll(wanjuViewList);
            if(returnWanjuViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = wanjuService.queryPage(params);
        if(returnWanjuViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnWanjuViewList.size();//要添加的数量
            List<WanjuView> wanjuViewList =(List<WanjuView>)page.getList();
            for(WanjuView wanjuView:wanjuViewList){
                Boolean addFlag = true;
                for(WanjuView returnWanjuView:returnWanjuViewList){
                    if(returnWanjuView.getId().intValue() ==wanjuView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnWanjuViewList.add(wanjuView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnWanjuViewList = returnWanjuViewList.subList(0, limit);
        }

        for(WanjuView c:returnWanjuViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnWanjuViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = wanjuService.queryPage(params);

        //字典表数据转换
        List<WanjuView> list =(List<WanjuView>)page.getList();
        for(WanjuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WanjuEntity wanju = wanjuService.selectById(id);
            if(wanju !=null){

                //点击数量加1
                wanju.setWanjuClicknum(wanju.getWanjuClicknum()+1);
                wanjuService.updateById(wanju);

                //entity转view
                WanjuView view = new WanjuView();
                BeanUtils.copyProperties( wanju , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody WanjuEntity wanju, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,wanju:{}",this.getClass().getName(),wanju.toString());
        Wrapper<WanjuEntity> queryWrapper = new EntityWrapper<WanjuEntity>()
            .eq("wanju_uuid_number", wanju.getWanjuUuidNumber())
            .eq("wanju_name", wanju.getWanjuName())
            .eq("wanju_types", wanju.getWanjuTypes())
            .eq("wanju_kucun_number", wanju.getWanjuKucunNumber())
            .eq("wanju_clicknum", wanju.getWanjuClicknum())
            .eq("shangxia_types", wanju.getShangxiaTypes())
            .eq("wanju_delete", wanju.getWanjuDelete())
//            .notIn("wanju_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WanjuEntity wanjuEntity = wanjuService.selectOne(queryWrapper);
        if(wanjuEntity==null){
            wanju.setWanjuClicknum(1);
            wanju.setWanjuDelete(1);
            wanju.setInsertTime(new Date());
            wanju.setCreateTime(new Date());
        wanjuService.insert(wanju);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

