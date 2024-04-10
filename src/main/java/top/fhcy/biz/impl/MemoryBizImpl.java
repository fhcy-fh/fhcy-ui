package top.fhcy.biz.impl;

import org.springframework.stereotype.Service;
import top.fhcy.biz.MemoryBiz;
import top.fhcy.entity.MemoryEnWord;
import top.fhcy.service.MemoryEnWordService;
import top.fhcy.service.MemoryService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fenghao
 */
@Service
public class MemoryBizImpl implements MemoryBiz {

    @Resource
    private MemoryEnWordService memoryEnWordService;

    @Resource
    private MemoryService memoryService;

    @Override
    public void sync() {
        List<MemoryEnWord> memoryEnWordList = memoryEnWordService.listAll();
        memoryEnWordList.forEach(item -> {
            boolean exist = memoryService.checkExistTitle(item.getEnWord());
            if (!exist) {
                memoryService.save(item.getEnWord(), item.getDescription());
            }
        });
    }
}
