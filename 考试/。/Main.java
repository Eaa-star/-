public class Main {
    public static void main(String[] args) {
        // 项目1测试
        System.out.println("=== 项目1测试 ===");
        
        // 创建动物对象
        Animal animal = new Animal(50.0);
        System.out.println("动物重量: " + animal.getWeight());
        animal.eat();
        
        // 创建鸟类对象
        Bird bird = new Bird("小燕子", 0.5);
        System.out.println("小鸟重量: " + bird.getWeight());
        bird.eat();
        
        // 创建鱼类对象
        Fish fish = new Fish("金鱼", 0.2);
        System.out.println("鱼重量: " + fish.getWeight());
        fish.eat();
        
        // 创建狗类对象
        Dog dog = new Dog("小狗", 10.0);
        System.out.println("狗重量: " + dog.getWeight());
        dog.eat();
        
        // 项目2测试
        System.out.println("\n=== 项目2测试 ===");
        
        // 多态测试
        Animal bird1 = new Bird("小燕子");
        Bird bird2 = new Bird("麻雀");
        
        // 使用bird1调用子类覆盖父类的方法
        bird1.breath();
        bird1.eat();
        bird1.sleep();
        
        // 使用bird2调用子类扩展的方法
        bird2.fly();
        
        // 狗类的play方法测试
        Dog myDog = new Dog("旺财", 15.0);
        Animal otherAnimal = new Animal(20.0);
        myDog.play(otherAnimal);
        
        // 测试所有动物的方法
        System.out.println("\n=== 所有动物方法测试 ===");
        Animal[] animals = {
            new Bird("鹦鹉", 0.8),
            new Fish("鲨鱼", 200.0),
            new Dog("拉布拉多", 25.0)
        };
        
        for (Animal a : animals) {
            a.eat();
            a.sleep();
            a.breath();
            System.out.println("重量: " + a.getWeight());
            System.out.println("---");
        }
        
        // 测试Bird特有的fly方法
        if (animals[0] instanceof Bird) {
            ((Bird) animals[0]).fly();
        }
    }
}