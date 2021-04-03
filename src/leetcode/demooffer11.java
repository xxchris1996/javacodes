package leetcode;

public class demooffer11 {
    public int minArray(int[] numbers) {
        int n = numbers.length;
        if(numbers[0] < numbers[n-1]) return numbers[0];
        if(numbers[0] == numbers[n-1]){
            for(int i = 0; i < n; i++){
                if(numbers[i] < numbers[0]) return numbers[i];
            }
            return numbers[0];
        }
        int lo = 0;
        int hi = n-1;
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            if(numbers[mid] >= numbers[lo]){
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return numbers[lo];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,2,2,0,1};
        demooffer11  demo = new demooffer11();
        int i = demo.minArray(arr);
        System.out.println(i);
    }
}
