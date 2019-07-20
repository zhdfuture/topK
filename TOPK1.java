import java.util.*;

//topk小的问题
// 利用优先队列构建大顶堆
public class TOPK1<E extends Comparable>{
private PriorityQueue<E> queue;
private int maxsize;
public TOPK1(){}
public TOPK1(int maxsize){
    this.maxsize=maxsize;
    this.queue=new PriorityQueue<E>(maxsize, new Comparator<E>() {
        @Override
        public int compare(E o1, E o2) {
            return o2.compareTo(o1);  //优先队列默认是升序，为构建大顶堆，此处让其降序
        }
    });
}
public void add(E e){
    if(queue.size()<maxsize){
        queue.add(e);
    }else{
        if(e.compareTo(queue.peek())<0){
            queue.poll();
            queue.add(e);
        }
    }
}
//注：优先队列本来是无序的，可用list来包装，得到数据 是有序的
    public List<E> sortList(){
    List<E> list=new ArrayList<>(queue);  //用List来包装queue
        Collections.sort(list);   //排序
        return list;
    }

    public static void main(String[] args) {
        TOPK1<Integer>  test=new TOPK1<>(10);     //选出前10个
        Random random=new Random();
        for(int i=150;i>=0;i--){
            test.add(i);
        }
        while(!test.queue.isEmpty()){
            System.out.println(test.queue.poll());
        }
    }
}
