package com.sinochem.fintech.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author: heshouyou
 * @Description
 * @Date Created in 2018/12/6 15:33
 */
@Data
public class TOrderAndItemVo {

    private Long orderId;
    @NotNull
    private Integer userId;

    private String status;

    private Long orderItemId;
}
