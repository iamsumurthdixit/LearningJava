public class Calculation {

    int stockPrice = 20;  // associated with each object
    static int carPrice = 59;  // associated with class

    public static int getPriceOfPen() {
//        int capPrice = 3;
//        int penBodyPrice = 5;
//        return capPrice + penBodyPrice;

        carPrice = 35;  // accessible
//        stockPrice = 98;  ERROR
//        method();  ERROR

        Calculation obj = new Calculation();
        obj.stockPrice = 98;
        obj.print();

        return obj.stockPrice + carPrice;
    }

    void print() {      // associated with each object
        System.out.println("instance method");
    }

    public int sum(int a, int ...variable) {
        int result = a;
        for(int var : variable) {
            result += var;
        }
        return result;
    }
}
