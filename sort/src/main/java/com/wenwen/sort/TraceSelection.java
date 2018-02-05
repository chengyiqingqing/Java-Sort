package com.wenwen.sort;

/**
 * Created by shaowenwen on 2018/2/5.
 */

public class TraceSelection {

    public static void main(String [] args){
        Integer[] arr=new Integer[]{10,7,3,8,2,9,4,6,5,1};
        sort(arr);
        printArr(arr);
    }

    /**
     * 排序；
     * @param a
     */
    public static void sort(Integer[] a){
        int n=a.length;
        for (int i=0;i<n;i++){//外层循环控制当前索引位置。
            int min=i;
            for (int j=i+1;j<n;j++){//内层循环：通过比较找到最小的元素并记录索引位置。
                if (less(a[j],a[min])) min=j;
            }
            exch(a,i,min);
        }
    }

    /**
     * for循环遍历这些数组；
     * @param arr
     */
    public static void printArr(Integer[] arr){
        System.out.println();
        for (int i=0;i<arr.length;i++){
            System.out.print(" "+arr[i]);
        }
    }

    /**
     * v小于w: is v < w ?
     * @param v
     * @param w
     * @return
     */
    public static boolean less(Integer v,Integer w){
        return v.compareTo(w)<0;
    }

    /**
     * 将min所记录下的索引为j的值与“当前索引为i的元素相交换”
     * @param a
     * @param i
     * @param j
     */
    public static void exch(Integer[] a,int i,int j){
        Integer swap=a[i];
        a[i]=a[j];
        a[j]=swap;
    }

}
