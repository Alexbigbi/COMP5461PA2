import java.util.*;
import java.lang.Exception;

/**
 * Class BlockStack
 * Implements character block stack and operations upon it.
 *
 * $Revision: 1.4 $
 * $Last Revision Date: 2019/02/02 $
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca;
 * Inspired by an earlier code by Prof. D. Probst

 */
class BlockStack
{
	/**
	 * # of letters in the English alphabet + 2
	 */
	public static final int MAX_SIZE = 28;

	/**
	 * Default stack size
	 */
	public static final int DEFAULT_SIZE = 6;

	/**
	 * Current size of the stack
	 */
	private int iSize = DEFAULT_SIZE;
	public int getSize() { return this.iSize; }

	/**
	 * Current top of the stack
	 */
	private int iTop  = 3;
	public int getTop() { return this.iTop; }

	/**
	 * stack[0:5] with four defined values
	 */
	private char acStack[] = new char[] {'a', 'b', 'c', 'd', '$', '$'};

	private int StackAccessCounter = 0;
	public int getAccessCounter() { return this.StackAccessCounter; }

	/**
	 * Default constructor
	 */
	public BlockStack()
	{
	}

	/**
	 * Supplied size
	 */
	public BlockStack(final int piSize)
	{
		if(piSize != DEFAULT_SIZE)
		{
			this.acStack = new char[piSize];

			// Fill in with letters of the alphabet and keep
			// 2 free blocks
			for(int i = 0; i < piSize - 2; i++)
				this.acStack[i] = (char)('a' + i);

			this.acStack[piSize - 2] = this.acStack[piSize - 1] = '$';

			this.iTop = piSize - 3;
                        this.iSize = piSize;
		}
	}

	public static class OutOfBoundsException extends Exception
	{
		public OutOfBoundsException(String errorMessage, Throwable error)
		{
			super(errorMessage, error);
		}
	}

	public boolean isEmpty() {
		return this.iTop < 0;
	}

	public boolean isFull() {
		return this.iTop >= this.iSize - 1;
	}

	/**
	 * Picks a value from the top without modifying the stack
	 * @return top element of the stack, char
	 */
	public char pick()
	{
		return this.acStack[this.iTop];
	}

	/**
	 * Returns arbitrary value from the stack array
	 * @return the element, char
	 */
	public char getAt(final int piPosition)
	{
		if (this.acStack[piPosition] == ' ')
		{
			System.out.println('*');
		}
		else
		{
			System.out.println('$');
		}

		StackAccessCounter++;


		return this.acStack[piPosition];
	}

	/**
	 * Standard push operation
	 */
	public void push(final char pcBlock) throws OutOfBoundsException
	{
		if (isFull()) {
			throw new OutOfBoundsException("Stack is full.", null);
		}

		if (this.acStack[this.iTop] == ' ') {
			System.out.println('*');
			this.acStack[this.iTop] = 'a'; //not sure about this one
		} else {
			System.out.println("Successful push.");
			this.acStack[++this.iTop] = pcBlock;
		}

		StackAccessCounter++;
	}


	/**
	 * Standard pop operation
	 * @return ex-top element of the stack, char
	 */
	public char pop() throws OutOfBoundsException {

		if (isEmpty()) {
			throw new OutOfBoundsException("Stack is empty.", null);
		}

		char cBlock = this.acStack[this.iTop];

		if (cBlock == ' ') {
			System.out.println('*');
		} else {
			System.out.println("Successful pop.");
		}

		StackAccessCounter++;

		this.acStack[this.iTop--] = '$'; // Leave prev. value undefined
		return cBlock;
	}
}


// EOF
