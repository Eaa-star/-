class Animal {
    private double weight;  // 重量
    
    // 构造方法
    public Animal() { }
    
    public Animal(double weight) {
        this.weight = weight;
    }
    
    // getter和setter方法
    public double getWeight() {
        return weight;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    // 吃方法
    public void eat() {
        System.out.println("我是动物，我爱吃。。。");
    }
    
    // 睡方法
    public void sleep() {
        System.out.println("动物在睡觉");
    }
    
    // 呼吸方法
    public void breath() {
        System.out.println("动物在呼吸");
    }
}