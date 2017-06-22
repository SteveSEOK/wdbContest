package yjc.wdb.bbs;

import java.io.IOException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

public class WebSocketHander implements WebSocketHandler {
    private static final Logger logger = LoggerFactory.getLogger(WebSocketHander.class);

    private static final ArrayList<WebSocketSession> users = new ArrayList<>();
    private static final ArrayList<WebSocketSession> team = new ArrayList<>();


    
    
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.debug("占쏙옙占쏙옙占� 占쏙옙크......");
        users.add(session);
        team.add(session);
        String userName = (String) session.getHandshakeAttributes().get("WEBSOCKET_USERNAME");
        if(userName!= null){
            session.sendMessage(new TextMessage(userName+ "님 어서오세요"));
        }
    }  

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> webSocketMessage) throws Exception {
    	String clientName = (String) session.getHandshakeAttributes().get("WEBSOCKET_USERNAME");
    	String t_id = (String) session.getHandshakeAttributes().get("WEBSOCKET_t_id");
    //	clientName = "<a onclick='changeChater(this)'>" + clientName + "</a>";
    	
    	String msg = webSocketMessage.getPayload().toString();
    	String charter = "";

    	System.out.println(t_id+"/"+msg);
    	String msgs[] = msg.split("\\|");
    	if(msgs.length > 4){
    		msg = msgs[2];
    		sendMessageToUsers(new TextMessage("!!#time"+msg));
    	}
    	else{
    	    		sendMessageToUser(t_id, new TextMessage(clientName + " : " + msg));
    	}//charter 받는사람  //clientName 보내는사람
    	/*else {
    		sendMessageToUsers(new TextMessage(clientName + " :" + msg));
    		

    	}*/
        
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        if(webSocketSession.isOpen()){
            webSocketSession.close();
        }
        logger.debug("占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쌩삼옙占쌩쏙옙占싹댐옙");
        users.remove(webSocketSession);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        logger.debug("占쏙옙크占쌥깍옙" + closeStatus.toString());
        users.remove(webSocketSession);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
    
    /**
     *
     * @param message
     */
    public void sendMessageToUsers(TextMessage message) {
        for (WebSocketSession user : users) {
            try {
                if (user.isOpen()) {
                    user.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param userName
     * @param message
     */
    public void sendMessageToUser(String t_id, TextMessage message) {
        for (WebSocketSession user : users) {
            if (user.getHandshakeAttributes().get("WEBSOCKET_t_id").equals(t_id)) {
                try {
                    if (user.isOpen()) {
                        user.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
