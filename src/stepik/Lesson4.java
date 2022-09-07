package stepik;

public class Lesson4 {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static double sqrt(double x) {
        if (x < 0) {
            throw new IllegalArgumentException(String.format("Expected non-negative number, got %s", x));
        }
        return Math.sqrt(x);
    }

    public static String getCallerClassAndMethodName() {
        Thread current = Thread.currentThread();
        StackTraceElement[] methods = current.getStackTrace();
        //в этом случае в массиве использовать 3е значение:
        if (methods.length > 3) return methods[3].getClassName() + "#" + methods[3].getMethodName();
        else {
            return null;
        }
    }
}
