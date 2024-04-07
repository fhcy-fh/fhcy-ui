package top.fhcy.service;

import top.fhcy.entity.MemoryEnWord;

/**
 * @author fenghao
 */
public interface MemoryEnWordService {

    MemoryEnWord getById(Long id);

    Long countAll();
}
