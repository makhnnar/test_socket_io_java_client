package presenters;

import org.json.JSONObject;

import interfaces.IMessagePresenter;
import interfaces.IOSocketListener;
import interfaces.OnMessageListener;
import managers.SocketManager;

public class MessagePresenter implements IMessagePresenter,IOSocketListener{

	private OnMessageListener listener;
	private SocketManager socket;
	
	public MessagePresenter(OnMessageListener listener){
		this.listener = listener;
		socket = new SocketManager(this);
	}
	
	public void sendGeneralMessage(String nickname, String msg) {
		try{
			JSONObject enviar = new JSONObject();
			enviar.put("nickname", nickname);
			enviar.put("message", msg);
			socket.emit("chat",enviar);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public void sendRoomMessage(String room, String nickname, String msg) {
		try{
			JSONObject enviar = new JSONObject();
			enviar.put("nickname", nickname);
			enviar.put("message", msg);
			socket.emit("chat_room",enviar);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void onRoomMsg(String msg) {
		listener.onMessageRecieved(msg);
	}

	public void onGeneralMsg(String msg) {
		listener.onMessageRecieved(msg);
	}

	public void joinToSelectedRoom(String room) {
		try{
			JSONObject enviar = new JSONObject();
			enviar.put("room", room);
			socket.emit("join_room",enviar);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
