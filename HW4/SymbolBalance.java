package HW4;

import java.util.Stack; // Importing Stack class for using stack data structure
import java.util.Scanner; // Importing Scanner class for reading file
import java.io.File; // Importing File class for file operations
import java.io.FileNotFoundException; // Importing FileNotFoundException for handling file not found errors

public class SymbolBalance implements SymbolBalanceInterface {

    private String filename;

    @Override
    public void setFile(String filename) {
        this.filename = filename;
    }

    @Override
    public BalanceError checkFile() {
        // Stack to track opening symbols.
        Stack<Character> A = new Stack<>();
        boolean withinString = false;   // are we inside a literal string ("...")?
        boolean withinComment = false;  // are we inside a multi-line comment (/* ... */)?

        try (Scanner scanner = new Scanner(new File(filename))) {
            int lineCount = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineCount++;

                // Process the line, one character at a time.
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);

                    // If inside a multi-line comment, only look for the closing "*/"
                    if (withinComment) {
                        if (ch == '*' && (i + 1) < line.length() && line.charAt(i + 1) == '/') {
                            // End of comment found. Pop the comment marker.
                            if (A.isEmpty()) {
                                return new EmptyStackError(lineCount);
                            }
                            char popped = A.pop();
                            if (popped != '*') {
                                return new MismatchError(lineCount, '/', popped);
                            }
                            withinComment = false;
                            i++; // Skip '/'
                        }
                        // Otherwise ignore all characters inside comment.
                        continue;
                    }

                    // If inside a literal string, only look for the closing quote.
                    if (withinString) {
                        if (ch == '"') {
                            if (A.isEmpty()) {
                                return new EmptyStackError(lineCount);
                            }
                            char popped = A.pop();
                            if (popped != '"') {
                                return new MismatchError(lineCount, ch, popped);
                            }
                            withinString = false;
                        }
                        // Ignore everything else inside the string.
                        continue;
                    }

                    // We are not in a comment or a string

                    // Check for start of a multi-line comment: "/*"
                    if (ch == '/' && (i + 1) < line.length() && line.charAt(i + 1) == '*') {
                        withinComment = true;
                        // Push the marker for a multi-line comment;
                        A.push('*');
                        i++; // Skip the '*' as it is part of the token.
                        continue;
                    }

                    // Check for stray "*/" encountered outside a comment.
                    if (ch == '*' && (i + 1) < line.length() && line.charAt(i + 1) == '/') {
                        // There is no matching opening comment
                        if (A.isEmpty()) {
                            return new EmptyStackError(lineCount);
                        }
                        char popped = A.pop();
                        if (popped != '*') {
                            return new MismatchError(lineCount, '/', popped);
                        }
                        i++; // Skip '/'
                        continue;
                    }

                    // Check for start of a literal string.
                    if (ch == '"') {
                        withinString = true;
                        A.push('"');
                        continue;
                    }

                    // Check if character is an opening symbol.
                    if (ch == '{' || ch == '(' || ch == '[') {
                        A.push(ch);
                        continue;
                    }

                    // Check if character is a closing symbol.
                    if (ch == '}' || ch == ')' || ch == ']') {
                        if (A.isEmpty()) {
                            // Closing symbol with no matching opening symbol.
                            return new EmptyStackError(lineCount);
                        }
                        char popped = A.pop();
                        if (!isPair(popped, ch)) {
                            return new MismatchError(lineCount, ch, popped);
                        }
                        continue;
                    }
                    // All other characters are ignored.
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null; // or rethrow, based on design choices.
        }

        // If any opening symbols remain on the stack, then return error.
        if (!A.isEmpty()) {
            return new NonEmptyStackError(A.peek(), A.size());
        }
        return null; // No errors were found.
    }

    /**
     * Helper function to determine if open and close symbols are a matching pair.
     */
    private boolean isPair(char open, char close) {
        return (open == '{' && close == '}') ||
               (open == '[' && close == ']') ||
               (open == '(' && close == ')') ||
               (open == '"' && close == '"');
    }


    public static void main(String[] args) {
        SymbolBalance test = new SymbolBalance(); 
        
        test.setFile("TestFiles/Test1.java");
        System.out.println("Test1.java: " + test.checkFile());
        
        test.setFile("TestFiles/Test2.java");
        System.out.println("Test2.java: " + test.checkFile());
        
        test.setFile("TestFiles/Test3.java");
        System.out.println("Test3.java: " + test.checkFile());
        
        test.setFile("TestFiles/Test4.java");
        System.out.println("Test4.java: " + test.checkFile());
        
        test.setFile("TestFiles/Test5.java");
        System.out.println("Test5.java: " + test.checkFile());
        
        test.setFile("TestFiles/Test6.java");
        System.out.println("Test6.java: " + test.checkFile());
    }

}