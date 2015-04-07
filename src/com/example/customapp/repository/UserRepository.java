package com.example.customapp.repository;

import java.util.ArrayList;

import com.example.customapp.model.UserModel;

public class UserRepository {
	public interface UserListCallBack{
		public void onUserListLoaded(ArrayList<UserModel> lists);
		public void onError();
	}
	public interface UserDetailCallBack{
		public void onUserDetailLoaded(UserModel user);
		public void onError();
	}
	
	public void getUsers(UserListCallBack callback){
		callback.onUserListLoaded(null);
	}
	
	public void getuserById(int id, UserDetailCallBack callback){
		UserModel userModel = new UserModel();
		userModel.setUserName("dhongchuan");
		callback.onUserDetailLoaded(userModel);
	}

}
