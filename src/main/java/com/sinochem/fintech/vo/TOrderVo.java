package com.sinochem.fintech.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
public class TOrderVo {

    private Long orderId;
    @NotNull
    private Integer userId;

    private String status;
}