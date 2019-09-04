package hhz.linkedlist;

/**
 * @ClassName: SingleLinkedList
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/2 16:00
 */
public class SingleLinkedList
{
    public static void main(String[] args)
    {
        // 插入节点
        System.out.println("插入节点");
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

        // 有序的插入节点
        System.out.println("有序的插入节点");
        ManageSingleLinkedListNode mainNode1 = new ManageSingleLinkedListNode();
        mainNode1.addSort(node01);
        mainNode1.addSort(node04);
        mainNode1.addSort(node02);
        mainNode1.addSort(node03);
        mainNode1.show();

        System.out.println();

        // 更新节点
        System.out.println("更新节点3");
        SingleLinkedListNode node05 = new SingleLinkedListNode(3, "node05");
        mainNode1.updateNode(node05);
        mainNode1.show();

        System.out.println();

        // 删除节点
        System.out.println("删除节点");
        mainNode1.deleteNode(1);
        mainNode1.show();

    }
}

class ManageSingleLinkedListNode
{
    private SingleLinkedListNode head = new SingleLinkedListNode(0, "");

    public SingleLinkedListNode getHead()
    {
        return head;
    }

    /**
     * 删除节点的时候需要注意的是要获取下一个节点是需要删除的节点的节点
     * @param n
     */
    public void deleteNode(int n)
    {
        SingleLinkedListNode tmp = head;
        while (true)
        {
            if (tmp.getNextNode() == null)
            {
                // 如果链表中的节点的下一个节点为空，则说明不存在需要删除的节点
                System.out.println("不存在该节点");
                return;
            }
            else if (tmp.getNextNode().getNo() == n)
            {
                // 获取与需要修改一样no的节点
                break;
            }
            tmp = tmp.getNextNode();
        }
        tmp.setNextNode(tmp.getNextNode().getNextNode());
    }

    public void updateNode(SingleLinkedListNode node)
    {
        if (head.getNextNode() == null)
        {
            System.out.println("链表为空");
            return;
        }
        SingleLinkedListNode tmp = head.getNextNode();
        while (true)
        {
            if (tmp.getNo() == node.getNo())
            {
                // 获取与需要修改一样no的节点
                break;
            }
            else if (tmp.getNextNode() == null)
            {
                // 如果链表中的节点的下一个节点为空，则说明不存在需要修改的节点
                System.out.println("不存在该节点");
                return;
            }
            tmp = tmp.getNextNode();
        }
        tmp.setText(node.getText());
    }

    /**
     * 插入时进行倒序排序
     *
     * @param node
     */
    public void addSort(SingleLinkedListNode node)
    {
        SingleLinkedListNode tmp = head;
        while (true)
        {
            if (tmp.getNextNode() == null)
            {
                // 如过到达链表之后，说明插入的节点是最大的
                break;
            }
            else if (tmp.getNextNode().getNo() == node.getNo())
            {
                // 如果插入的节点和链表中的节点存在相同时则插在该节点的后面
                break;
            }
            else if (tmp.getNextNode().getNo() > node.getNo())
            {
                // 如果链表中存在后一个节点大于插入的节点，则插在该节点的后面
                break;
            }
            // 如果上述情况都不存在，则继续判断下一个节点
            tmp = tmp.getNextNode();
        }
        node.setNextNode(tmp.getNextNode());
        tmp.setNextNode(node);
    }

    /**
     * 普通的插入 没有进行排序
     *
     * @param node
     */
    public void add(SingleLinkedListNode node)
    {
        SingleLinkedListNode tmp = head;
        while (true)
        {
            // 当下一个节点为空时，则说明当前节点为最后一个节点
            if (tmp.getNextNode() == null)
            {
                break;
            }
            tmp = tmp.getNextNode();
        }
        tmp.setNextNode(node);
    }

    public void show()
    {
        if (head.getNextNode() == null)
        {
            System.out.println("链表为空");
            return;
        }
        SingleLinkedListNode tmp = head.getNextNode();
        while (true)
        {
            // 当下一个节点为空时，则说明当前节点为最后一个节点
            if (tmp == null)
            {
                break;
            }
            System.out.println(tmp);
            tmp = tmp.getNextNode();
        }
    }
}

class SingleLinkedListNode
{
    private int                  no;
    private String               text;
    private SingleLinkedListNode nextNode;

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public SingleLinkedListNode(int no, String text)
    {
        this.no = no;
        this.text = text;
    }

    public int getNo()
    {
        return no;
    }

    public void setNo(int no)
    {
        this.no = no;
    }

    public SingleLinkedListNode getNextNode()
    {
        return nextNode;
    }

    public void setNextNode(SingleLinkedListNode nextNode)
    {
        this.nextNode = nextNode;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"no\":")
                .append(no);
        sb.append(",\"text\":\"")
                .append(text).append('\"');
        sb.append('}');
        return sb.toString();
    }
}

