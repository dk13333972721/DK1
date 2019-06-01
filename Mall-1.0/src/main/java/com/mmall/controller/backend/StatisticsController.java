package com.mmall.controller.backend;


import com.github.pagehelper.PageInfo;
import com.mmall.common.Const;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Order;
import com.mmall.pojo.User;
import com.mmall.service.IOrderService;
import com.mmall.service.IUserService;
import com.mmall.service.IProductService;
import com.mmall.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Objects;
@Controller
@RequestMapping("/manage/statistics")


public class StatisticsController {
    @Autowired
    IUserService iUserService;

    @Autowired
    IOrderService iOrderService;

    @Autowired
    IProductService iProductService;



    @ResponseBody
    @RequestMapping("searchincome.do") //按支付状态查询
    public ServerResponse searchStatus(HttpSession session){
        int status=20;
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (Objects.isNull(user)){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        if (iUserService.checkAdminRole(user).isSuccess()){
            return iOrderService.manageSearchs20(status);
        }
        return ServerResponse.createByError("无权限操作");
    }
    @ResponseBody
    @RequestMapping("searchuser.do") //按支付状态查询
    public ServerResponse searchUser(HttpSession session,int role){

        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (Objects.isNull(user)){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        if (iUserService.checkAdminRole(user).isSuccess()){
            return iUserService.getAllUsertype(role);
        }
        return ServerResponse.createByError("无权限操作");
    }
    @ResponseBody
    @RequestMapping("searchstock.do") //按支付状态查询
    public ServerResponse searchUser(HttpSession session){

        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (Objects.isNull(user)){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        if (iUserService.checkAdminRole(user).isSuccess()){
            return iProductService.searchStock();
        }
        return ServerResponse.createByError("无权限操作");
    }
}

