package top.fhcy.service;

import top.fhcy.entity.Memory;

/**
 * @author fenghao
 */
public interface MemoryService {

    Memory getById(Long id);

    Long countAll();

    void save(String title, String description);

    Boolean checkExistTitle(String title);
}
