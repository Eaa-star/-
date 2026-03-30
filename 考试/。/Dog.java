class Dog extends Animal {
    private String name;
    
    public Dog(String name) {
        this.name = name;
    }
    
    public Dog(String name, double weight) {
        super(weight);
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public void breath() {
        System.out.println(name + " The Dog breath");
    }
    
    @Override
    public void eat() {
        System.out.println(name + " The Dog eat");
    }
    
    @Override
    public void sleep() {
        System.out.println(name + " The Dog sleep");
    }
    
    public void play(Animal animal) {
        animal.eat();
        System.out.println("Animal的重量是: " + animal.getWeight());
    }
}