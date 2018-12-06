package com.sinochem.fintech.rest;

import com.sinochem.fintech.common.BaseController;
import com.sinochem.fintech.common.BaseResponse;
import com.sinochem.fintech.entity.TOrder;
import com.sinochem.fintech.service.TOrderItemService;
import com.sinochem.fintech.service.TOrderService;
import com.sinochem.fintech.vo.TOrderAndItemVo;
import com.sinochem.fintech.vo.TOrderVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author: heshouyou
 * @Description  测试分库分表Example
 * @Date Created in 2018/12/6 10:07
 */
@Api("测试分库分表")
@Slf4j
@RestController
@RequestMapping("sharding")
public class ShardingController extends BaseController {

    @Autowired
    private TOrderService tOrderService;

    @Autowired
    private TOrderItemService tOrderItemService;

    @PostMapping(value = "addOrder")
    @ApiOperation("添加订单")
    @ApiImplicitParam(name = "tOrderVo",value = "订单对象",dataType = "TOrderVo")
    public BaseResponse addOrder(@RequestBody @Valid TOrderVo tOrderVo, BindingResult bindingResult){
        log.info("start processing addOrder method ");
        //检验参数
        BaseResponse response = validateField(bindingResult);
        if (response.getStatus() != 200) {
            return response;
        }
        //执行逻辑
        TOrder tOrder = new TOrder();
        BeanUtils.copyProperties(tOrderVo,tOrder);
        int selective = tOrderService.insertSelective(tOrder);
        if (selective > 0){
            response.setMessage("success");
//            BaseResponse.builder().message("success").build();
        } else {
            response.setMessage("fail");
            response.setStatus(999);
//            BaseResponse.builder().message("fail").status(999).build();
        }

        return response;
    }

    @PostMapping(value = "addOrderAndItem")
    @ApiOperation("添加订单和订单子项")
    @ApiImplicitParam(name = "tOrderAndItemVo",value = "订单和订单子项对象",dataType = "TOrderAndItemVo")
    public BaseResponse addOrderAndItem(@RequestBody @Valid TOrderAndItemVo tOrderAndItemVo, BindingResult bindingResult){
        log.info("start processing addOrderAndItem method ");
        //检验参数
        BaseResponse response = validateField(bindingResult);
        if (response.getStatus() != 200) {
            return response;
        }
        //执行逻辑
        int selective = tOrderService.insertOrderAndItem(tOrderAndItemVo);
        if (selective > 0){
            response.setMessage("success");
//            BaseResponse.builder().message("success").build();
        } else {
            response.setMessage("fail");
            response.setStatus(999);
//            BaseResponse.builder().message("fail").status(999).build();
        }

        return response;
    }
}
