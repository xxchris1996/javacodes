package demo;

public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int D){
        int left = getMax(weights);
        System.out.println(left);
        int right = getSum(weights);
        System.out.println(right);
        while (left < right){
//            System.out.println("cccccccccccccc");
            int mid = left + (right - left) / 2;
            if (canFinish(weights, mid, D)) {
                right = mid;
                System.out.println(mid);
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int getMax(int[] weights){
        int max = 0;
        for (int n : weights) {
            if (max < n) max = n;
        }
        return max;
    }

    public int getSum(int[] weights){
        int sum = 0;
        for (int n : weights) {
            sum += n;
        }
        return sum;
    }

    public boolean canFinish(int[] weights, int cap, int D){
        int i = 0;
        for(int day = 0; day < D; day++){
            int maxCap = cap;
            while ((maxCap -= weights[i]) >= 0){

                i++;
                if(i == weights.length) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] weights = new int[]{1,2,3,4,5,6,7,8,9,10};
        int D = 5;
        ShipWithinDays demo = new ShipWithinDays();
        int i = demo.shipWithinDays(weights, D);
        System.out.println(i+"-------------");

    }
}


