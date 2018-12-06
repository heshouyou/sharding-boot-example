package com.sinochem.fintech.service;

import com.sinochem.fintech.common.BaseService;
import com.sinochem.fintech.entity.TOrder;
import com.sinochem.fintech.entity.TOrderItem;
import com.sinochem.fintech.exception.BaseException;
import com.sinochem.fintech.mapper.TOrderItemMapper;
import com.sinochem.fintech.mapper.TOrderMapper;
import com.sinochem.fintech.vo.TOrderAndItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: heshouyou
 * @Description  订单服务
 * @Date Created in 2018/12/6 10:22
 */
@Service
@Transactional(rollbackFor = BaseException.class)
public class TOrderService extends BaseService<TOrderMapper,TOrder> {

    @Autowired
    private TOrderItemMapper tOrderItemMapper;

    /**
     * 创建订单
     * @Param:
     * @Return:
     */
    public int insertOrderAndItem(TOrderAndItemVo tOrderAndItemVo){
        TOrder tOrder = new TOrder();
        tOrder.setOrderId(tOrderAndItemVo.getOrderId());
        tOrder.setUserId(tOrderAndItemVo.getUserId());
        tOrder.setStatus(tOrderAndItemVo.getStatus());
        int insert = getMapper().insert(tOrder);
        if (insert != 1) {
            throw BaseException.builder().status(999).message("发生自定义异常").build();
        }

        TOrderItem tOrderItem = new TOrderItem();
        tOrderItem.setOrderItemId(tOrderAndItemVo.getOrderItemId());
        tOrderItem.setOrderId(tOrderAndItemVo.getOrderId());
        tOrderItem.setUserId(tOrderAndItemVo.getUserId());
        int selective = tOrderItemMapper.insertSelective(tOrderItem);
        if (selective != 1) {
            throw BaseException.builder().status(999).message("发生自定义异常").build();
        }
        return 1;
    }
}
