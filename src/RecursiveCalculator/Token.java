package RecursiveCalculator;

class Token {
    private final TokenType type;
    private final Object value;

    public Token(TokenType type, Object value) {
        this.type = type;
        this.value = value;
    }

    
    /** 
     * @return TokenType
     */
    public TokenType getType() {
        return type;
    }

    
    /** 
     * @return Object
     */
    public Object getValue() {
        return value;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Token{" + "type=" + type + ", value=" + value + '}';
    }
}
