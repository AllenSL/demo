package com.example.demo.pattern.responsibilitychain.demo2;

/**
 * @author ansonglin
 * @className DeptManagerLeaveHandler
 * @description 部门经理请假处理类
 * @date 2019/12/2 15:51
 * @cersion 1.0
 **/
public class DeptManagerLeaveHandler extends AbstractLeaveHandler {

    public DeptManagerLeaveHandler(String name) {
        this.handlerName = name;
    }

    @Override
    protected boolean handleLeaveRequest(LeaveRequest leaveRequest) {
        if (leaveRequest.getLeaveDays() <= this.middle) {
            System.out.println("部门经理:" + handlerName + ",已经处理;流程结束。");
            return true;
        }

        if (null != this.nextHandler) {
            nextHandler.handleLeaveRequest(leaveRequest);
        } else {
            System.out.println("部门经理: " + handlerName + "审批拒绝！");
        }

        return true;
    }
}
   