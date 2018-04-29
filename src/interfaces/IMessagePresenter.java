package interfaces;

public interface IMessagePresenter {
	
	void sendGeneralMessage(String nickname,String msg);
	void sendRoomMessage(String room,String nickname,String msg);
	void joinToSelectedRoom(String room);
	
}
