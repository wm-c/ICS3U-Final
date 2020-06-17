package client;

import java.util.ArrayList;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
 
public class ChatClientHandler extends SimpleChannelInboundHandler<String> {
 
	private static ArrayList<String> messages;

	public ChatClientHandler(){
		messages = new ArrayList<String>();
	}


	/*
	 * Print chat message received from server.
	 */
	@Override
	public void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		String[] messageList = msg.substring(1).split(",");
		
		for(String message : messageList){
			messages.add(message);
			System.out.println(message);
		}
		
	}


	public ArrayList<String> getMessages(){
		return messages;
	}


	public void setMessages(ArrayList<String> msg){
		messages = msg;
	}


 


}