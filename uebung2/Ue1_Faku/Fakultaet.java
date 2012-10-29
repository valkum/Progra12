public class Fakultaet {
    static int fakWhile (int n) {
        int result = 1;
        while(n > 1)
        {
            result = result * (n);
            n--;
        }
        return result;
    }

    static int fakDoWhile (int n) {
        int result = 1;
        if(n == 0) return 1;
        do
        {
            result = result * (n);
            n--;
        } while(n > 1);
        return result;
    }

    static int fakFor (int n) {
        int result = 1;
        for(;n > 1;n--)
        {
            result = result * (n);
        }
        return result;
    }

    public static void main (String [] args) {
        System.out.println("i\tfakWhile(i)\tfakDoWhile(i)\tfakFor(i)");
        for (int i = 0; i < 10; i++) {
            System.out.println(i
                    + "\t" + fakWhile(i)
                    + "\t\t" + fakDoWhile(i)
                    + "\t\t" + fakFor(i));
        }
    }
}
