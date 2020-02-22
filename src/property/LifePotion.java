package property;

public class LifePotion extends Item {

    @Override
    public void effect() {
        System.out.println("血瓶使用后，可以回血");
    }
}
