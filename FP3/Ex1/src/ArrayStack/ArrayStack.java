package ArrayStack;
import java.util.Arrays;

public class ArrayStack<T> implements StackADT<T> {

    /**
     * array of generic elements to represent the stack
     */
    private T[] stack;
    /**
     * constant to represent the default capacity of the array
     */
    private final int DEFAULT_CAPACITY = 2;
    /**
     * int that represents both the number of elements and the next
     * available position in the array
     */
    private int top;

    public ArrayStack() {
        stack = (T[])(new Object[DEFAULT_CAPACITY]);
        this.top = 0;
    }

    public ArrayStack(int size) {
        stack = (T[])(new Object[size]);
        this.top = 0;
    }

    @Override
    public void push(T element) {
        if(stack.length == top){
            stackResize();
            stack[top] = element;
            top++;
        }else{
            stack[top] = element;
            top++;
        }
    }

    @Override
    public T pop() throws EmptyCollectionException{
        if(isEmpty()){
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }else{
            this.top--;
            return stack[top];
        }
    }

    @Override
    public T peek() throws EmptyCollectionException{
        if(isEmpty()){
            throw new EmptyCollectionException(EmptyCollectionException.EMPTYCOLLECTION);
        }else{
            return stack[top - 1];
        }
    }

    @Override
    public boolean isEmpty() {
        if(top == 0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public String toString() {
        String text = "";
        int lastPostion = size() - 1;
        while(lastPostion != -1){
            text += "Posição : " + lastPostion + " -----> " + "Conteudo : " + stack[lastPostion] + "\n";
            lastPostion --;
        }
        return text;
    }

    private void stackResize(){
        stack = Arrays.copyOf(stack , stack.length + DEFAULT_CAPACITY);
    }
}
