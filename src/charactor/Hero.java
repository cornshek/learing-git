package charactor;

import property.Item;

import java.io.Serializable;

//Hero对象要保存在文件上，必需让Hero类实现Serializable接口
public class Hero implements Serializable, Comparable<Hero> {
    //serialVersionUID 表示这个类当前的版本，有了变化应该修改这个版本号
    private static final long serialVersionUID = 1L;
    private String name;
    private float hp;
    private float armor;
    private int moveSpeed;

    public Hero() {
    }

    @Override
    //若要升序，当前的大时返回正数
    //若要降序，反之
    public int compareTo(Hero h) {
        return (int) (this.getHp() - h.getHp());
    }

    @Override
    public String toString() {
        return "Hero{" +
                "hp=" + hp +
                ", armor=" + armor +
                '}';
    }

    public Hero(String name) {
        this.name = name;
    }

    public Hero(String name, float hp) {
        this.name = name;
        this.hp = hp;
    }

    public Hero(float hp, float armor) {
        this.hp = hp;
        this.armor = armor;
    }

    public Hero(String name, float hp, float armor, int moveSpeed) {
        this.name = name;
        this.hp = hp;
        this.armor = armor;
        this.moveSpeed = moveSpeed;
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

}
