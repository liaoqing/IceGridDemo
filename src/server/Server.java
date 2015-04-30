package server;

import Ice.Application;
import Ice.ObjectAdapter;

public class Server extends Application {

	@Override
	public int run(String[] args) {
		ObjectAdapter adapter = communicator().createObjectAdapter(
				"HelloServerAdapter");
		adapter.add(
				new ServerI(),
				communicator().stringToIdentity("HelloServer"));

		adapter.activate();

		communicator().waitForShutdown();
		return 0;	
	}

	public static void main(String[] args) {
		Server server = new Server();
		server.main("helloService", args);
	}

}
