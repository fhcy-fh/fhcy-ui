package top.fhcy.service;

/**
 * @author fenghao
 */
public interface MemoryService {

    void save(String title, String description);

    Boolean checkExistTitle(String title);
}
