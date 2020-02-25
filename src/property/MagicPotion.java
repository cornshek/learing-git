package property;

public class MagicPotion extends Item {
    public MagicPotion(String name) {
        super(name);
    }

    @Override
    public void effect() {
        System.out.println("蓝瓶使用后，可是回魔法");

    }
}
