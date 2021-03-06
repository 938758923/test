package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.template.dto.LoginDTO;
import com.internousdev.template.util.DBConnector;

public class LoginDAO {
	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword){//Actionから渡される
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		LoginDTO loginDTO=new LoginDTO();
		String sql="SELECT * FROM login_user_transaction where login_id=? AND login_pass=?";
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);

			preparedStatement.setString(1, loginUserId);//formで入力した値
			preparedStatement.setString(2, loginPassword);

			ResultSet resultSet=preparedStatement.executeQuery();//sql文を送る

			if(resultSet.next()){//next()は次があるとき順番に進む
				loginDTO.setLoginId(resultSet.getString("login_id"));
				loginDTO.setLoginPassword(resultSet.getString("login_pass"));
				loginDTO.setUserName(resultSet.getString("user_name"));
//データベースから持ってきてDTOに格納する
				if(resultSet.getString("login_id")!=null){
					loginDTO.setLoginFlg(true);//ログイン成功
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return loginDTO;
	}

}
