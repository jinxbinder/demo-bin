package com.bin.feign;

import com.bin.api.service.MemberService;

import org.springframework.cloud.openfeign.FeignClient;



/**
 * ClassName: MemberFeign <br/>
 * Description: <br/>
 * date: 2019/12/16 22:31<br/>
 * feign接口远程调用
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
@FeignClient("member")
public interface MemberFeign extends MemberService {
}
