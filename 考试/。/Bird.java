class Bird extends Animal {
    private String name;
    
    public Bird(String name) {
        this.name = name;
    }
    
    public Bird(String name, double weight) {
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
        System.out.println(name + " The Bird breath");
    }
    
    @Override
    public void eat() {
        System.out.println(name + " The Bird eat");
    }
    
    @Override
    public void sleep() {
        System.out.println(name + " The Bird sleep");
    }
    
    public void fly() {
        System.out.println(name + " The Bird fly");
    }
}