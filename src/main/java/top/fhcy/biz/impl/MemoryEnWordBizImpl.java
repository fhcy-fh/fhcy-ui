package top.fhcy.biz.impl;

import org.springframework.stereotype.Service;
import top.fhcy.biz.MemoryEnWordBiz;
import top.fhcy.entity.MemoryEnWord;
import top.fhcy.service.MemoryEnWordService;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author fenghao
 */
@Service
public class MemoryEnWordBizImpl implements MemoryEnWordBiz {

    @Resource
    private MemoryEnWordService memoryEnWordService;

    @Override
    public MemoryEnWord getEnWord() {
        Long total = memoryEnWordService.countAll();
        if (total < 1) {
            MemoryEnWord memoryEnWord = new MemoryEnWord();
            memoryEnWord.setEnWord("NULL");
            memoryEnWord.setDescription("空数据");
            return memoryEnWord;
        }
        Random rand = new Random();
        Long id = rand.nextLong(total) + 1;
        return memoryEnWordService.getById(id);
    }
}
