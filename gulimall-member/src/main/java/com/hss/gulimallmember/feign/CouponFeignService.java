package com.hss.gulimallmember.feign;

import com.hss.common.utils.R;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient("gulimall-coupon")
public interface CouponFeignService {

    @RequestMapping("/gulimallcoupon/coupon/coupons")
    public R getCoupons();

}
