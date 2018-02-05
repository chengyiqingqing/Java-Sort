package com.wenwen.sort;

/**
 * Created by Administrator on 2018/2/5.
 */

public class TraceShell {

    public static void main(String[] args){
        Integer[] arr=new Integer[]{10,7,3,8,2,9,4,6,5,1};
        sort(arr);
        printArr(arr);
    }

    /**
     *
     * @param arr
     */
    private static void sort(Integer[] arr){
        int n=arr.length;
        int h=1;
        //初始间隔（步长）；
        while (h<n/3)
            h=h*3+1;
        //while循环对各子数组统一计算新的间隔。
        while (h>=1){
            //每个i都代表一个子数组，对各个子数组进行排序
            for(int i=h;i<n;i++){
                //对一个子数组进行排序。
                for (int j=i;j>=h&&less(arr[j],arr[j-h]);j-=h){
                    exch(arr,j,j-h);
                }
            }
            h=h/3;
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
