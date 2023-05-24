package com.tlacuachesdevs.mydbms.util;

/**
 *
 * @author mander
 */
public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    // Insert new node in the last postion
    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    // Search a new node
    public Node<T> search(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

}
