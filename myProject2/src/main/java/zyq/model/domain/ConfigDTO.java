package zyq.model.domain;

import lombok.Data;

/**
 * @author yanqing.zou
 * @date 2023-03-14 20:45
 * Description
 */
@Data
public class ConfigDTO {

    private Integer index;

    private Long startTime;

    private Long endTime;

    private Long playStartTime;

    private Long playEndTime;

    private Double potRate;
}
