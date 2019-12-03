import com.bin.api.service.impl.MyDemoServiceImpl;
import com.bin.common.api.BaseApiService;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

/**
 * ClassName: test1 <br/>
 * Description: <br/>
 * date: 2019/11/21 13:58<br/>
 * 测试类
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
@SpringBootTest
public class test1 {
    @Test
    public static void main(String[] args) {
        //BaseApiService bs = new BaseApiService();
       // System.out.println(bs.setSuccess());
        MyDemoServiceImpl msi = new MyDemoServiceImpl();
        System.out.println(msi.demo());
    }

}
