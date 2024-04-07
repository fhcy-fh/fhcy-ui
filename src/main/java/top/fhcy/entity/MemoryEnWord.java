package top.fhcy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author fenghao
 */
@Data
@TableName("memory_en_word")
public class MemoryEnWord {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String enWord;

    private String description;

    private Long nextTime;
}
