package top.fhcy.service;

import top.fhcy.entity.MemoryEnWord;

import java.util.List;

/**
 * @author fenghao
 */
public interface MemoryEnWordService {

    List<MemoryEnWord> listAll();

    MemoryEnWord getById(Long id);

    Long countAll();
}
