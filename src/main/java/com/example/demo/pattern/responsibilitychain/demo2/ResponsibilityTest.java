package com.example.demo.pattern.responsibilitychain.demo2;

/**
 * @author ansonglin
 * @className ResponsibilityTest
 * @description 责任链设计模式测试类（审批流业务场景）
 * @date 2019/12/2 15:54
 * @cersion 1.0
 **/
public class ResponsibilityTest {
    public static void main(String[] args) {
        LeaveRequest leaveRequest = LeaveRequest.builder().LeaveDays(1).name("小明").build();
        DirectLeaderLeaveHandler directLeaderLeaveHandler = new DirectLeaderLeaveHandler("县令");
        DeptManagerLeaveHandler deptManagerLeaveHandler = new DeptManagerLeaveHandler("知府");
        GManagerLeaveHandler gManagerLeaveHandler = new GManagerLeaveHandler("京兆尹");

        directLeaderLeaveHandler.setNextHandler(deptManagerLeaveHandler);
        deptManagerLeaveHandler.setNextHandler(gManagerLeaveHandler);

        directLeaderLeaveHandler.handleLeaveRequest(leaveRequest);
    }
}
   