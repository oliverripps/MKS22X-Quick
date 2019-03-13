public class Quick{

  public static int partition (int [] data, int start, int end){
    if (start<0 || start>= data.length || end < 0 || end >= data.length){
      throw new IndexOutOfBoundsException();
    }
    int r = (int)(Math.random() * (end - start) + start);
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




}
