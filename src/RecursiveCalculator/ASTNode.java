package RecursiveCalculator;

abstract class ASTNode {
    enum Type {
        INTEGER,
        BINARY_OPERATOR;
    }

    private final Type type;
    private final Object value;
    private ASTNode left;
    private ASTNode right;

    public ASTNode(Type type, Object value) {
        this.type = type;
        this.value = value;
    }

    
    /** 
     * @return Type
     */
    public Type getType() {
        return type;
    }

    
    /** 
     * @return Object
     */
    public Object getValue() {
        return value;
    }

    
    /** 
     * @return ASTNode
     */
    public ASTNode getLeft() {
        return left;
    }

    
    /** 
     * @param left
     */
    public void setLeft(ASTNode left) {
        this.left = left;
    }

    
    /** 
     * @return ASTNode
     */
    public ASTNode getRight() {
        return right;
    }

    
    /** 
     * @param right
     */
    public void setRight(ASTNode right) {
        this.right = right;
    }

    
    /** 
     * @param value
     * @return ASTNode
     */
    public static ASTNode integer(int value) {
        return new ASTNode(Type.INTEGER, value) {

            @Override
            public Fraction evaluate() {
                return new Fraction(value);
            }
        };
    }

    
    /** 
     * @param operator
     * @param left
     * @param right
     * @return ASTNode
     */
    public static ASTNode binaryOperator(String operator, ASTNode left, ASTNode right) {
        return new ASTNode(Type.BINARY_OPERATOR, operator) {
            @Override
            public Fraction evaluate() {
                Fraction leftValue = left.evaluate();
                Fraction rightValue = right.evaluate();
                switch ((String) getValue()) {
                    case "+":
                        return leftValue.add(rightValue);
                    case "-":
                        return leftValue.subtract(rightValue);
                    case "*":
                        return leftValue.multiply(rightValue);
                    case "/":
                        return leftValue.divide(rightValue);
                    default:
                        throw new RuntimeException("Invalid operator: " + getValue());
                }
            }
        };
    }

    public abstract Fraction evaluate();
}