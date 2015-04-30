package server;

import DSE._PrinterDisp;
import Ice.Current;

public class ServerI extends _PrinterDisp {

	public void printString(String s, Current __current) {
		System.out.println("hello "+s);
	}

}
