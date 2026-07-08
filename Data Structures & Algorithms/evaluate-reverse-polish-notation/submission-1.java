class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                    int b = st.pop();
                    int a = st.pop();
                    st.push(a + b);
                    break;

                case "-":
                    b = st.pop();
                    a = st.pop();
                    st.push(a - b);
                    break;

                case "*":
                    b = st.pop();
                    a = st.pop();
                    st.push(a * b);
                    break;

                case "/":
                    b = st.pop();
                    a = st.pop();
                    st.push(a / b);
                    break;

                default:
                    st.push(Integer.parseInt(token));
            }
        }

        return st.pop();
    }
}