package managers;


import java.net.URISyntaxException;

import org.json.JSONObject;

import interfaces.IOSocketListener;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;


public class SocketManager{
	
	private static Socket socket;
	private IOSocketListener listener;
	private String URL;
	
	public SocketManager(IOSocketListener listener){
		new SocketManager(listener,"http://localhost:4005");
	}
	
	public SocketManager(final IOSocketListener listener,String url){
		this.listener = listener;
		try {
			IO.Options opts = new IO.Options();
	        opts.forceNew = true;
	        opts.reconnection = true;
			
			socket = IO.socket(url,opts);
			socket.connect();
			socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
				
				public void call(Object... args) {
					System.out.println("CONECTO AL SERVER");
					System.out.println(args.toString());
					
				}
			});
			socket.on("chat", new Emitter.Listener() {
				
				public void call(Object... args) {
					JSONObject objeto;
					try{
						objeto = (JSONObject) args[0];
						listener.onGeneralMsg(objeto.getString("nickname")+": "+objeto.getString("message"));
					}catch(Exception e){
						
					}
				}
				
			});
			socket.on("directo", new Emitter.Listener() {
				
				public void call(Object... args) {
					listener.onGeneralMsg((String)args[0]);
				}
				
			});
			socket.on("data", new Emitter.Listener() {
				
				public void call(Object... args) {
					listener.onGeneralMsg((String)args[0]);
				}
		
			});
			socket.on(Socket.EVENT_ERROR, new Emitter.Listener() {
				
				public void call(Object... args) {
					System.out.println("ERROR DESDE EL SOCKET DE ERROR");
					System.out.println(args[0]);
				}
		
			});
			socket.open();
		} catch (URISyntaxException e) {
			System.out.println("EXECPCION INICIANDO"+e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public void emit(String evento,JSONObject msg){
		try {
			socket.emit(evento, msg);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("EXCEPCION: "+e.getMessage());
		}
	}
	


}

