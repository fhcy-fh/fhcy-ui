package top.fhcy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author fenghao
 */
@Data
@TableName("memory")
public class Memory {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String code;

    private String title;

    private String description;
}
