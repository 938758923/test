package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.BuyItemDAO;
import com.internousdev.template.dao.LoginDAO;
import com.internousdev.template.dto.BuyItemDTO;
import com.internousdev.template.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
	private String loginUserId;//value from login.jsp
	private String loginPassword;
	private String result;
	private Map<String,Object> session;

	public String execute(){
		LoginDAO loginDAO=new LoginDAO();
		LoginDTO loginDTO=new LoginDTO();
		BuyItemDAO buyItemDAO=new BuyItemDAO();

		result=ERROR;
		loginDTO=loginDAO.getLoginUserInfo(loginUserId, loginPassword);//DAOに渡してログイン判定をしてもらう
		session.put("loginUser", loginDTO);//key=loginUser,,value=loginDTO

		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){
			result=SUCCESS;
			BuyItemDTO buyItemDTO=buyItemDAO.getBuyItemInfo();

			session.put("login_user_id", loginDTO.getLoginId());//Mapに格納。jspで表示できるようになる
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());
			return result;
		}
		return result;
	}

	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId=loginUserId;
	}
	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword=loginPassword;
	}
	public String getResult(){
		return result;
	}
	public void setResult(String result){
		this.result=result;
	}
	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
