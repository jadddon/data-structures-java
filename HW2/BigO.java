package HW2;

public class BigO implements BigOInterface {
    
    public void cubic(int n) {
        int x = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    x += i + j + k;
                }
            }
        }
        if (x == -1) {
            System.out.println("cubic method fail");
        }
    }


    public void exp(int n) {
        long x = 0;
        long y = (long) Math.pow(2, n);
        for (long i = 0; i < y; i++) {
            x += (i%2);
        }
        if (x == -1) {
            System.out.println("exp method fail");
        }
    }

    public void constant(int n) {
        int x = n;
        if (x == -1) {
            System.out.println("constant method fail");
        }
    }
}
