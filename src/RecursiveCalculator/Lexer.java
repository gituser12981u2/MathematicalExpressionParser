package RecursiveCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Lexer {
    private final String input;
    private int pos;
    private Token currentToken;

    public Lexer(String input) {
        this.input = input;
        this.pos = 0;
        this.currentToken = null;
    }

    
    /** 
     * @return Token
     */
    public Token getNextToken() {
        while (pos < input.length()) {
            char ch = input.charAt(pos);
            if (ch == ' ') {
                pos++;
                continue;
            }
            if (ch == '+') {
                pos++;
                return new Token(TokenType.PLUS, null);
            }
            if (ch == '-') {
                pos++;
                return new Token(TokenType.MINUS, null);
            }
            if (ch == '*') {
                pos++;
                return new Token(TokenType.MULTIPLY, null);
            }
            if (ch == '/') {
                pos++;
                return new Token(TokenType.DIVIDE, null);
            }
            if (ch == '(') {
                pos++;
                return new Token(TokenType.LPAREN, null);
            }
            if (ch == ')') {
                pos++;
                return new Token(TokenType.RPAREN, null);
            }
            Matcher matcher = Pattern.compile("\\d+").matcher(input.substring(pos));
            if (matcher.lookingAt()) {
                int end = matcher.end();
                int value = Integer.parseInt(input.substring(pos, pos + end));
                pos += end;
                return new Token(TokenType.INTEGER, value);
            }
            throw new RuntimeException("Invalid syntax");
        }
        return new Token(TokenType.EOF, null);
    }

    
    /** 
     * @return Token
     */
    public Token getCurrentToken() {
        return currentToken;
    }

    public void putBack() {
        if (currentToken == null) {
            throw new RuntimeException("No token to put back");
        }
        pos -= currentToken.toString().length();
        currentToken = null;
    }
}
