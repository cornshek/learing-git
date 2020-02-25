package property;

public class LifePotion extends Item {

    public LifePotion(String name) {
        super(name);
    }

    @Override
    public void effect() {
        System.out.println("血瓶使用后，可以回血");
    }
}
