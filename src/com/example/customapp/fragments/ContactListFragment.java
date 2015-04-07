package com.example.customapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.customapp.R;
import com.example.customapp.model.UserModel;
import com.example.customapp.presenter.UserDetailPresenter;
import com.example.customapp.view.IUserDetailView;

public class ContactListFragment extends Fragment implements IUserDetailView{
	private UserDetailPresenter mPresenter;
	private int mUserID;
	
	private TextView mTvUser;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_contacts, container, false);
		mTvUser = (TextView) view.findViewById(R.id.user_detail);
		Button refreshButton = (Button) view.findViewById(R.id.refresh);
		refreshButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				loadUserDetail();
			}
		});
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		mPresenter = new UserDetailPresenter();
		mPresenter.setView(this);
	}

	@Override
	public void startLoading() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void renderUserDeatil(UserModel userModel) {
		// TODO Auto-generated method stub
		mTvUser.setText(userModel.getUserName());
	}
	
	private void loadUserDetail(){
		mPresenter.loadUserDetail(mUserID);
	}

}
