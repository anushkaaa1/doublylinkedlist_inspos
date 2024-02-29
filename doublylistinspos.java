public class doublylistinspos {
    Node head,tail;
    int size;
    
    public doublylistinspos(){
        head = tail = null;
        size =0;
    }
    public class Node {
        int  data;
        Node next;
        Node prev;
            
        Node(int data){
            this.data= data;
            this.next = null;
            this.prev = null;
            size++;
        }
    }
    public void create(int value){
        Node newnode = new Node(value);
        if(head==null)
            head = tail = newnode;
        else{
            newnode.prev = tail;
            tail.next = newnode;
            tail = newnode;
        }
    }
    public void display(Node head){
        if(head==null)
            System.out.println("list is empty");
        else{
            while (head!=null) {
                System.out.println(head.data);
                head = head.next;
            }
        }
    }
    public void inspos(int idx,int data){
        if(idx<0||idx>size||(head==null&&idx>0))
            System.out.println("insertion not possible");
        else{
            Node newnode = new Node(data);
            if(idx==0){
                if(head==null)
                    head=newnode;
                else{
                    newnode.next = head;
                    head.prev = newnode;
                    head = newnode;
                }
            }
            else if(idx==size-1){
               tail.next = newnode;
               newnode.prev = tail;
               tail = newnode;
            }
            else{
                Node temp = head;
                for(int i=0;i<idx-1;i++){
                    temp = temp.next;
                }
                newnode.prev = temp;
                newnode.next = temp.next;
                temp.next.prev = newnode;
                temp.next = newnode;
            }
        }
    }
    public static void main(String[] args){
        doublylistinspos list = new doublylistinspos();
        list.create(2);
        list.create(4);
        list.create(6);
        list.display(list.head);
        System.out.println();
        list.inspos(2,9);
        list.display(list.head);
    }
}
