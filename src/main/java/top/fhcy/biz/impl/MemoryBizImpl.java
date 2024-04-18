package top.fhcy.biz.impl;

import org.springframework.stereotype.Service;
import top.fhcy.biz.MemoryBiz;
import top.fhcy.dto.MemorySaveDto;
import top.fhcy.entity.Memory;
import top.fhcy.entity.MemoryEnWord;
import top.fhcy.service.MemoryEnWordService;
import top.fhcy.service.MemoryService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * @author fenghao
 */
@Service
public class MemoryBizImpl implements MemoryBiz {

    @Resource
    private MemoryEnWordService memoryEnWordService;

    @Resource
    private MemoryService memoryService;

    private Long index = 8L;

    @Override
    public Memory get() {
        Long total = memoryService.countAll();
        if (total < 1) {
            Memory memoryEnWord = new Memory();
            memoryEnWord.setTitle("NULL");
            memoryEnWord.setDescription("空数据");
            return memoryEnWord;
        }
        Random rand = new Random();
        Long id = rand.nextLong(total) + 1;

        if (index == 8L) {
            index = 9L;
        } else {
            index = 8L;
        }

        return memoryService.getById(index);
    }

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

    @Override
    public void save(MemorySaveDto memorySaveDto) {
        memoryService.save(memorySaveDto.getTitle(), memorySaveDto.getDescription());
    }
}
