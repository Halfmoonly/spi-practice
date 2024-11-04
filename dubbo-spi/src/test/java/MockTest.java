import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.jupiter.api.Test;
import org.lyflexi.spipractice.Robot;

/**
 * @Description:
 * @Author: lyflexi
 * @project: spi-practice
 * @Date: 2024/11/4 11:08
 */
public class MockTest {
    @Test
    void test() throws Exception{
        ExtensionLoader<Robot> extensionLoader =
                ExtensionLoader.getExtensionLoader(Robot.class);
        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();
        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.sayHello();
    }
}
