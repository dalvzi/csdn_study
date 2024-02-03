package com.ldl.OperateAspectTest;

public class SaveOrderConvert implements Convert<SaveOrder> {

    @Override
    public OperateLogDo convert(SaveOrder saveOrder) {
        OperateLogDo operateLogDo = new OperateLogDo();
        operateLogDo.setOrderId(saveOrder.getId());
        return operateLogDo;
    }
}