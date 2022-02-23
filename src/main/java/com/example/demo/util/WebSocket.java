package com.example.demo.util;
 
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import net.sf.json.JSONObject;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.example.demo.model.InspectMessageBean;
import com.example.demo.service.InspectMassageService;

@ServerEndpoint("/webSocket/{sid}/{groupId}") 
@Component
    public class WebSocket { 
	
	//此处是解决无法注入的关键
    private static ApplicationContext applicationContext;
   
    //要注入的service或者dao
    private static InspectMassageService inspectMassageService;
    
    
    
    public static void setApplicationContext(ApplicationContext applicationContext) {
    	WebSocket.applicationContext = applicationContext;
    }
	
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<WebSocket>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    //接收sid
    private String sid="";
    private String groupId="";
    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(Session session,@PathParam("sid") String sid,@PathParam("groupId") String groupId) {
        this.session = session;
        webSocketSet.add(this);     //加入set中
        addOnlineCount();           //在线数加1
        System.out.println("有新窗口开始监听:"+sid+",当前在线人数为" + getOnlineCount());
        this.sid=sid;
        this.groupId=groupId;
        try {
        	 sendMessage("连接成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session) {
    	System.out.println("收到来自窗口"+sid+"的信息:"+message);
        //群发消息
        for (WebSocket item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

	/**
	 * 
	 * @param session
	 * @param error
	 */
    @OnError
    public void onError(Session session, Throwable error) {
    	System.out.println("发生错误");
        error.printStackTrace();
    }
	/**
	 * 实现服务器主动推送
	 */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }


    /**
     * 群发自定义消息
     * */
    public static void sendInfo(Map<String,String> map,@PathParam("sid") String sid) throws IOException {
    	System.out.println("推送消息到窗口"+sid+"，推送内容:"+map.get("message"));
        for (WebSocket item : webSocketSet) {
        	JSONObject json = new JSONObject();
        	json.put("message", "alarm");
    		json.put("img_url", map.get("message"));
    		json.put("group_name", map.get("group_name"));
    		json.put("person_name", map.get("person_name"));
            try {
            	//这里可以设定只推送给这个sid的，为null则全部推送
            	if(sid==null) {
            		item.sendMessage(json.toString());
            	}else if(item.sid.equals(sid)){
            		item.sendMessage(json.toString());
            	}
            } catch (IOException e) {
                continue;
            }
        }
    }
    
    public static void sendinspectInfo(Integer inspect_id,String message,String sid) throws IOException {
    	System.out.println("------------------------------websocket---------------------------------------------");
    	inspectMassageService = applicationContext.getBean(InspectMassageService.class);
    	System.out.println("------------------------------websocket111---------------------------------------------");
        for (WebSocket item : webSocketSet) {
        	InspectMessageBean bean = new InspectMessageBean();
        	bean.setAttribution_dept(item.groupId);
        	bean.setEvent_name("在岗巡查");
        	bean.setGroup_id(item.groupId);
        	bean.setHandle_status("0");
        	bean.setHandle_user(item.sid);
        	inspectMassageService.insertInspectMessage(bean);
        	System.out.println("------------------"+item.sid+"------------"+bean.getId()+"---------------------------------------------");
        	JSONObject json = new JSONObject();
    		json.put("message", message);
    		json.put("inspect_id", bean.getId());
            try {
            	//这里可以设定只推送给这个sid的，为null则全部推送
            	if(sid==null) {
            		item.sendMessage(json.toString());
            		System.out.println("------------------"+item.sid+"------------aaa---------------------------------------------");
            	}else if(item.sid.equals(sid)){
            		item.sendMessage(json.toString());
            		System.out.println("----------------"+item.sid+"--------------bbb---------------------------------------------");
            	}
            } catch (IOException e) {
                continue;
            }
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
    	WebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
    	WebSocket.onlineCount--;
    }
}
