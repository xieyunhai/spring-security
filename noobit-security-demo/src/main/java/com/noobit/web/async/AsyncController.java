package com.noobit.web.async;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Random;
import java.util.concurrent.Callable;

@RestController
@Slf4j
public class AsyncController {

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

//    @RequestMapping("/order")
//    public String order() throws InterruptedException {
//        log.info("主线程开始");
//        Thread.sleep(1000);
//        log.info("主线程返回");
//        return "success";
//    }

    /**
     * Runnable 方式
     * @return
     */
//    @RequestMapping("/order")
//    public Callable<String> order() {
//        log.info("主线程开始");
//        Callable<String> result = () -> {
//            log.info("副线程开始");
//            Thread.sleep(2000);
//            log.info("副线程返回");
//            return "success";
//        };
//        log.info("主线程返回");
//        return result;
//    }

    @RequestMapping("/order")
    public DeferredResult<String> order() throws InterruptedException {
        log.info("主线程开始");
        String orderNo = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(orderNo);

        DeferredResult<String> result = new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNo, result);
        log.info("主线程返回");
        return result;
    }
}
