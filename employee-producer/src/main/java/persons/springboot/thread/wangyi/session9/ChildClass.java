package persons.springboot.thread.wangyi.session9;

class A {
    protected int value;
    public A(int v){
        setValue(v);
    }
    public void setValue(int value){
        this.value = value;
    }

    public int getValue(){
        try {
            value++;
            return value;
        } finally {
            this.setValue(value);
            System.out.println(value);
        }
    }
}
class B extends A {

    public B() {
        super(5);
        setValue(getValue() - 3);
    }
    public void setValue(int value){
        super.setValue(2 * value);
    }
}
public class ChildClass {
    public static void main(String[] args) {
        System.out.println(new B().getValue());
    }
}