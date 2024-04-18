package top.fhcy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import top.fhcy.entity.Memory;
import top.fhcy.mapper.MemoryMapper;
import top.fhcy.service.MemoryService;
import top.fhcy.utils.CodeUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fenghao
 */
@Service
public class MemoryServiceImpl implements MemoryService {

    @Resource
    private MemoryMapper memoryMapper;

    @Override
    public Memory getById(Long id) {
        return memoryMapper.selectById(id);
    }

    @Override
    public Long countAll() {
        return memoryMapper.selectCount(null);
    }

    @Override
    public void save(String title, String description) {
        if (StringUtils.isBlank(title)) {
            return;
        }
        Memory memory = new Memory();
        memory.setCode(CodeUtils.getUuid());
        memory.setTitle(title);
        memory.setDescription(description);
        try {
            memoryMapper.insert(memory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Boolean checkExistTitle(String title) {
        if (StringUtils.isBlank(title)) {
            return false;
        }
        LambdaQueryWrapper<Memory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Memory::getTitle, title);
        List<Memory> memoryList = memoryMapper.selectList(queryWrapper);
        return CollectionUtils.isNotEmpty(memoryList);
    }
}
