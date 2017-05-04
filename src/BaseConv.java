public class BaseConv {

static String baseToBase(String num, int base1, int base2) {
    int no = convFrmBaseToDeci(num, base1);
    return convFrmDecToBase(no, base2);
}

static String convFrmDecToBase(int num, int base) {

    String res = "";
    int rem;
    // Convert input number is given base by repeatedly
    // dividing it by base and taking remainder
    while (num > 0) {
        rem = num % base;
        if (base == 16) {
            if (rem == 10)
                res += 'A';
            else if (rem == 11)
                res += 'B';
            else if (rem == 12)
                res += 'C';
            else if (rem == 13)
                res += 'D';
            else if (rem == 14)
                res += 'E';
            else if (rem == 15)
                res += 'F';
            else
                res += rem;
        } else
            res += rem;

        num /= base;
    }
    // Reverse the result
    return new StringBuffer(res).reverse().toString();
}

static int convFrmBaseToDeci(String num, int base) {

    if (base < 2 || (base > 10 && base != 16))
        return -1;

	    int val = 0;
	    int power = 1;
	
	    for (int i = num.length() - 1; i >= 0; i--) {
	        int digit = digitToVal(num.charAt(i));
	
	        if (digit < 0 || digit >= base)
	            return -1;
	
	        // Decimal equivalent is str[len-1]*1 +
	        // str[len-1]*base + str[len-1]*(base^2) + ...
	        val += digit * power;
	        power = power * base;
	    }

    return val;
}

static int digitToVal(char c) {
    if (c >= '0' && c <= '9')
        return (int) c - '0';
    else
        return (int) c - 'A' + 10;
}

public static void main(String [] args) {
    System.out.println(baseToBase("10560290", 10, 2));
    System.out.println(baseToBase("101000010010001100100010", 2, 10));
    System.out.println(baseToBase("0xA12322", 16, 2));
    System.out.println(baseToBase("x", 10, 32));
    System.out.println(baseToBase("50221442", 8, 16));
}
}