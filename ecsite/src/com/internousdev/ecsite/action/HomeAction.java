package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;

	public String execute(){
		String result="login";
		if(session.containsKey("login_user_id")){//containsKey(login_user_id)→login_user_idのキー値がある場合
			BuyItemDAO buyItemDAO=new BuyItemDAO();
			BuyItemDTO buyItemDTO=buyItemDAO.getBuyItemInfo();//商品情報取得
			session.put("id", buyItemDTO.getId());//sessionに格納しjspで取れるようにしておく
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());
			result=SUCCESS;
			//商品画面に遷移するので商品情報を取得し、DTOに格納しておく
		}
		return result;
	}

	public void setSession(Map<String, Object> session){
		this.session=session;
	}
	public Map<String, Object> getSession(){
		return this.session;
	}

}
