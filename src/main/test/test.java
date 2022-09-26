import com.itheima.case2.service.UserService;
import com.itheima.case2.utils.BeanFactory;
import org.junit.Test;

public class test {
    @Test
    public void test(){
        UserService userService = (UserService) BeanFactory.getBean("userService");
        System.out.println(userService.toString());
    }
}
