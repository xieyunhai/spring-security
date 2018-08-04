package com.noobit.web.async;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Data
@Component
@Slf4j
public class MockQueue {
    /* 代表下单消息 */
    private String placeOrder;
    /* 代表订单完成的消息 */
    private String completeOrder;

    public void setPlaceOrder(String placeOrder) {
        new Thread(() -> {
            log.info("接到下单请求, " + placeOrder);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.completeOrder = placeOrder;
            log.info("下单请求完成, " + placeOrder);
        }).start();
    }
}
