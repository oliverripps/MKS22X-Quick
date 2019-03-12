public class Quick{

  public static int partition (int [] data, int start, int end){
    int l = (int)(Math.random() * (end - start)) + start;
    //System.out.println(l);
    int p=data[l];
    data[l]=data[start];
    data[start]=p;
    l=start;
    start++;
    while (start != end) {
      if (data[start] > p) {
        int n = data[start];
        data[start] = data[end];
        data[end] = n;
        end --;
      } else{
        start ++;
      }
    }
    if (data[start] > p) {
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

  public static boolean check(int[] data, int index){
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
    if (p >= data.length || p < 0){
      throw new ArrayIndexOutOfBoundsException();
    }
    return quickselectH(data, p, 0, data.length - 1);
  }

  private static int quickselectH(int[] data, int p, int start, int end){
    int pivot = partition(data, start, end);
    if (p == pivot){
      return data[p];
    }
    if (p < pivot){
      return quickselectH(data, p, start, data[pivot] - 1);
    }
    else{
      return quickselectH(data, p, data[pivot] + 1, end);
    }
  }
  /*return the value that is the kth smallest value of the array. k=0 is the smallest
 */
 public void quickselect(int[] data, int k)

/*Modify the array to be in increasing order.
 */
 public void quicksort(int[] data){

 }




}
