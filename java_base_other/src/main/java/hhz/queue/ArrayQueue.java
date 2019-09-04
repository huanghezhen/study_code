package hhz.queue;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: ArrayQueue
 * @Description: 队列
 * @author: huanghz
 * @date: 2019/7/2 10:32
 */
public class ArrayQueue
{
    public static void main(String[] args)
    {
        IArrayQueue arrayQueueObject = new ArrayQueueObject(3);
        IArrayQueue arrayQueueAnnular = new ArrayQueueAnnular(3);
        operation(arrayQueueAnnular);

    }
    private static void operation(IArrayQueue arrayQueue)
    {
        char key;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop)
        {
            System.out.println();
            System.out.println("s:显示队列");
            System.out.println("e:退出程序");
            System.out.println("a:添加数据");
            System.out.println("g:取出数据");
            System.out.println("h:查看队列头数据");
            key = scanner.next().charAt(0);
            switch (key)
            {
                case 's':
                    arrayQueue.show();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    System.out.println("程序退出！");
                    break;
                case 'a':
                    System.out.println("请输入数据：");
                    int n = scanner.nextInt();
                    arrayQueue.addQueue(n);
                    break;
                case 'g':
                    try
                    {
                        System.out.println(arrayQueue.getQueue());
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    arrayQueue.showHead();
                    break;
                default:
                    System.out.println("输入的指令不存在，请重新输入");
                    break;
            }
        }
    }
}



class ArrayQueueAnnular implements IArrayQueue
{
    // 队列的最大容量
    private int   maxSize;
    // 当前容量的大小
    private int   currentSize;
    // 队列头
    private int   front;
    // 队列尾
    private int   rear;
    // 队列
    private int[] arr;

    ArrayQueueAnnular(int n)
    {
        maxSize = n;
        arr = new int[maxSize];
        currentSize = 0;
        front = 0;
        rear = 0;
    }
    @Override
    public boolean isFull()
    {
        return currentSize == maxSize;
    }

    @Override
    public boolean isEmpty()
    {
        return currentSize == 0;
    }

    @Override
    public void addQueue(int n)
    {
        if (isFull())
        {
            System.out.println("队列已满，不能添加");
            return;
        }
        arr[rear] = n;
        currentSize++;
        rear = (rear+1)%maxSize;
    }

    @Override
    public int getQueue()
    {
        if (isEmpty())
        {
            throw new RuntimeException("队列为空");
        }
        int n = arr[front];
        currentSize--;
        front = (front+1)%maxSize;
        return n;
    }

    @Override
    public void show()
    {
        if (isEmpty())
        {
            System.out.println("队列为空");
            return;
        }

        for (int i = 0; i < currentSize; i++)
        {

        }
        System.out.println(Arrays.toString(arr));
    }

    @Override
    public void showHead()
    {
        if (isEmpty())
        {
            System.out.println("队列为空");
            return;
        }
        System.out.println(arr[front]);
    }
}
/**
 * 这是一个不能循环使用的队列
 */
class ArrayQueueObject implements IArrayQueue
{
    // 队列的最大容量
    private int   maxSize;
    // 队列头
    private int   front;
    // 队列尾
    private int   rear;
    // 队列
    private int[] arr;

    ArrayQueueObject(int max)
    {
        maxSize = max;
        arr = new int[maxSize];
        // 指向队列头部前一个位置
        front = -1;
        // 指向队列尾部
        rear = -1;
    }

    @Override
    public boolean isFull()
    {
        return rear == maxSize - 1;
    }

    @Override
    public boolean isEmpty()
    {
        return rear == front;
    }

    @Override
    public void addQueue(int n)
    {
        if (isFull())
        {
            System.out.println("队列已满，不能添加数据");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    @Override
    public int getQueue()
    {
        if (isEmpty())
        {
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }

    @Override
    public void show()
    {
        if (isEmpty())
        {
            System.out.println("队列为空");
            return;
        }
        System.out.println(Arrays.toString(arr));
    }

    @Override
    public void showHead()
    {
        if (isEmpty())
        {
            System.out.println("队列为空");
            return;
        }
        System.out.println(arr[front + 1]);
    }
}


interface IArrayQueue
{
    // 判断是否已满
    boolean isFull();

    // 判断是否为空
    boolean isEmpty();

    // 添加数据
    void addQueue(int n);

    // 获取数据
    int getQueue();

    // 打印数据
    void show();

    // 打印队列头部
    void showHead();
}



