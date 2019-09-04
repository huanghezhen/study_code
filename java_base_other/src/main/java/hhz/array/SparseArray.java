package hhz.array;

/**
 * @ClassName: SparseArray
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/1 19:12
 */
public class SparseArray
{
    public static void main(String[] args)
    {
        // 先创建原始的二维数组 8 * 8
        // 0 没有棋子，1 黑子，2 白子
        int[][] chessArr = new int[8][8];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        // 打印原二维数组
        System.out.println("原二维数组：");
        show(chessArr);

        // 原二维数组的有效数据个数
        int sum = 0;
        // 遍历原二维数组得到 原二维数组的有效数据个数
        for (int[] ints : chessArr)
        {
            for (int anInt : ints)
            {
                if (anInt > 0)
                {
                    sum++;
                }
            }
        }

        // 创建稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        // 给稀疏数组的第一行赋值
        sparseArr[0][0] = 8;
        sparseArr[0][1] = 8;
        sparseArr[0][2] = sum;
        int k = 1;
        for (int i = 0; i < chessArr.length; i++)
        {
            for (int j = 0; j < chessArr[i].length; j++)
            {
                if (chessArr[i][j] > 0)
                {
                    sparseArr[k][0] = i;
                    sparseArr[k][1] = j;
                    sparseArr[k][2] = chessArr[i][j];
                    k++;
                }
            }
        }
        System.out.println("稀疏数组：");
        show(sparseArr);

        // 还原二维数组
        // 创建二维数组
        int[][] chessArr1 = new int[sparseArr[0][0]][sparseArr[0][1]];
        // 遍历稀疏数组，进行赋值
        for (int i = 1; i <= sparseArr[0][2]; i++)
        {
            chessArr1[sparseArr[i][0]][sparseArr[i][1]] =sparseArr[i][2];
        }
        System.out.println("还原的二维数组：");
        show(chessArr1);
    }

    private static void show(int[][] arr)
    {
        for (int[] ints : arr)
        {
            for (int anInt : ints)
            {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
