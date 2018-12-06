package com.sinochem.fintech.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
public class TOrderItemVo {

    private Long orderItemId;
    @NotNull
    private Long orderId;
    @NotNull
    private Integer userId;

}