package com.sinochem.fintech.service;

import com.sinochem.fintech.common.BaseService;
import com.sinochem.fintech.entity.TOrderItem;
import com.sinochem.fintech.mapper.TOrderItemMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: heshouyou
 * @Description  订单子项服务
 * @Date Created in 2018/12/6 10:23
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TOrderItemService extends BaseService<TOrderItemMapper,TOrderItem> {
}
