package com.gallifrey.todayapplication.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.gallifrey.todayapplication.R;


public class PhoneFragment extends Fragment {
    private static final String ARG_PARAM="param1";
    private static final String TAG="PhoneFragment";
    private String param;
    private IPhoneCallBack iPhoneCallBack;
    public PhoneFragment(){
        Log.i(TAG, "PhoneFragment: ");
    }
    public static PhoneFragment newInstance(String param1){
        Log.i(TAG, "newInstance: into");
        PhoneFragment phoneFragment=new PhoneFragment();
        Bundle args=new Bundle();
        args.putString(ARG_PARAM,param1);
        phoneFragment.setArguments(args);
        Log.i(TAG, "newInstance: out");
        return phoneFragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        Log.i(TAG, "onAttach: ");
        super.onAttach(context);
        iPhoneCallBack= (IPhoneCallBack) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            param=getArguments().getString(ARG_PARAM);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView: ");
        View view=inflater.inflate(R.layout.fragment_phone,container,false);
        TextView textView=view.findViewById(R.id.fl_tv);
        textView.setText(param);
        iPhoneCallBack.setData("通讯录Activity");
        return view;
    }

    @Override
    public void onDestroyView() {
        Log.i(TAG, "onDestroyView: ");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy: ");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.i(TAG, "onDetach: ");
        super.onDetach();
    }

    public interface IPhoneCallBack{
        void setData(String str);
    }
}
