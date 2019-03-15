import java.util.*;

public class Quick{

  public static int partition (int [] data, int start, int end){
    if (start<0 || start>= data.length || end < 0 || end >= data.length){
      throw new IndexOutOfBoundsException();
    }
    Random rng = new Random();
    int r = rng.nextInt(data.length);
    int p = data[r];
    int hi = end;
    int low = start;
    while(low < hi){
      while (low <=hi && data[low] < p){
      low++;
    }
      while(hi>= low && data[hi] > p){
        hi--;
    }
      if (hi>low){
        int temp = data[hi];
        data[hi] = data[low];
        data[low] = temp;
    }
  }
    return low;
  }


  public static boolean check(int[] data, int index){//checks if partition works
    int val=data[index];
    for(int i=0;i<index;i++){
      if(data[i]==val){
        return false;
      }
    }
    for(int i=index+1;i<data.length;i++){
      if(data[i]==val){
        return false;
      }
    }
    return true;
  }

  public static int quickselect(int[] data, int p){
    if (p < 0 || p >= data.length) {
      throw new IllegalArgumentException() ;
    }
    int k = partition(data, 0, data.length - 1) ;
    while (k != p) {
      if (p > k) k = partition(data, k, data.length - 1) ;
      else {
        k = partition(data, 0, k) ;
      }
    }
    return data[k] ;
  }



 public static void quicksort(int[] data){
   quicksortH(data,0,data.length-1);
 }
 public static void quicksortH(int[] ary,int lo,int hi){
   if(lo>=hi){
     return;
   }
   int pivot=partition(ary,lo,hi);
   quicksortH(ary,pivot+1,hi);
   quicksortH(ary,lo,pivot-1);
 }

public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Quick.quicksort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
}
private static void move(int[] data, int i1, int i2){
     int temp = data[i1];
     data[i1] = data[i2];
     data[i2] = temp;
   }



}
