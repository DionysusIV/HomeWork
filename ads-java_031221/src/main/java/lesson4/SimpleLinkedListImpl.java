package lesson4;

import java.util.Iterator;

public class SimpleLinkedListImpl<E> implements LinkedList<E>, Iterable<E>{

    protected int size;
    protected Node<E> first;

    @Override
    public void insertFirst(E value) {
        first = new Node<>(value, first);

       Node<E> actualFirst = first;
        Node<E> newFirst = new Node<>(value, actualFirst);
        this.first = newFirst;

        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removedNode = first;
        first = removedNode.next;
        removedNode.next = null;
        size--;

        return removedNode.item;
    }

    @Override
    public void remove(E value) {
        Node<E> current = first;
        Node<E> prev = null;

        while (current != null){
            if (current.item.equals(value)) {
                break;
            }
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return;
        } else if(current == first) {
            removeFirst();
            return;
        }

        prev.next = current.next;
        current.next = null;
        size--;

    }

    @Override
    public boolean contains(E value) {
        Node<E> current = first;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = first;

        while (current != null){
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }

        return sb.append("]").toString();
    }

    @Override
    public E getFirst() {
        return first.item;
    }

    @Override
    public Iterator<E> iterator() {

        return new ListIterator<E>();
    }

    private class ListIterator<E> implements Iterator<E> {


        @Override
        public boolean hasNext() {

            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }
    }

