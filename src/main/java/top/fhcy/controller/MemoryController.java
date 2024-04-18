package top.fhcy.controller;

import org.springframework.web.bind.annotation.*;
import top.fhcy.biz.MemoryBiz;
import top.fhcy.dto.MemorySaveDto;
import top.fhcy.utils.Result;

import javax.annotation.Resource;

/**
 * @author fenghao
 */
@RestController
@RequestMapping("/memory")
public class MemoryController {

    @Resource
    private MemoryBiz memoryBiz;

    @GetMapping("/sync")
    public Result<String> sync() {
        memoryBiz.sync();
        return Result.success();
    }

    @PostMapping("/save")
    public Result<String> save(@RequestBody MemorySaveDto memorySaveDto) {
        memoryBiz.save(memorySaveDto);
        return Result.success();
    }
}
