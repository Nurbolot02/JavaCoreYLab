package stepik.Lesson2;

public class TypesAndLogicOperations {
    public static void main(String[] args) {
        boolean f1 = false;
        boolean f2 = true;
        if (f1 ^ f2){
            System.out.println(true);
        }else {
            System.out.println(false);
        }


        f2 &= f1;
        System.out.println(f2);
        System.out.println("--------------");

        f2 = true;
        f2 |= f1;
        System.out.println(f2);
        System.out.println("--------------");


        f2 = true;
        f1 = true;
        f2 ^= f1;
        System.out.println(f2);
        System.out.println("--------------");

        f2 = true;
        f1 = false;
        f2 ^= f1;
        System.out.println(f2);
        System.out.println("--------------");
    }


}
