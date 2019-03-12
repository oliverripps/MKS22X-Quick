public class Quick{

  public static int partition (int [] data, int start, int end){
    int l = (int)(Math.random() * (end - start)) + start;
    System.out.println(l);
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
      } else
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

    //System.out.println(Arrays.toString(data));
    //System.out.println(testPartition(data, pivotIndex));
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



}
