public class TopK{
    public static void main(String[] args) {
        int[] array={1,9,4,7,6,2,5,3,0,8};
        int[] result=getTopK(array,5);
        for(int i:result){
            System.out.print(i+" ");
        }
    }
    //创建k个元素的小根堆
    public static int[] create(int[] array,int k){
        int[] result=new int[k];
        for(int i=0;i<k;i++){
            result[i]=array[i];
        }
        for(int i=k/2;i>=0;i--){
            int temp=result[i];
            int child=i*2+1;
            while(child<result.length){
                if(child+1<result.length&&result[child+1]<result[child]){
                    child++;
                }
                if(temp<result[child]){
                    break;
                }
                result[i]=result[child];
                i=child;
                child=child*2+1;
            }
            result[i]=temp;
        }
        return result;
    }

    private static int[] getTopK(int[] array, int k) {
        int[] result=create(array,k); //k个元素的小顶堆
        int min=result[0];
        for(int i=k+1;i<array.length;i++){
            if(array[i]>min){
                insert(result,array[i]);
            }
        }
        return result;
    }

    private static void insert(int[] result, int data) {
        result[0]=data;
        for(int  i=result.length/2;i>=0;i--){
            int temp=result[i];
            int child=i*2+1;
            while(child<result.length){
                if(child+1<result.length&&result[child+1]<result[child]){
                    child++;
                }
                if(temp<result[child]){
                    break;
                }
                result[i]=result[child];
                i=child;
                child=child*2+1;
            }
            result[i]=temp;
            }
        }
    }

