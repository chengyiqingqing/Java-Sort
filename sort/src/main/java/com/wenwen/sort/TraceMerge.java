package com.wenwen.sort;

/**
 * Created by shaowenwen on 2018/2/5.
 */

public class TraceMerge {

    public static void main(String[] args){
        Integer[] arr=new Integer[]{10,7,3,8,2,9,4,6,5,1,11};
        sort(arr);
        printArr(arr);
    }

//====================================================================

    public static void sort(Integer[] arr){
        int n=arr.length;
        Integer[] aux=new Integer[n];
        sort(arr,aux,0,n-1);
    }

    public static void sort(Integer[] arr,Integer[] aux,int lo,int hi){
        if (lo>=hi) return;
//        int mid = (lo+hi)/2;
        int mid = lo + (hi - lo) / 2;
        sort(arr,aux,lo,mid);  //左边，小 (mid)
        sort(arr,aux,mid+1,hi);  //右边，大 (mid+1)
        merge(arr,aux,lo,mid,hi);
    }

    public static void merge(Integer[] arr,Integer[] aux,int lo,int mid,int hi){
        //从lo到hi，先复制一份儿给aux；
        for (int k=lo;k<hi;k++){
            aux[k]=arr[k];
        }

        //merge back to arr; 对下面这个操作有点儿迷啊。
        int i=lo,j=mid+1;
        for(int k=lo;k<=hi;k++){
            if (i>mid)
                arr[k]=aux[j++];
            else if (j>hi)
                arr[k]=aux[i++];
            else if (less(aux[j],aux[i])){
                System.out.println();
                arr[k]=aux[j++];
                System.out.println();
            }
            else
                arr[k]=aux[i++];
        }

    }

//====================================================================

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
        System.out.println(" "+v+" "+w);
        if (v==null)
            v=0;
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
