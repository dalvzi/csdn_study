package com.ldl;

import com.ldl.OperateAspectTest.OrderService;
import com.ldl.OperateAspectTest.SaveOrder;
import com.ldl.OperateAspectTest.UpdateOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication
@EnableAspectJAutoProxy
public class App implements CommandLineRunner {

    public static void main(String[] args) {
        new SpringApplication(App.class).run(args);
    }
    @Autowired
    private OrderService orderService;

    @Override
    public void run(String... args) throws Exception {
        SaveOrder saveOrder = new SaveOrder();
        saveOrder.setId(1L);
        orderService.saveOrder(saveOrder);

        UpdateOrder updateOrder = new UpdateOrder();
        updateOrder.setOrderId(2L);
        orderService.updateOrder(updateOrder);
    }
}
