package com.example.demo.pattern.responsibilitychain.demo2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ansonglin
 * @className LeaveRequest
 * @description 请假申请实体类
 * @date 2019/12/2 15:12
 * @cersion 1.0
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeaveRequest {

    /**请假天数**/
    private Integer LeaveDays;

    /**请假人姓名**/
    private String name;

}
   