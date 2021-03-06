package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.vo.OrderVo;

import java.math.BigDecimal;
import java.util.Map;

public interface IOrderService {

    ServerResponse createOrder(Integer userId, Integer shippingId);

    ServerResponse pay(Long orderNo, Integer userId, String path);

    ServerResponse checkOrderInfo(Map<String, String> params);

    ServerResponse queryOrderStatus(Integer userId,Long orderNo);

    ServerResponse cancelOrder(Integer userId, Long orderNo);
    ServerResponse cancelOrdera( Long orderNo);
    ServerResponse updateOrder(Long orderNo, BigDecimal payment);


    ServerResponse getOrderCartProduct(Integer userId);

    ServerResponse<OrderVo> getOrderDetail(Integer userId, Long orderNo);

    ServerResponse list(Integer userId, Integer pageNum, Integer pageSize);

    //BACKEND
    ServerResponse<PageInfo> manageList(int pageNum, int pageSize);


    ServerResponse<OrderVo> manageDetail(Long orderNo);

    ServerResponse<PageInfo> manageSearch(Long orderNo, int pageNum, int pageSize);
  ServerResponse<PageInfo> manageSearchs(int status, int pageNum, int pageSize);
  ServerResponse<String> manageSearchs20(int status);
    ServerResponse<PageInfo> managedelete(Long orderNo, int pageNum, int pageSize);
    //ServerResponse<PageInfo> manageupdatep(Long orderNo, int pageNum, int pageSize)

    ServerResponse<String> manageSendGoods(Long orderNo);

    ServerResponse<PageInfo> SearchUserIdAndStatus(int userId, int status, int pageNum, int pageSize);
}
