package charactor;

public class ADHero extends Hero {
    public static void battleWin(){

    }

    public ADHero() {
//        System.out.println("AD Hero 的构造方法");
    }

    public ADHero(String name) {
        super(name);
//        System.out.println("AD Hero 有一个参数的构造方法");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("这个对象正在被回收");
    }

    @Override
    public void attack() {

    }

    public static void main(String[] args) {

    }
}
