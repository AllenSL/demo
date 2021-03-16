package com.example.demo.pattern.responsibilitychain.demo2;

/**
 * @author ansonglin
 * @className AbstractLeaveHandler
 * @description 请假责任链抽象处理类
 * @date 2019/12/2 15:15
 * @cersion 1.0
 **/
public abstract class AbstractLeaveHandler {

    /**
     * 直接主管处理的请假天数
     **/
    protected Integer min = 1;

    /**
     * 部门经理处理的请假天数
     **/
    protected Integer middle = 3;

    /**
     * 总经理处理的请假天数
     **/
    protected Integer max = 30;

    /**
     * 处理者名字
     **/
    protected String handlerName;

    /**
     * 下一个处理者（级别更高的领导）
     **/
    protected AbstractLeaveHandler nextHandler;

    protected void setNextHandler(AbstractLeaveHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    protected abstract boolean handleLeaveRequest(LeaveRequest leaveRequest);
}
   