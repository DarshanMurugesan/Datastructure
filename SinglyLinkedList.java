class SinglyLinkedList{
  private Static Class Node{
   int data;
   Node next;
   Node (int data){
   this.data=data;
   }
   }
   private Node head;
   private Node tail;
   private int size;
   public void insrtAtHead(int data){
   Node new Node=new Node(data);
   if(head==null){
   head=tail=newNode;
   }else{
	   newNode.next=head;
	   head=newNode;
   }
   size++;
   }
   public void insertAtTail(int data){
	   Node newNode=newNode(data);
	   if(tail==null){
		   head=tail=newNode;
		   tail=newNode;
		   tail=newNode;
	   }
	   size++;
   }
   public void insertAtPosition(int index,int data){
	   if(index<0||index>size){
		   system.out.println("Invalid poisition");
		   return;
	   }
	   if(index==0){
		   insrtAtHead(data);
	   }else if(index==size){
		   insertAtTail(data);
	   }else{
		   Node newNode=new Node(data);
		   Node prev=head;
		   for(int i=0;i<index-1;i++){
			   prev=prev.next;
		   }
		   newNode.next=prev.next;
		   prev.next=newNode;
		   size++;
	   }
   }
   public void deleteAtHead(){
	   if(head==null){
		   system.out.println("List is empty");
		   return;
	   }
	   head=head.next;
	   if(head==null)tail=null;
	   size--;
   }
   public void deleteAtTail(){
	   if(tail==null){
		   system.out.println("List is empty");
		   return;
	   }
	   if(head==tail){
		   head=tail=null;
	   }else{
		   Node current=head;
		   while(current.next=tail){
			   current=current.next;
		   }
		   current.next=null;
		   tail=currrent;
	   }
	   size--;
   }
   public void deleteAtPosition(int index){
	   if(index<0||index>=size){
		   system.out.println("Invalid poisition");
		   return;
	   }
   if(index==0}{
	   deleteAtHead();
   }else if(index==size-1){
	   deleteAtTail();
   }else{
	   Node prev=head;
	   for(int i=0;i<index-1;i++){
		   prev=prev.next;
	   }
	   prev.next=prev.next.next;
	   size--;
   }
}
public int search(int key){
	NodeCurrent=head;
	system.out.print(current.data+"->");
	current=current.next;
}
system.out.println("Null");
}
public int getsize(){
	return size;
}
public boolean is Empty(){
 return size==0;
}
public static void main(String[] args)
SinglyLinkedList list=new SinglyLinkedList();
list.insertAtHead(10);
list.insertAtTail(20);
list.insertAtPosition(1,15);
list.display();
list.deleteAtHead();
list.display();
list.insertAtTail(30);
list.insertAtTail(40);
list.insertAtPosition(1,25);
list.display();
int pos=list.search(25);
system.out.println("poisition of 25:"+(pos>=0? pos:"Not Found"));
list.updateAtPosition(1,100);
list.display();
list.updateAtPosition(0.9);
list.updateAtPosition(3,99);
list.display();
list.updateAtPosition(10,500);
}
}
