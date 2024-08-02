public class Test {
    {
        System.out.println("this is instance block");
    }
    static {
        System.out.println("this is static block");
    }
    Test(){
        System.out.println("this is a constructor");
    }

    void printLoop(){
        System.out.println("print for loop");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            
        }
    }
}
