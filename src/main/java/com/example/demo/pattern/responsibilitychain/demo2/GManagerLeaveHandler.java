package com.example.demo.pattern.responsibilitychain.demo2;

/**
 * @author ansonglin
 * @className GManagerLeaveHandler
 * @description 总经理请假处理类
 * @date 2019/12/2 15:52
 * @cersion 1.0
 **/
public class GManagerLeaveHandler extends AbstractLeaveHandler {

    public GManagerLeaveHandler(String name) {
        this.handlerName = name;
    }

    @Override
    protected boolean handleLeaveRequest(LeaveRequest leaveRequest) {
        if (leaveRequest.getLeaveDays() <= this.max) {
            System.out.println("总经理:" + handlerName + ",已经处理;流程结束。");
            return true;
        }

        if (null != this.nextHandler) {
            nextHandler.handleLeaveRequest(leaveRequest);
        } else {
            System.out.println("总经理: 审批拒绝！");
        }

        return true;
    }
}
   