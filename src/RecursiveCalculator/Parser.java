package RecursiveCalculator;

public class Parser {
    private final Lexer lexer;
    private Token currentToken;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
        this.currentToken = lexer.getNextToken();
    }

    
    /** 
     * @return ASTNode
     */
    public ASTNode parse() {
        ASTNode result = expr();
        if (currentToken.getType() != TokenType.EOF) {
            throw new RuntimeException("Invalid syntax");
        }
        return result;
    }

    
    /** 
     * @return ASTNode
     */
    private ASTNode expr() {
        ASTNode result = term();
        while (currentToken.getType() == TokenType.PLUS || currentToken.getType() == TokenType.MINUS) {
            Token token = currentToken;
            if (token.getType() == TokenType.PLUS) {
                eat(TokenType.PLUS);
                result = ASTNode.binaryOperator("+", result, term());
            } else if (token.getType() == TokenType.MINUS) {
                eat(TokenType.MINUS);
                result = ASTNode.binaryOperator("-", result, term());
            }
        }
        return result;
    }

    
    /** 
     * @return ASTNode
     */
    private ASTNode term() {
        ASTNode result = factor();
        while (currentToken.getType() == TokenType.MULTIPLY || currentToken.getType() == TokenType.DIVIDE) {
            Token token = currentToken;
            if (token.getType() == TokenType.MULTIPLY) {
                eat(TokenType.MULTIPLY);
                result = ASTNode.binaryOperator("*", result, factor());
            } else if (token.getType() == TokenType.DIVIDE) {
                eat(TokenType.DIVIDE);
                result = ASTNode.binaryOperator("/", result, factor());
            }
        }
        return result;
    }

    
    /** 
     * @return ASTNode
     */
    private ASTNode factor() {
        Token token = currentToken;
        if (token.getType() == TokenType.INTEGER) {
            eat(TokenType.INTEGER);
            return ASTNode.integer((int) token.getValue());
        } else if (token.getType() == TokenType.LPAREN) {
            eat(TokenType.LPAREN);
            ASTNode result = expr();
            eat(TokenType.RPAREN);
            return result;
        } else if (token.getType() == TokenType.MINUS) {
            eat(TokenType.MINUS);
            return ASTNode.binaryOperator("-", ASTNode.integer(0), factor());
        } else {
            throw new RuntimeException("Invalid syntax");
        }
    }

    
    /** 
     * @param tokenType
     */
    private void eat(TokenType tokenType) {
        if (currentToken.getType() == tokenType) {
            currentToken = lexer.getNextToken();
        } else {
            throw new RuntimeException("Invalid syntax");
        }
    }
}