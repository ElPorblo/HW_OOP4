public class LinkedList <E> implements Link <E> {
    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size;
    //private int counter; //для возвращения элемента по индексу

    /***
     * Прописываем конструктор с взаимосвязью между нодами.
     * Т.к. LinkedList - связанный список, то у него каждый элемент содержит ссылки на предыдущий элемент, информацию
     * о текущем элементе, ссылка на следующий элемент
     * Прописываем ноды первого и последнего элемента
     */
    public LinkedList() {
        firstNode = new Node<E>(null, firstNode, null);
        lastNode = new Node<E>(null, null, lastNode);
    }


    @Override
    public void addLast(E e) {
        Node <E> prev = lastNode;
        prev.setCurrentElement(e);
        lastNode = new Node <E> (null, prev, null);
        prev.setNextElement(lastNode);
        size++;
    }

    @Override
    public void addFirst(E e) {
        Node <E> next = firstNode;
        next.setCurrentElement(e);
        firstNode = new Node <> (null, null, next);
        next.setPrevElement(firstNode);
        size++;


    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E getElementByIndex(int counter) {
        Node <E> target = firstNode;
        if(counter == 1) {
            firstNode.getCurrentElement();
        } else if (counter == size) {
            for (int i = 0; i < counter; i++) {
                target = target.getNextElement();
            }
            target.getCurrentElement();

        } else {
            target.getPrevElement();
        }

        return target.currentElement;
    }
    //@Override
    //    public E getElementByIndex(int counter) {
    //        Node <E> target = firstNode.getNextElement();
//          for (int i = 0; i < counter; i++) {
//            target = getNextElementND(target);
//          }
//        return target.getCurrentElement();
//    }
//public Node <E> getNextElementND(Node<E> current) {
//        return current.getNextElement();
//}

//public E getIndex(E e) {
//    Node <E> result;
//    result = null;
//    if (firstNode == null) {
//        //System.out.println("Нет значений");
//        result = null;
//
//    } else if (firstNode == e) {
//        //System.out.println(e);
//        result = firstNode;
//    } else {
//        Node<E> currentNode = firstNode;
//        int res = 0;
//        while (currentNode.nextElement != null) {
//            ++res;
//            if (currentNode.nextElement == e) {
//                System.out.println(res);
//            }
//            currentNode = currentNode.nextElement;
//        }
//    }
//    return (E) result;
//}

    private class Node<E> {
        private E currentElement; //данные, которые храним
        private Node<E> nextElement;
        private Node<E> prevElement;
        private Node(E currentElement, Node<E> prevElement, Node<E> nextElement) {
            this.currentElement = currentElement;
            this.nextElement = nextElement;
            this.prevElement = prevElement;
        }
        public E getCurrentElement() {
            return currentElement;
        }
        public void setCurrentElement(E currentElement) {
            this.currentElement = currentElement;
        }
        public Node<E> getNextElement() {
            return nextElement;
        }
        public void setNextElement(Node<E> nextElement) {
            this.nextElement = nextElement;
        }
        public Node<E> getPrevElement() {
            return prevElement;
        }
        public void setPrevElement(Node<E> prevElement) {
            this.prevElement = prevElement;
        }
    }
    @Override
    public String toString() {
        String str = "\nLinkedList: ";
        Node <E> n = firstNode;
        while (n != null) {
            str = str + n.getCurrentElement();
        }
        return str;
    }

}