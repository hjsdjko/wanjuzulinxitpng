
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
 * 玩具订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/wanjuOrder")
public class WanjuOrderController {
    private static final Logger logger = LoggerFactory.getLogger(WanjuOrderController.class);

    private static final String TABLE_NAME = "wanjuOrder";

    @Autowired
    private WanjuOrderService wanjuOrderService;


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
    private WanjuService wanjuService;//玩具
    @Autowired
    private WanjuCollectionService wanjuCollectionService;//玩具收藏
    @Autowired
    private WanjuCommentbackService wanjuCommentbackService;//玩具评价
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
        CommonUtil.checkMap(params);
        PageUtils page = wanjuOrderService.queryPage(params);

        //字典表数据转换
        List<WanjuOrderView> list =(List<WanjuOrderView>)page.getList();
        for(WanjuOrderView c:list){
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
        WanjuOrderEntity wanjuOrder = wanjuOrderService.selectById(id);
        if(wanjuOrder !=null){
            //entity转view
            WanjuOrderView view = new WanjuOrderView();
            BeanUtils.copyProperties( wanjuOrder , view );//把实体数据重构到view中
            //级联表 玩具
            //级联表
            WanjuEntity wanju = wanjuService.selectById(wanjuOrder.getWanjuId());
            if(wanju != null){
            BeanUtils.copyProperties( wanju , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setWanjuId(wanju.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(wanjuOrder.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
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
    public R save(@RequestBody WanjuOrderEntity wanjuOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,wanjuOrder:{}",this.getClass().getName(),wanjuOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            wanjuOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        wanjuOrder.setCreateTime(new Date());
        wanjuOrder.setInsertTime(new Date());
        wanjuOrderService.insert(wanjuOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WanjuOrderEntity wanjuOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,wanjuOrder:{}",this.getClass().getName(),wanjuOrder.toString());
        WanjuOrderEntity oldWanjuOrderEntity = wanjuOrderService.selectById(wanjuOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            wanjuOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            wanjuOrderService.updateById(wanjuOrder);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<WanjuOrderEntity> oldWanjuOrderList =wanjuOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        wanjuOrderService.deleteBatchIds(Arrays.asList(ids));

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
            List<WanjuOrderEntity> wanjuOrderList = new ArrayList<>();//上传的东西
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
                            WanjuOrderEntity wanjuOrderEntity = new WanjuOrderEntity();
//                            wanjuOrderEntity.setWanjuOrderUuidNumber(data.get(0));                    //订单号 要改的
//                            wanjuOrderEntity.setWanjuId(Integer.valueOf(data.get(0)));   //玩具 要改的
//                            wanjuOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            wanjuOrderEntity.setBuyNumber(Integer.valueOf(data.get(0)));   //购买数量 要改的
//                            wanjuOrderEntity.setWanjuOrderNumber(Integer.valueOf(data.get(0)));   //租赁时间/h 要改的
//                            wanjuOrderEntity.setWanjuOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            wanjuOrderEntity.setWanjuOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            wanjuOrderEntity.setWanjuOrderPaymentTypes(Integer.valueOf(data.get(0)));   //支付类型 要改的
//                            wanjuOrderEntity.setInsertTime(date);//时间
//                            wanjuOrderEntity.setCreateTime(date);//时间
                            wanjuOrderList.add(wanjuOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单号
                                if(seachFields.containsKey("wanjuOrderUuidNumber")){
                                    List<String> wanjuOrderUuidNumber = seachFields.get("wanjuOrderUuidNumber");
                                    wanjuOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> wanjuOrderUuidNumber = new ArrayList<>();
                                    wanjuOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("wanjuOrderUuidNumber",wanjuOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单号
                        List<WanjuOrderEntity> wanjuOrderEntities_wanjuOrderUuidNumber = wanjuOrderService.selectList(new EntityWrapper<WanjuOrderEntity>().in("wanju_order_uuid_number", seachFields.get("wanjuOrderUuidNumber")));
                        if(wanjuOrderEntities_wanjuOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WanjuOrderEntity s:wanjuOrderEntities_wanjuOrderUuidNumber){
                                repeatFields.add(s.getWanjuOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        wanjuOrderService.insertBatch(wanjuOrderList);
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
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = wanjuOrderService.queryPage(params);

        //字典表数据转换
        List<WanjuOrderView> list =(List<WanjuOrderView>)page.getList();
        for(WanjuOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WanjuOrderEntity wanjuOrder = wanjuOrderService.selectById(id);
            if(wanjuOrder !=null){


                //entity转view
                WanjuOrderView view = new WanjuOrderView();
                BeanUtils.copyProperties( wanjuOrder , view );//把实体数据重构到view中

                //级联表
                    WanjuEntity wanju = wanjuService.selectById(wanjuOrder.getWanjuId());
                if(wanju != null){
                    BeanUtils.copyProperties( wanju , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setWanjuId(wanju.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(wanjuOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
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
    public R add(@RequestBody WanjuOrderEntity wanjuOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,wanjuOrder:{}",this.getClass().getName(),wanjuOrder.toString());
            WanjuEntity wanjuEntity = wanjuService.selectById(wanjuOrder.getWanjuId());
            if(wanjuEntity == null){
                return R.error(511,"查不到该玩具");
            }
            // Double wanjuNewMoney = wanjuEntity.getWanjuNewMoney();

            if(false){
            }
            else if(wanjuEntity.getWanjuNewMoney() == null){
                return R.error(511,"租赁价格/h不能为空");
            }
            else if((wanjuEntity.getWanjuKucunNumber() -wanjuOrder.getBuyNumber())<0){
                return R.error(511,"购买数量不能大于库存数量");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - wanjuEntity.getWanjuNewMoney()*wanjuOrder.getBuyNumber() * wanjuOrder.getWanjuOrderNumber();//余额
            if(balance<0)
                return R.error(511,"余额不够支付");
            wanjuOrder.setWanjuOrderTypes(101); //设置订单状态为已租赁
            wanjuOrder.setWanjuOrderTruePrice(wanjuEntity.getWanjuNewMoney()*wanjuOrder.getBuyNumber()); //设置实付价格
            wanjuOrder.setYonghuId(userId); //设置订单支付人id
            wanjuOrder.setWanjuOrderUuidNumber(String.valueOf(new Date().getTime()));
            wanjuOrder.setWanjuOrderPaymentTypes(1);
            wanjuOrder.setInsertTime(new Date());
            wanjuOrder.setCreateTime(new Date());
            wanjuOrder.setWanjuOrderNumber(wanjuOrder.getWanjuOrderNumber());
                wanjuEntity.setWanjuKucunNumber( wanjuEntity.getWanjuKucunNumber() -wanjuOrder.getBuyNumber());
                wanjuService.updateById(wanjuEntity);
                wanjuOrderService.insert(wanjuOrder);//新增订单
            //更新第一注册表
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuService.updateById(yonghuEntity);


            return R.ok();
    }


    /**
    * 退款
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            WanjuOrderEntity wanjuOrder = wanjuOrderService.selectById(id);//当前表service
            Integer buyNumber = wanjuOrder.getBuyNumber();
            Integer wanjuOrderPaymentTypes = wanjuOrder.getWanjuOrderPaymentTypes();
            Integer wanjuId = wanjuOrder.getWanjuId();
            if(wanjuId == null)
                return R.error(511,"查不到该玩具");
            WanjuEntity wanjuEntity = wanjuService.selectById(wanjuId);
            if(wanjuEntity == null)
                return R.error(511,"查不到该玩具");
            Double wanjuNewMoney = wanjuEntity.getWanjuNewMoney();
            if(wanjuNewMoney == null)
                return R.error(511,"玩具价格不能为空");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
            return R.error(511,"用户金额不能为空");
            Double zhekou = 1.0;

            //判断是什么支付方式 1代表余额 2代表积分
            if(wanjuOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = wanjuEntity.getWanjuNewMoney() * buyNumber  * zhekou;
                //计算所获得积分
                Double buyJifen = 0.0;
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + money); //设置金额


            }

            wanjuEntity.setWanjuKucunNumber(wanjuEntity.getWanjuKucunNumber() + buyNumber);


            wanjuOrder.setWanjuOrderTypes(102);//设置订单状态为已退款
            wanjuOrderService.updateById(wanjuOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            wanjuService.updateById(wanjuEntity);//更新订单中玩具的信息

            return R.ok();
    }

    /**
    * 评价
    */
    @RequestMapping("/commentback")
    public R commentback(Integer id, String commentbackText, Integer wanjuCommentbackPingfenNumber, HttpServletRequest request){
        logger.debug("commentback方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
            WanjuOrderEntity wanjuOrder = wanjuOrderService.selectById(id);
        if(wanjuOrder == null)
            return R.error(511,"查不到该订单");
        Integer wanjuId = wanjuOrder.getWanjuId();
        if(wanjuId == null)
            return R.error(511,"查不到该玩具");

        WanjuCommentbackEntity wanjuCommentbackEntity = new WanjuCommentbackEntity();
            wanjuCommentbackEntity.setId(id);
            wanjuCommentbackEntity.setWanjuId(wanjuId);
            wanjuCommentbackEntity.setYonghuId((Integer) request.getSession().getAttribute("userId"));
            wanjuCommentbackEntity.setWanjuCommentbackText(commentbackText);
            wanjuCommentbackEntity.setInsertTime(new Date());
            wanjuCommentbackEntity.setReplyText(null);
            wanjuCommentbackEntity.setUpdateTime(null);
            wanjuCommentbackEntity.setCreateTime(new Date());
            wanjuCommentbackService.insert(wanjuCommentbackEntity);

            wanjuOrder.setWanjuOrderTypes(105);//设置订单状态为已评价
            wanjuOrderService.updateById(wanjuOrder);//根据id更新
            return R.ok();
    }

    /**
     * 完成
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id  , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        WanjuOrderEntity  wanjuOrderEntity = wanjuOrderService.selectById(id);
        wanjuOrderEntity.setWanjuOrderTypes(103);//设置订单状态为已完成
        wanjuOrderService.updateById( wanjuOrderEntity);

        return R.ok();
    }


}

