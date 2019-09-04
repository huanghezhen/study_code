package hhz.linkedlist;

/**
 * @ClassName: SingleLinkedListInterview
 * @Description: 单链表面试题
 * @author: huanghz
 * @date: 2019/7/2 18:35
 */
public class SingleLinkedListInterview
{
    public static void main(String[] args)
    {
        SingleLinkedListNode node01 = new SingleLinkedListNode(1, "");
        SingleLinkedListNode node02 = new SingleLinkedListNode(2, "");
        SingleLinkedListNode node04 = new SingleLinkedListNode(4, "");
        SingleLinkedListNode node03 = new SingleLinkedListNode(3, "");

        ManageSingleLinkedListNode mainNode = new ManageSingleLinkedListNode();
        mainNode.add(node01);
        mainNode.add(node02);
        mainNode.add(node03);
        mainNode.add(node04);
        mainNode.show();

        System.out.println();
        System.out.println("获取节点的个数(没有统计头节点)");
        System.out.println(getLength(mainNode.getHead()));

        System.out.println();
        System.out.println("获取单链表中倒数第index个节点");
        System.out.println(getReciprocalNode(mainNode.getHead(),2));

        System.out.println();
        System.out.println("节点的反转");
        rollbackNode(mainNode.getHead());
        mainNode.show();

    }

    /**
     * 节点的反转
     * 思路：
     * 先定义一个新的头节点，作为反转后的链表
     * 从头到尾遍历原节点，将其取出，并放在新链表的头部
     * 将原链表的next指向新链表的next
     * @param head
     */
    public static void rollbackNode(SingleLinkedListNode head)
    {
        SingleLinkedListNode tmp = head.getNextNode();
        SingleLinkedListNode newHead = new SingleLinkedListNode(0, "");
        while (tmp != null)
        {
            // 获取当前节点
            SingleLinkedListNode tmp1 = tmp;
            // 获取下一个节点
            tmp = tmp.getNextNode();
            // 将节点插入第一个位置
            tmp1.setNextNode(newHead.getNextNode());
            newHead.setNextNode(tmp1);
        }
        head.setNextNode(newHead.getNextNode());
    }
    public static void rollbackNode1(SingleLinkedListNode head)
    {
        // 获取当前节点，就是需要插入到新链表的节点
        SingleLinkedListNode cur = head.getNextNode();
        // 获取下一个节点，
        SingleLinkedListNode next;
        // 定义新链表的头节点
        SingleLinkedListNode newHead = new SingleLinkedListNode(0, "");
        // 遍历节点
        while (cur != null)
        {
            // 先获取下一个节点
            next = cur.getNextNode();
            // 将新链表的头节点的下一个节点赋值给需要插入节点的下一个节点
            cur.setNextNode(newHead.getNextNode());
            // 将需要插入的节点赋值给头节点的下一个节点
            newHead.setNextNode(cur);
            // 再将下一个节点赋值给当然节点，进行下一次循环
            cur = next;
        }
        // 将新链表的头节点下一个节点赋值给旧链表的头节点的下一个节点
        head.setNextNode(newHead.getNextNode());
    }

    /**
     * 获取单链表中倒数第index个节点
     * @param head 头节点
     * @param index 倒数第index节点
     * @return
     */
    public static SingleLinkedListNode getReciprocalNode(SingleLinkedListNode head,int index)
    {
        int size = getLength(head);
        int n = size-index;
        if (n < 0)
        {
            System.out.println("超出链表范围");
        }
        SingleLinkedListNode tmp = head;
        for (int i = 0; i <= n; i++)
        {
            tmp = tmp.getNextNode();
        }
        return tmp;
    }


    /**
     * 获取节点的个数
     * @param head
     * @return
     */
    public static int getLength(SingleLinkedListNode head)
    {
        int sum = 0;
        if (head.getNextNode() == null)
        {
            return sum;
        }
        SingleLinkedListNode tmp = head.getNextNode();
        while (tmp != null)
        {
            sum++;
            tmp = tmp.getNextNode();
        }
        return sum;
      /*  while (true)
        {
            if (tmp == null)
            {
                break;
            }
            sum++;
            tmp = tmp.getNextNode();
        }*/
    }
}
