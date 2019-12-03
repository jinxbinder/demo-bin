import com.bin.common.entity.Demo1;
import com.bin.common.utils.ReflectionUtil;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * ClassName: ReflectionTest <br/>
 * Description: <br/>
 * date: 2019/11/29 14:24<br/>
 * 反射测试
 * @author libd<br />
 * @version 1.0
 * @since JDK 1.8
 */
@SpringBootTest
public class ReflectionTest {
    @Test
    public void rt() {

    }

    @Test
    public static void main(String[] args) {
        ReflectionUtil ru = new ReflectionUtil();
        Demo1 demo1 = new Demo1(2,"王五","qewr");
        System.out.println(ru.getFieldValue(demo1));
    }
}
