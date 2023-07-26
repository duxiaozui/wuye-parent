package com.dxz.web.fee.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dxz.utils.Result;
import com.dxz.web.fee.entity.FeeWater;
import com.dxz.web.fee.param.FeeWaterParam;
import com.dxz.web.fee.service.IFeeWaterService;
import com.dxz.web.system.entity.LiveHouse;
import com.dxz.web.system.service.ILiveHouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 水费表 前端控制器
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-26
 */
@RestController
@RequestMapping("/api/feeWater")
@Api(tags = "水费管理")
public class FeeWaterController {
    @Autowired
    private IFeeWaterService feeWaterService;
    @Autowired
    private ILiveHouseService liveHouseService;

    @ApiOperation("水费列表")
    @GetMapping("/list")
    public Result getList(FeeWaterParam param) {
        IPage<FeeWater> page = feeWaterService.getList(param);
        return Result.success(page);
    }

    @ApiOperation("新增水费")
    @PostMapping
    public Result addFeeWater(@RequestBody FeeWater feeWater) {
        //根据房屋id查询正在使用该房间的用户
        QueryWrapper<LiveHouse> query = new QueryWrapper<>();
        query.lambda().eq(LiveHouse::getHouseId, feeWater.getHouseId())
                .eq(LiveHouse::getUseStatus, 1);
        LiveHouse liveHouse = liveHouseService.getOne(query);
        if (liveHouse == null) {
            return Result.error(500, "该房间没有人使用，不能添加水费");
        }
        //把查询出来的用户id设置到电费实体里面
        feeWater.setUserId(liveHouse.getUserId());
        feeWaterService.saveFeeWater(feeWater);
        return Result.success();
    }

    @ApiOperation("编辑水费")
    @PutMapping
    public Result editFeeWater(@RequestBody FeeWater feeWater) {
        //根据房屋id查询正在使用该房间的用户
        QueryWrapper<LiveHouse> query = new QueryWrapper<>();
        query.lambda().eq(LiveHouse::getHouseId, feeWater.getHouseId())
                .eq(LiveHouse::getUseStatus, 1);
        LiveHouse liveHouse = liveHouseService.getOne(query);
        if (liveHouse == null) {
            return Result.error(500, "该房间没有人使用，不能编辑水费");
        }
        //把查询出来的用户id设置到电费实体里面
        feeWater.setUserId(liveHouse.getUserId());
        feeWaterService.updateFeeWater(feeWater);
        return Result.success();
    }

    @ApiOperation("删除水费")
    @DeleteMapping("/{waterId}")
    public Result deleteFeeWater(@PathVariable("waterId") Integer waterId) {
        //如果已经缴费，就不能删除
        QueryWrapper<FeeWater> query = new QueryWrapper<>();
        query.lambda().eq(FeeWater::getWaterId, waterId)
                .eq(FeeWater::getPayWaterStatus, "1");
        FeeWater one = feeWaterService.getOne(query);
        if (one != null) {
            return Result.error(500, "已缴费，不能删除");
        }
        //删除操作
        boolean remove = feeWaterService.removeById(waterId);
        if (remove) {
            return Result.success();
        }
        return Result.error(500, "删除失败");
    }

    @ApiOperation("缴费")
    @PostMapping("/payWater")
    public Result payWater(@RequestBody FeeWater feeWater) {
        boolean b = feeWaterService.updateById(feeWater);
        if (b) {
            return Result.success();
        }
        return Result.error(500, "缴费失败");
    }
}
