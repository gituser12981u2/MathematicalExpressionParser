# Java Expression Parser

## Project Overview
This Java application is designed to parse and evaluate mathematical expressions. It utilizes a Lexer to tokenize input, a Parser to construct an abstract syntax tree (AST), and evaluates these expressions to return results in fractional form.

## Files Description
- **`App.java`**: The main entry point of the application that sets up the environment and starts the parser.
- **`ASTNode.java`**: Defines nodes for the abstract syntax tree used by the parser to represent expressions.
- **`Fraction.java`**: Handles operations and representations of fractions to maintain accuracy in calculations.
- **`Lexer.java`**: Responsible for breaking down the input into recognizable tokens.
- **`Parser.java`**: Parses tokens to construct an AST based on the defined grammar of expressions.
- **`Token.java`**: Represents a token object with a specific type and value.
- **`TokenType.java`**: Enumerates possible types of tokens that can be recognized by the lexer.

## Setup and Running
To run this project, ensure you have Java installed on your machine.

1. **Compile the project:**
   ```bash
   javac App.java
   ```

2. **Run the application:**
    ```bash
    java App
    ```

## Contributing
Contributions to this project are welcome. Please adhere to the following steps for contributions:

1. Fork the repository.
2. Create a new branch for your feature.
3. Add your contributions.
4. Submit a pull request.

## License
This project is relased under the GLU 3.0 License. Details can be fount in the '[LICENSE](LICENSE)' file. 
