
class Solution {
    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
        return "0";
    }
        String addition = "0";

        for (int i = num2.length() - 1; i >= 0; i--) {
            char s = num2.charAt(i);
            String m = mul(num1, s);

            StringBuilder shifted = new StringBuilder(m);
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                shifted.append('0');
            }

            String a = add(shifted.toString(), addition);
            addition = a;
        }

        return addition;
    }

    public String mul(String a, char b) {
        int y = b - '0';
        int carry = 0;
        StringBuilder str = new StringBuilder();

        for (int i = a.length() - 1; i >= 0; i--) {
            int x = a.charAt(i) - '0';
            int z = (x * y) + carry;

            str.append(z % 10);
            carry = z / 10;
        }

        if (carry > 0) {
            str.append(carry);
        }

        return str.reverse().toString();
    }

    public String add(String a, String b) {
        StringBuilder str = new StringBuilder();

        int i = b.length() - 1;
        int j = a.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int x = (i >= 0) ? b.charAt(i--) - '0' : 0;
            int y = (j >= 0) ? a.charAt(j--) - '0' : 0;

            int z = x + y + carry;

            str.append(z % 10);
            carry = z / 10;
        }

        if (carry > 0) {
            str.append(carry);
        }

        return str.reverse().toString();
    }
}
