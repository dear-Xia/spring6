import com.spring6.fristProject.test.bean.HelloWorld.Student;
import com.spring6.fristProject.test.bean.HelloWorld.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring6.fristProject.test.bean.HelloWorld.helloWorld;

public class test {
    @Test
    public void testHelloWorld(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("springs.xml");
        helloWorld helloworld = (helloWorld) ac.getBean("helloWorld");
        helloworld.sayHello();
    }

    @Test
    public  void tests(){
        // dom4j解析beans.xml文件，从中获取class属性值，类的全类名
        // 通过反射机制调用无参数构造方法创建对象
        try {
            Class clazz = Class.forName("com.spring6.fristProject.test.bean.HelloWorld.helloWorld");
            //Object obj = clazz.newInstance();
            Object object = clazz.getDeclaredConstructor().newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testBean1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springs.xml");
        helloWorld bean = context.getBean(helloWorld.class);
        bean.sayHello();
    }
    @Test
    public void testBean2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springs.xml");
        helloWorld bean1 = context.getBean("helloWorld", helloWorld.class);
        bean1.sayHello();
    }

    @Test
    public void testDIByConstructor(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("springs.xml");
        Student studentOne = ac.getBean("studentTwo", Student.class);
        System.out.println(studentOne);
    }

    @Test
    public void testAnnotation(){
        ApplicationContext context = new ClassPathXmlApplicationContext("springs.xml");
        UserController userController = context.getBean("userController", UserController.class);
        userController.out();
        //logger.info("执行成功");
    }
}
