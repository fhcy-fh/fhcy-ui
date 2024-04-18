package top.fhcy.biz;

import top.fhcy.dto.MemorySaveDto;
import top.fhcy.entity.Memory;

/**
 * @author fenghao
 */
public interface MemoryBiz {

    Memory get();

    void sync();

    void save(MemorySaveDto memorySaveDto);
}
