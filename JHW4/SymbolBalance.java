// Josh Kung (jhk2214)
// File:SymbolBalance.java
// Problem 1: Your `SymbolBalance` class will read through a Java file and check for simple syntatical errors. 
// You should write two methods, as specified by the `SymbolBalanceInterface` which you must implement for full credit.

/** Strategy for solving problem from Lecture 9 2/19 Notes
 * break down into smaller parts and find what is independent (doesn't need other methods)
 * make that work and test it before moving on
 * read file character by character: (1)curly braces then square brackets and then paranthesis (2) strings (3) comments
 * 
 * 2 focuses: (1) long and must test piece by piece (2) <30 lines, very concise and takes thinking
 *  */ 

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.util.Stack; 

public class SymbolBalance implements SymbolBalanceInterface{

    private File relativePath; 
    private Scanner in; 
    private Stack<Character> stack = new Stack<>();
    private char[] charArray; // turn the file into an array of chars
    private boolean insideString = false; // looks to see if we're in a string
    private boolean inComment = false; 
    private char currentSymbol; 


    //The first method, `setFile`, should take in a String representing the path to the file that should be checked.
    public void setFile(String filename){
        this.relativePath = new File(filename); // use File for its isFile method

        if(!relativePath.isFile()){
            System.out.println("Nonexistent file: path is incorrect or file was not provided");  
            this.relativePath = null;// since it's a faulty path, we can set to null
        } else { 
            System.out.println("File found: relative path is legit");
        }
    }

    public BalanceError checkFile(){
        //clean it out before dirty work
        stack.clear();
        insideString = false; // looks to see if we're in a string
        inComment = false;

        // 1: our relative path is null for 
        if(relativePath == null){
            throw new NullPointerException("FileNotFound buddy, try again with the .setFile method");
        }
        // 2: safely reading in the file 
        try{
            in = new Scanner(relativePath); // we safely determined through setFile that this is okay to do
            int lineNumber = 0; 

            while(in.hasNextLine()){
                String line = in.nextLine();// storing this in string
                // System.out.println(line); // printing to see contents of file
                lineNumber++;
                charArray = line.toCharArray(); // parsing it into array for char

                // this is where the magic will happen 
                for(int i = 0; i < charArray.length; i++){
                    currentSymbol = charArray[i]; 
                    insideComment(charArray, i);

                    if(inComment){
                        continue; 
                    }

                    // this shows that we successfully printed things out
                    // System.out.println("Current symbol:" + currentSymbol);
                    
                    if(currentSymbol == '"'){
                        if (!insideString) {
                            stack.push(currentSymbol);  // push when entering a string
                        } else if (!stack.isEmpty() && stack.peek() == '"') {
                            stack.pop();  // pop when exiting a string
                        }
                        insideString = !insideString;  // flip whatever sign
                        continue;
                        
                    } 

                    // add shit to our stack for now only if we are not inside a string 
                    if(insideString == false && (currentSymbol == '{' || currentSymbol == '[' || currentSymbol == '(')){
                        stack.push(currentSymbol); 
                    }
                    else if(insideString == false && (currentSymbol == '}' || currentSymbol == ']' || currentSymbol == ')')){
                        if(stack.isEmpty()){
                            EmptyStackError emptyStackError = new EmptyStackError(lineNumber);
                            System.out.println(emptyStackError);
                            return emptyStackError;
                        }
                        if(isMatchingSet(currentSymbol)){
                            // System.out.println("Line #" + lineNumber + ": Top of stack symbol ( " +  stack.peek() + " ) vs current symbol( " + currentSymbol + " ) \n It's match & we'll pop");
                            stack.pop(); 
                        } else { 
                            
                            char popped = stack.pop(); 
                            MismatchError mismatchError = new MismatchError(lineNumber, currentSymbol, popped); 
                            System.out.println(mismatchError);
                            return mismatchError;
                        }
                    }
                }
                
            }
            // this means we ran through the loop and there are still elements in our stack
            if (insideString == true) {
                System.out.println("Error: Unclosed string literal detected.");
            }
            if(!stack.isEmpty()){
                NonEmptyStackError nonEmptyStackError = new NonEmptyStackError(stack.peek(), stack.size()); 
                System.out.println(nonEmptyStackError);
                return nonEmptyStackError;
            }
            in.close(); 

        } catch(FileNotFoundException e) {
            System.out.println("FileNotFound buddy, try again with the .setFile method");
        }        
        System.out.println("No error: returning null");
        return null;
    }

    public boolean isMatchingSet(char x){
        if(stack.isEmpty()) return false; 
        switch(x){
            case '}': return stack.peek() == '{'; 
            case ']': return stack.peek() == '['; 
            case ')': return stack.peek() == '(';
            case '"': return stack.peek() == '"';
        }
        return false; 
    }

    private void insideComment(char[] charArray, int index) {
        if (index < charArray.length - 1 && charArray[index] == '/' && charArray[index + 1] == '*') inComment = true;
        if (index < charArray.length - 1 && charArray[index] == '*' && charArray[index + 1] == '/') inComment = false;
    }
    public static void main(String[] args){
        SymbolBalance test = new SymbolBalance(); 
        // test.setFile("TestFiles/Lebron.java");
        // test.checkFile();
        // System.out.println("trying again");
        
        test.setFile("TestFiles/Test1.java");
        test.checkFile();
        test.setFile("TestFiles/Test2.java");
        test.checkFile();
        test.setFile("TestFiles/Test3.java");
        test.checkFile();
        test.setFile("TestFiles/Test4.java");
        test.checkFile();
        test.setFile("TestFiles/Test5.java");
        test.checkFile();
        test.setFile("TestFiles/Test6.java");
        test.checkFile();


    }

}



