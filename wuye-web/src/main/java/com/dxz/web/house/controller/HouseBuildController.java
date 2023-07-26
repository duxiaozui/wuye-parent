package com.dxz.web.house.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dxz.utils.Result;
import com.dxz.web.house.entity.HouseBuild;
import com.dxz.web.house.param.HouseBuildParam;
import com.dxz.web.house.service.IHouseBuildService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 楼栋表 前端控制器
 * </p>
 *
 * @author 嘟小嘴
 * @since 2023-07-26
 */
@RestController
@RequestMapping("/api/build")
@Api(tags = "楼栋管理")
public class HouseBuildController {
    @Autowired
    private IHouseBuildService houseBuildService;

    @ApiOperation("楼栋列表")
    @GetMapping("list")
    public Result list(HouseBuildParam param) {
        IPage<HouseBuild> page = houseBuildService.getList(param);
        return Result.success(page);
    }

    @ApiOperation("查看所有楼栋信息,添加单元信息需要")
    @GetMapping("/findAll")
    public Result findAll() {
        List<HouseBuild> list = houseBuildService.list();
        return Result.success(list);
    }

    @ApiOperation("添加楼栋")
    @PostMapping
    public Result addHouseBuild(@RequestBody HouseBuild houseBuild) {
        boolean save = houseBuildService.save(houseBuild);
        if (save) {
            return Result.success();
        }
        return Result.error(500, "添加失败");
    }

    @ApiOperation("修改楼栋")
    @PutMapping
    public Result editHouseBuild(@RequestBody HouseBuild houseBuild) {
        boolean update = houseBuildService.updateById(houseBuild);
        if (update) {
            return Result.success();
        }
        return Result.error(500, "修改失败");
    }

    @ApiOperation("删除楼栋")
    @DeleteMapping("/{buildId}")
    public Result deleteHouseBuild(@PathVariable("buildId") Integer buildId) {
        boolean delete = houseBuildService.removeById(buildId);
        if (delete) {
            return Result.success();
        }
        return Result.error(500, "删除失败");
    }
}
