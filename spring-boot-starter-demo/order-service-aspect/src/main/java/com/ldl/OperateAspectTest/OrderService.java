package com.ldl.OperateAspectTest;

import org.springframework.stereotype.Service;

/**
 * 1.定义注解
 * 2.定义切面
 *  2.1 定义切入点
 *  2.2 横切逻辑
 *  2.3 植入
 */
@Service
public class OrderService {

    @RecordOperate(desc = "保存", convert = SaveOrderConvert.class)
    public Boolean saveOrder(SaveOrder saveOrder) {
        System.out.println("save order ,orderId:" + saveOrder.getId());
        return true;
    }
    @RecordOperate(desc = "更新", convert = UpdateOrderConvert.class)
    public Boolean updateOrder(UpdateOrder updateOrder) {
        System.out.println("update order ,orderId:" + updateOrder.getOrderId());
        return true;
    }

}













