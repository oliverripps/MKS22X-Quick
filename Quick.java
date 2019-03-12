public class Quick{

  public static int partition (int [] data, int start, int end){
    int l = (int)(Math.random() * (end - start)) + start;
    int f=0;
    int b=0;
    int[] newdata = new int[end-start];
    for(int i=start;i<end;i++){
      if(i!=l){
        if(data[i]>data[l]){
          newdata[newdata.length-1-b];
          b++;
        }
        if(data[i]<data[l]){
          newdata[f];
          f++;
        }
      }
    }
    //f+1  and b-1 should be equal
    newdata[f+1]=data[l];
    data=newdata;
    return f+1;
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
