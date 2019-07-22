import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Node{
    int length;
    int width;
    public  Node(int length,int width){
        this.length=length;
        this.width=width;
    }
}
//先比长，长是升序的，若长相等。再比宽，宽是降序的
public class TestPriority {
    static Comparator<Node> cNode=new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            if(o1.length!=o2.length){
                return o1.length-o2.length;   //升序
            }
        return o2.width-o1.width;    //降序
        }
        };

    public static void main(String[] args) {
        Queue<Node> queue=new PriorityQueue<>(cNode);
        Node n1=new Node(1, 2);
        Node n2=new Node(3, 5);
        Node n3=new Node(2, 4);
        Node n4=new Node(3,4);
        queue.add(n1);
        queue.add(n2);
        queue.add(n3);
        queue.add(n4);
        Node n;
        while(!queue.isEmpty()){
            n=queue.poll();
            System.out.println("长："+n.length+"宽:"+n.width);
        }

    }
    }
