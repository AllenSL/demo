package com.example.demo.pattern.responsibilitychain.demo2;

/**
 * @author ansonglin
 * @className DirectLeaderLeaveHandler
 * @description 直接主管请假处理类
 * @date 2019/12/2 15:25
 * @cersion 1.0
 **/
public class DirectLeaderLeaveHandler extends AbstractLeaveHandler {

    public DirectLeaderLeaveHandler(String name) {
        this.handlerName = name;
    }

    @Override
    protected boolean handleLeaveRequest(LeaveRequest leaveRequest) {
        if (leaveRequest.getLeaveDays() <= this.min) {
            System.out.println("直接主管:" + handlerName + ",已经处理;流程结束。");
            return true;
        }

        if (null != this.nextHandler) {
            nextHandler.handleLeaveRequest(leaveRequest);
        } else {
            System.out.println("直接主管: 审批拒绝！");
        }

        return true;
    }
}
   