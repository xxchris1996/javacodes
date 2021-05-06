package jianzhiOffer;

public class demo20 {
    public static boolean isNumber(String s) {
        String num = s.trim();
        int n = num.length();
        int index = 0;
        boolean hasNum = false;
        boolean hasE = false;
        boolean hasDot = false;
        boolean hasSign = false;
        while(index < n){
            if((num.charAt(index) < '0' || num.charAt(index) > '9') && num.charAt(index) != 'e' && num.charAt(index) != 'E' && num.charAt(index) != '.' && num.charAt(index) != '+' && num.charAt(index) != '-') return false;
            while(index < n && index >= 0 && num.charAt(index) >= '0' && num.charAt(index) <= '9'){
                index++;
                hasNum = true;
            }
            if(index < n && (num.charAt(index) == 'e' || num.charAt(index) == 'E')){
                if(hasNum == false || hasE == true) return false;
                if(index == n-1|| index < n-1 && (num.charAt(index+1) > '9' || num.charAt(index+1) < '0' && (num.charAt(index+1) != '+' && num.charAt(index+1) != '-'))) return false;
                index++;
                hasE = true;
            } else if(index < n && (num.charAt(index) == '-' || num.charAt(index) == '+')){
                if(hasNum == true && hasE == false || hasDot == true && hasE == false) return false;
                if(index == n-1|| index < n-1 && (num.charAt(index+1) > '9' || num.charAt(index+1) < '0') && num.charAt(index+1) != '.' && num.charAt(index+1) != 'e' && num.charAt(index+1) != 'E') return false;
                index++;
                hasSign = true;
            } else if(index < n && (num.charAt(index) == '.')){
                if(hasE == true || hasDot == true) return false;
                // if(index == n-1|| index < n-1 && (num.charAt(index+1) > '9' || num.charAt(index+1) < '0')) return false;
                index++;
                hasDot = true;
            }

        }
        return hasNum;
    }
    public static void main(String[] args) {
        String s = "32.e-80123";
        boolean number = isNumber(s);
        System.out.println(number);
    }
}
