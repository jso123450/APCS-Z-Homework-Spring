public class myQueue<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public myQueue(){
	head = new Node<E>();
	tail = head;
    }

    public void enqueue(E data){
	Node<E> tmp = new Node<E>(data);
	tail.setNext(tmp);
	tail = tmp;
	size++;
    }

    public E dequeue(){
	if (empty())
	    throw new EmptyQueueException();
	E data = head.getData();
	head = head.getNext();
	size--;
	return data;
    }

    public boolean empty(){
	return ((head == tail) && (head.getData() == null));
    }

    public E head(){
	if (empty())
	    throw new EmptyQueueException();
	E data = head.getData();
	return data;
    }

    public int size(){
        return size;
    }

}
