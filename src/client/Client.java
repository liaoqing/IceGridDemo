package client;

import Ice.Application;

public class Client extends Application {

	@Override
	public int run(String[] args) {
		//获取Printer的远程代理，这里使用的stringToProxy方式
		Ice.ObjectPrx base = communicator().stringToProxy("HelloServer");
        //通过checkedCast向下转换，获取Printer接口的远程，并同时检测根据传入的名称获取的服务单元是否Printer的代理接口，如果不是则返回null对象
        DSE.PrinterPrx printer = DSE.PrinterPrxHelper.checkedCast(base);
        if (printer == null) throw new Error("Invalid proxy");
        //把Hello World传给服务端，让服务端打印出来，因为这个方法最终会在服务端上执行
        for(int i = 0;i<10;i++){
        	printer.printString("Hello World!哈哈");
        }
		return 0;
	}

	public static void main(String[] args) {
		Client app = new Client();
		System.exit(app.main("Client", args,"server/ice.conf"));
	}

}
