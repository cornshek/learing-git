package collection.binarytree;

import charactor.Hero;

import java.util.ArrayList;
import java.util.List;

public class HeroNode {
    private HeroNode leftNode;
    private HeroNode rightNode;
    private Hero value;



    //往Hero二叉树中插入数据
    public void add(Hero h) {
        //判断当前节点value是否为空，若不为空则判断与其大小关系
        if (null == this.value) {
            this.value = h;
            //用Hero的HP来判断大小
        } else if ((h.getHp() - this.value.getHp()) <= 0) {
            //小于当前节点的值，判断是否存在左子节点
            if (null == this.leftNode) {
                this.leftNode = new HeroNode();
            }
            this.leftNode.add(h);
        } else {
            if (null == this.rightNode) {
                //大于当前节点的值，判断是否存在右子节点
                this.rightNode = new HeroNode();
            }
            this.rightNode.add(h);
        }
    }

    //中序遍历二叉树
    public List<Hero> inorderTraversal() {
        List<Hero> values = new ArrayList<>();

        //将左子节点遍历的结果插入列表values
        if (null != this.leftNode) {
            values.addAll(this.leftNode.inorderTraversal());
        }

        //将当前节点插入列表values
        values.add(value);

        //将右子节点遍历的结果插入列表values
        if (null != this.rightNode) {
            values.addAll(this.rightNode.inorderTraversal());
        }

        //返回中序遍历的结果
        return values;
    }
}


