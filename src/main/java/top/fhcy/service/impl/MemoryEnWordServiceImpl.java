package top.fhcy.service.impl;

import org.springframework.stereotype.Service;
import top.fhcy.entity.MemoryEnWord;
import top.fhcy.mapper.MemoryEnWordMapper;
import top.fhcy.service.MemoryEnWordService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fenghao
 */
@Service
public class MemoryEnWordServiceImpl implements MemoryEnWordService {

    @Resource
    private MemoryEnWordMapper memoryEnWordMapper;

    @Override
    public List<MemoryEnWord> listAll() {
        return memoryEnWordMapper.selectList(null);
    }

    @Override
    public MemoryEnWord getById(Long id) {
        return memoryEnWordMapper.selectById(id);
    }

    @Override
    public Long countAll() {
        return memoryEnWordMapper.selectCount(null);
    }
}
