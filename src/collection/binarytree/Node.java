package collection.binarytree;

import java.util.ArrayList;
import java.util.List;

/*
    二叉树由节点组成，每个节点都可以有左子节点，右子节点
    每个节点都有一个值
    插入节点的基本逻辑为：<=插入左子节点，>插入右子节点
    中序遍历可按升序排序
 */
public class Node {
    //声明左右子节点、值
    private Node leftNode;
    private Node rightNode;
    private Object value;



    //插入数据
    public void add(Object v) {
        //判断当前节点是否有值，有的话判断新增值与当前值的大小关系
        if (null == this.value) {
            this.value = v;
        } else {
            if (((Integer) v - (Integer) this.value) <= 0) {
                //如果新增值小于等于当前值，判断是否存在左子节点
                //否则判断是否存在右子节点
                if (null == leftNode) {
                    this.leftNode = new Node();
                }
                this.leftNode.add(v);
            } else {
                if (null == rightNode) {
                    this.rightNode = new Node();
                }
                this.rightNode.add(v);
            }
        }
    }

    //中序遍历
    public List<Object> inorderTraversal() {
        List<Object> values = new ArrayList<>();

        //左子节点的遍历结果
        if (null != this.leftNode) {
            values.addAll(this.leftNode.inorderTraversal());
        }

        //当前节点
        values.add(this.value);

        //右子节点的遍历结果
        if (null != this.rightNode) {
            values.addAll(this.rightNode.inorderTraversal());
        }

        //返回最终的遍历结果
        return values;
    }
}
