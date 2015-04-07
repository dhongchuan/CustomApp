package com.example.customapp.interactor;


import com.example.customapp.model.UserModel;
import com.example.customapp.repository.UserRepository;
import com.example.customapp.repository.UserRepository.UserDetailCallBack;
import com.example.customapp.utils.Executor;
import com.example.customapp.utils.PostUIExecution;

public class GetUserDetailUserCaseImpl implements GetUserDetailUseCase{
	private Executor mExecutor;
	private PostExecutionThread mUIThread;
	private Callback mCallback;
	private UserRepository mUserRepo;
	private int mUserID;
	
	private UserDetailCallBack mUserDetailCallBack = new UserDetailCallBack() {
		
		@Override
		public void onUserDetailLoaded(UserModel user) {
			notifyLoaded(user);
			
		}
		
		@Override
		public void onError() {
			notifyLoadError();
			
		}
	};
	

	public GetUserDetailUserCaseImpl(Executor executor, PostExecutionThread uiTHread, Callback callback, UserRepository userRepo) {
		super();
		mExecutor = executor;
		mUIThread = uiTHread;
		mCallback = callback;
		mUserRepo = userRepo;
	}

	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		mUserRepo.getuserById(mUserID, mUserDetailCallBack);
	}

	@Override
	public void excute(int userID, Callback callback) {
		mUserID = userID;
		mCallback = callback;
		mExecutor.submit(this);
	}
	
	private void notifyLoaded(final UserModel user){
		mUIThread.post(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				mCallback.onUserDataLoaded(user);
			}
		});
	}
	
	protected void notifyLoadError() {
		// TODO Auto-generated method stub
		mCallback.onError();
	}

}
