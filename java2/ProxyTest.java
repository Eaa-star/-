package java2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


interface Person {
    void study();
    void sleep();
}

class StudentImpl implements Person {
    @Override
    public void study() {
        System.out.println("学生正在努力学习 Java 反射技术");
    }

    @Override
    public void sleep() {
        System.out.println("学生学累了，正在睡觉...");
    }
}

// 3. 代理处理器类 (实现 InvocationHandler)
class MyInvocationHandler implements InvocationHandler {
    // 维护一个目标对象（真实对象）
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 执行代理对象的任何方法时，都会执行此 invoke 方法
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("【代理增强】：方法 " + method.getName() + " 开始执行...");

        // 执行目标对象的方法 (这里是真正的业务逻辑)
        Object result = method.invoke(target, args);

        System.out.println("【代理增强】：方法 " + method.getName() + " 执行结束。");
        return result;
    }
}

// 4. 测试类
public class ProxyTest {
    public static void main(String[] args) {
        System.out.println("=== 动态代理演示 ===");

        // 1. 创建真实对象
        Person realStudent = new StudentImpl();

        // 2. 创建 InvocationHandler
        MyInvocationHandler handler = new MyInvocationHandler(realStudent);

        // 3. 生成代理对象
        // 参数1：类加载器；参数2：代理类要实现的接口；参数3：调用处理器
        Person proxyStudent = (Person) Proxy.newProxyInstance(
                realStudent.getClass().getClassLoader(),
                realStudent.getClass().getInterfaces(),
                handler
        );

        // 4. 调用代理对象的方法 (实际会执行 handler 里的 invoke 方法)
        System.out.println("\n--- 调用 study 方法 ---");
        proxyStudent.study();

        System.out.println("\n--- 调用 sleep 方法 ---");
        proxyStudent.sleep();
    }
}

