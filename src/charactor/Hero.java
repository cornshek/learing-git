package charactor;
import property.Item;

public abstract class Hero {
    private String name;
    private float hp;
    private float armor;
    private int moveSpeed;

    public Hero() {
//        System.out.println("Hero 的无参构造方法");
    }

    public Hero(String name) {
//        System.out.println("Hero 有一个参数的构造方法");
        this.name = name;
    }

    public Hero(String name, float hp) {
        this.name = name;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public float getArmor() {
        return armor;
    }

    public void setArmor(float armor) {
        this.armor = armor;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public static void battleWin(){
        System.out.println("hero battle win");
    }

    //抽象类方法attack
    //Hero的子类会被要求实现attack方法
    public abstract void attack();
}
