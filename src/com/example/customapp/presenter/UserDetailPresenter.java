package com.example.customapp.presenter;

import com.example.customapp.interactor.GetUserDetailUseCase;
import com.example.customapp.interactor.GetUserDetailUserCaseImpl;
import com.example.customapp.model.UserModel;
import com.example.customapp.repository.UserRepository;
import com.example.customapp.utils.Executor;
import com.example.customapp.utils.PostUIExecution;
import com.example.customapp.view.IUserDetailView;

public class UserDetailPresenter implements IPresenter{
	private IUserDetailView mView;
	private GetUserDetailUseCase mUserDetailUseCase;
	private Executor mExecutor;
	private PostUIExecution mUIExecution;
	private UserRepository mUserRepo;
	private GetUserDetailUseCase.Callback mUseCaseCallback = new GetUserDetailUseCase.Callback() {
		
		@Override
		public void onUserDataLoaded(UserModel user) {
			mView.renderUserDeatil(user);
		}
		
		@Override
		public void onError() {
			
		}
	};
		

	public UserDetailPresenter() {
		super();
		mUserRepo = new UserRepository();
		mExecutor = new Executor();
		mUIExecution = new PostUIExecution();
		mUserDetailUseCase = new GetUserDetailUserCaseImpl(mExecutor,mUIExecution, mUseCaseCallback, mUserRepo);
	}
	
	public void setView(IUserDetailView view){
		this.mView = view;
	}
	
	public void loadUserDetail(int userID){
		mView.startLoading();
		this.getUserDetail(userID);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
	
	private void getUserDetail(int userID){
//		UserModel userModel = new UserModel();
//		userModel.setUserName("dhongchuan");
//		mView.renderUserDeatil(userModel);
		mUserDetailUseCase.excute(userID, mUseCaseCallback);
	}

}
