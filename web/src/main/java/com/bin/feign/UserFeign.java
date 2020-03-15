package com.bin.feign;

import com.bin.api.service.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * ClassName: UserFeign <br/>
 * Description: <br/>
 * date: 2020/3/13 21:52<br/>
 *
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
@FeignClient("user")
public interface UserFeign extends UserApi {
}
