package com.shivbhakt.shivbhakt.serviceImpl;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.shivbhakt.shivbhakt.entity.MyOrder;
import com.shivbhakt.shivbhakt.payload.MyOrderDto;
import com.shivbhakt.shivbhakt.repository.MyOrderRepository;
import com.shivbhakt.shivbhakt.service.MyOrderService;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyOrderServiceImpl implements MyOrderService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private MyOrderRepository myOrderRepository;
    @Override
    public MyOrderDto createOrder(Integer amount) {

        try {
            var client = new RazorpayClient("rzp_test_yAbw3tTnVxxsiy", "p8IhNgl3CQthryQIjY2NP4pZ");
            JSONObject orderRequest = new JSONObject();
            orderRequest.put("amount", amount); // amount in the smallest currency unit
            orderRequest.put("currency", "INR");
            orderRequest.put("receipt", "order_rcptid_11");

            Order order = client.orders.create(orderRequest);

            MyOrder myOrder= new MyOrder();
            myOrder.setAmount(order.get("amount"));
            myOrder.setCurrency(order.get("currency"));
            myOrder.setReceipt(order.get("receipt"));
            myOrder.setPaymentId(null);
            myOrder.setStatus(order.get("status"));
            myOrder.setAttempts(1);

            MyOrder saveMyOrder=this.myOrderRepository.save(myOrder);
            MyOrderDto myOrderDto=this.modelMapper.map(saveMyOrder,MyOrderDto.class);
            return myOrderDto;
        } catch (RazorpayException e) {
            // Handle Exception
            System.out.println(e.getMessage());
        }
        return null;
    }
}
