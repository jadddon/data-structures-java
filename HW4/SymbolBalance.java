package HW4;

import java.util.Stack;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class SymbolBalance implements SymbolBalanceInterface {
    private String filename;
    
    @Override
    public void setFile(String filename) {
        this.filename = filename;
    }
    
    @Override
    public BalanceError checkFile() {
        // Initialize a stack to keep track of symbols
        Stack<Character> stack = new Stack<>();
        
        try (Scanner scanner = new Scanner(new File(filename))) {
            int lineNumber = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineNumber++;
                
                // Process each character in the line
                for (char ch : line.toCharArray()) {
                    // Add logic to handle opening and closing symbols
                    // Example: if (ch == '{') { stack.push(ch); }
                    // Example: if (ch == '}') { check for matching '{' }
                }
            }
            
            // Check for any remaining unmatched symbols in the stack
            if (!stack.isEmpty()) {
                char topElement = stack.peek();
                return new NonEmptyStackError(topElement, stack.size());
            } 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        return null; // Return null if no errors are found
    }
}
