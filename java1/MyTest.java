package java1;

// 1. 定义 Student 类（注意：为了省事写在同一个文件且不加 public，或者新建文件不加 public）
class Student {
    private String name; // 私有属性
    private int age;     // 私有属性

    // 无参构造
    public Student() {
    }

    // 有参构造
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter 和 Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void answer() {
        System.out.println("大家好，我是 " + name + "，今年 " + age + " 岁。");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

// 2. 主测试类
public class MyTest {
    public static void main(String[] args) throws Exception {
        System.out.println("=== 开始演示 Java 反射技术 ===");

        // 1. 利用反射生成实例 (代替 new Student())
        System.out.println("\n1. 正在通过反射创建对象...");
        // 加载类
        Class<?> studentClass = Class.forName("person.homework.Student");
        // 获取带参数的构造器 (String, int)
        java.lang.reflect.Constructor<?> constructor = studentClass.getConstructor(String.class, int.class);
        // 通过构造器创建实例
        Object obj = constructor.newInstance("张三", 18);

        System.out.println("原始对象信息: " + obj);

        // 2. 反射修改成员变量 (修改私有的 age)
        System.out.println("\n2. 正在通过反射修改私有属性...");
        java.lang.reflect.Field ageField = studentClass.getDeclaredField("age");
        // 暴力反射：解除私有限制 (关键步骤)
        ageField.setAccessible(true);
        // 修改对象 obj 的 age 值为 25
        ageField.set(obj, 25);

        System.out.println("修改后对象信息: " + obj);

        // 3. 反射调用成员方法
        System.out.println("\n3. 正在通过反射调用方法...");
        java.lang.reflect.Method method = studentClass.getMethod("answer");
        method.invoke(obj); // 执行 answer() 方法

        System.out.println("\n=== 演示结束 ===");
    }
}
