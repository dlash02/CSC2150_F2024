public class InClass830B {
    public static void main(String[] args) {
        int nTimes = 20;
        int n = doSomeStuff( nTimes );
    }

    private static int doSomeStuff(int nTimes) {
        if ( nTimes %2 == 0 ){
            System.out.printf("\n Must be even");
        } else {
            System.out.printf("\n Must be odd");
        }
        return nTimes%2;
    }
}
