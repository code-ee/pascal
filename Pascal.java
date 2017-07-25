public class Pascal {
    public static void main(String[] args) {
        Pascal p = new Pascal();
        int numRows = Integer.parseInt(args[0]) + 1;
        int[] pA = p.createPascalArray(numRows); 
        p.printPascalTriangle(pA, numRows);
    }

    public int[] createPascalArray(int numRows) {
        if (numRows <= 0) {
            System.out.println("Pascal's triangle cannot have a negative number of rows.");
            System.exit(0);
        }
        // calculate length
        int length = 0;
        for (int i = 1; i <= numRows; i++) {
            length += i;
        }   
        int[] p = new int[length];
        int count = 1;
        int x = 0;

        // fill pascal array
        p[0] = 1;
        for (int i = 1; i < numRows; i++) {
            p[count] = 1;
            count++;
            for (int j = 1; j < i; j++) {
                p[count] = p[x] + p[x + 1];
                x++;
                count++;
            }
            p[count] = 1;
            x++;
            count++;
        }
        return p;
    }

    public void printPascalTriangle(int[] pA, int numRows) {
        int count = 0;
        int cur = -1;
        for (int i = 0; i < numRows; i++) {
            for (int s = 0; s < numRows - i; s++) {
                System.out.print("  ");
            }    
            for (int j = 0; j < i; j++) {
                cur = pA[count];
                if (cur < 10) { 
                    System.out.print(pA[count] + "   ");
                } else {
                    System.out.print(pA[count] + "  ");
                }

                count++;
            }
            System.out.println();
        }
        System.out.println();
    }        
}
