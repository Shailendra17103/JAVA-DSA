public class Concept {
    public static void main(String[] args) {
        fun(5);
    }
    //concept
    static void concept(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
//        concept(n--);
        concept(--n);
//        n-- vs --n

    }
    static void fun(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        fun(n-1);
    }
}
