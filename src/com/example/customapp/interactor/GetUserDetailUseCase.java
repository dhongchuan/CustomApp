package com.example.customapp.interactor;

import com.example.customapp.model.UserModel;

public interface GetUserDetailUseCase extends IInteractor{
	public interface Callback{
		public void onUserDataLoaded(UserModel user);
		public void onError();
	}
	
	public void excute(int userID, Callback callback);

}
