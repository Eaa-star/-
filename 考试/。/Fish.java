class Fish extends Animal {
    private String name;
    
    public Fish(String name) {
        this.name = name;
    }
    
    public Fish(String name, double weight) {
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
        System.out.println(name + " The Fish breath");
    }
    
    @Override
    public void eat() {
        System.out.println(name + " The Fish eat");
    }
    
    @Override
    public void sleep() {
        System.out.println(name + " The Fish sleep");
    }
}