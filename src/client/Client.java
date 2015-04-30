package client;

import Ice.Application;

public class Client extends Application {

	@Override
	public int run(String[] args) {
		//��ȡPrinter��Զ�̴�������ʹ�õ�stringToProxy��ʽ
		Ice.ObjectPrx base = communicator().stringToProxy("HelloServer");
        //ͨ��checkedCast����ת������ȡPrinter�ӿڵ�Զ�̣���ͬʱ�����ݴ�������ƻ�ȡ�ķ���Ԫ�Ƿ�Printer�Ĵ���ӿڣ���������򷵻�null����
        DSE.PrinterPrx printer = DSE.PrinterPrxHelper.checkedCast(base);
        if (printer == null) throw new Error("Invalid proxy");
        //��Hello World��������ˣ��÷���˴�ӡ��������Ϊ����������ջ��ڷ������ִ��
        for(int i = 0;i<10;i++){
        	printer.printString("Hello World!����");
        }
		return 0;
	}

	public static void main(String[] args) {
		Client app = new Client();
		System.exit(app.main("Client", args,"server/ice.conf"));
	}

}
