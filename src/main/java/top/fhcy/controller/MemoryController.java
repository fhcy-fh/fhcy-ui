package top.fhcy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fhcy.biz.MemoryBiz;
import top.fhcy.utils.Result;

import javax.annotation.Resource;

/**
 * @author fenghao
 */
@RestController
public class MemoryController {

    @Resource
    private MemoryBiz memoryBiz;

    @GetMapping("/sync")
    public Result<String> sync() {
        memoryBiz.sync();
        return Result.success();
    }
}
