package L10;

public class ExpressionTree {
    private static class ExpNode {
        int operand;
        char operator;
        ExpNode left;
        ExpNode right;
    }

    private ExpNode root;
    public int eval(){
        return eval(root);
    }

    private int eval(ExpNode t) {
        if(t.left == null){
            return t.operand;
        }
        int lval = eval(t.left);
        int rval = eval(t.right);
        return apply(lval, rval, t.operator);
    }

    private int apply(int lval, int rval, char operator){
        switch(operator){
            case '+': return lval + rval;
            case '-': return lval - rval;
            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
