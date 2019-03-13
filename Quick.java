public class Quick{

  public static int partition (int [] data, int start, int end){
    int l = (int)(Math.random() * (end - start)+start);//pick random pivot
    //System.out.println(l);
    int p=data[l];//value at pivot
    data[l]=data[start];
    data[start]=p;//swapped start and pivot
    l=start;
    start++;
    while (start < end) {//while there is still swappin to be done
      if (data[start] > p) {//if startneeds to be swapped
        int n = data[start];//swapping them to end
        data[start] = data[end];
        data[end] = n;
        end --;//end is one less
      } else{
        start ++;//if in right position, go foraard
      }
    }
    if (data[start] > p) {//swapping back pivot
      data[l] = data[start - 1];
      data[start - 1] = p;
      l = start - 1;
    } else {
      data[l] = data[start];
      data[start] = p;
      l = start;
    }

    return l;
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

  public static int quickselect(int[] data, int p) throws ArrayIndexOutOfBoundsException{
    if (p >= data.length || p < 0){//if not possible
      throw new ArrayIndexOutOfBoundsException();
    }
    if(data.length==1){//if only one element
      return data[0];//return that element
    }
    return quickselectH(data, p, 0, data.length - 1);//call helper
  }

  private static int quickselectH(int[] data, int p, int start, int end){
    if (start>=end){//if they meet or overlap
      return data[p];//youre done, base case
    }
    int pivot = partition(data, start, end);
    quickselectH(data,p,start,pivot-1);
    quickselectH(data,p,pivot+1,end);
    return -1;
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
