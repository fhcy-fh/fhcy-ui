package top.fhcy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 艾宾浩斯记忆曲线
 *
 * @author fenghao
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public enum MemoryTimeCycleEnum {

    CYCLE_5(5), // 5分钟
    CYCLE_30(30), // 30分钟
    CYCLE_720(720), // 12小时
    CYCLE_1440(1440), // 1天
    CYCLE_2880(2880), // 2天
    CYCLE_5760(5760), // 4天
    CYCLE_10080(10080), // 7天
    CYCLE_21600(21600), // 15天
    ;

    private Integer cycle;
}
