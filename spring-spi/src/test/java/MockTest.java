import org.junit.jupiter.api.Test;
import org.lyflexi.springspi.MyTestService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

/**
 * @Description:
 * @Author: lyflexi
 * @project: spi-practice
 * @Date: 2024/11/4 10:41
 */
public class MockTest {
    
    @Test
    void test(){
        // 调用 SpringFactoriesLoader.loadFactories 方法加载 MyTestService 接口所有实现类的实例
        List<MyTestService> myTestServices = SpringFactoriesLoader.loadFactories(
                MyTestService.class,
                Thread.currentThread().getContextClassLoader()
        );

        for (MyTestService testService : myTestServices) {
            testService.printMylife();
        }
    }
}
