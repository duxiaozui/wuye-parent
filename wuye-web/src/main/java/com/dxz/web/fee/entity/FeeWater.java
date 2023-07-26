package com.dxz.web.fee.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 水费表
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-26
 */
@Getter
@Setter
@TableName("fee_water")
@ApiModel(value = "FeeWater对象", description = "水费表")
public class FeeWater implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "water_id", type = IdType.AUTO)
    private Integer waterId;

    @ApiModelProperty("房屋id")
    private Integer houseId;

    @ApiModelProperty("业主id")
    private Integer userId;

    @ApiModelProperty("缴费年月")
    private String payWaterMonth;

    @ApiModelProperty("缴费金额")
    private BigDecimal payWaterMoney;

    @ApiModelProperty("表显")
    private String waterrNum;

    @ApiModelProperty("0:未缴费  1：已缴费")
    private String payWaterStatus;

    @ApiModelProperty("缴费时间")
    private LocalDateTime payWaterTime;

    @ApiModelProperty("假删【0：删除】【1：未删除】")
    private Integer deleted;

    @ApiModelProperty("创建日期")
    private LocalDateTime createTime;

    @ApiModelProperty("更新日期")
    private LocalDateTime updateTime;


}
