package demo;

public class sqrtDemo {
    public static void main(String[] args) {
        double left = 1, right = 2;
        while(left < right){
            double mid = left + (right - left)/2;
            if((mid * mid - 2.0) > 1e-8) right = mid;
            else if((2.0 - mid * mid) > 1e-8) left = mid;
            else {
                System.out.println(String.format("%.8f", mid));
                return;
            }
        }
    }
}
