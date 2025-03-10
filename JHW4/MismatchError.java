// Josh Kung (jhk2214)
// File:MismatchError.java
// Problem 1: Your `SymbolBalance` class will read through a Java file and check for simple syntatical errors. 
// You should write two methods, as specified by the `SymbolBalanceInterface` which you must implement for full credit.
public class MismatchError implements BalanceError {

	public int line;
	public char current;
	public char popped;

	public MismatchError(int lineNumber, char currentSymbol, char symbolPopped)
	{
		line = lineNumber;
		current = currentSymbol;
		popped = symbolPopped;
	}

	public String toString()
	{
		return "Mismatch Error: {line:" + line + ", current:" + current + ", popped:" + popped + "}";
	}
}
