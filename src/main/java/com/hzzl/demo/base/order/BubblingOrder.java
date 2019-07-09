package com.hzzl.demo.base.order;

/**
 * 冒泡排序
 *
 * @author
 * @since JDK 1.6
 */
public class BubblingOrder
{
    static int[] arr = {10, 1, 35, 61, 89, 36, 55};

    public static void main(String[] args)
    {
        for (int i = 0; i < arr.length; i++)//外层循环控制趟数
        {
            for (int j = 0; j < arr.length - 1 - i; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
