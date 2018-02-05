package com.wenwen.sort;

/**
 * Created by Administrator on 2018/2/5.
 */

public class TraceInsertion {

    public static void main(String[] args){
        Integer[] arr=new Integer[]{10,7,3,8,2,9,4,6,5,1};
        sort(arr);
        printArr(arr);
    }

    public static void sort(Integer[] arr){
        int n=arr.length;
        for (int i=0;i<n;i++){
            int j;//一会儿要拿出来用它；
            for (j=i;j>0&&less(arr[j],arr[j-1]);j--){
                exch(arr,j,j-1);
            }
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
