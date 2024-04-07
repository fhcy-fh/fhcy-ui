package top.fhcy.service.impl;

import org.springframework.stereotype.Service;
import top.fhcy.entity.MemoryEnWord;
import top.fhcy.mapper.MemoryEnWordMapper;
import top.fhcy.service.MemoryEnWordService;

import javax.annotation.Resource;

/**
 * @author fenghao
 */
@Service
public class MemoryEnWordServiceImpl implements MemoryEnWordService {

    @Resource
    private MemoryEnWordMapper memoryEnWordMapper;

    @Override
    public MemoryEnWord getById(Long id) {
        return memoryEnWordMapper.selectById(id);
    }

    @Override
    public Long countAll() {
        return memoryEnWordMapper.selectCount(null);
    }
}
