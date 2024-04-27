package RecursiveCalculator;

/**
 * This program uses an abstract syntax tree to recursivly solve a mathematical expression
 */

import java.util.Scanner;

public class App {
    
    /** 
     * Main method that initilizes the objects and sets a while loop to continue till user inputs "quit"
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.print("Input mathematical expression: ");
            String input = sc.nextLine();

            Lexer lexer = new Lexer(input);
            Parser parser = new Parser(lexer);
            ASTNode tree = parser.parse();
            Fraction result = tree.evaluate();
            
            System.out.println("Result: " + result);
            if (input.equals("quit")) {
                break;
            }
        }
        System.out.println("Goodbye");
        sc.close();
    }
}
