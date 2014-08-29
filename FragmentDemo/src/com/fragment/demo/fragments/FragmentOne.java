package com.fragment.demo.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.fragment.demo.R;
import com.fragment.demo.activities.LauncherActivity;

/**
 * @author dipenp
 *
 */
public class FragmentOne extends Fragment{

	StringBuilder sb = new StringBuilder();
	Context _context;
	
	public FragmentOne() {
	}
	
	public FragmentOne(LauncherActivity launcherActivity) {
		_context = launcherActivity;
	}
	
	@Override
	public void onAttach(Activity activity) {
		sb.append("\n:::::::1:::::::");
		sb.append("\n onAttach\n");
		super.onAttach(activity);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		sb.append("onCreate\n");
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		sb.append("onCreateView\n");
		
		View rootView = inflater.inflate(R.layout.fragment_one_layout, container, false);
		return rootView;
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		sb.append("onViewCreated\n");
		
		TextView tv = (TextView)view.findViewById(R.id.textView);
		tv.setText(FragmentOne.class.getSimpleName()+sb);
		super.onViewCreated(view, savedInstanceState);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		sb.append("onActivityCreated\n");
		super.onActivityCreated(savedInstanceState);
	}
	
	@Override
	public void onStart() {
		sb.append("onStart\n");
		super.onStart();
	}
	
	@Override
	public void onResume() {
		sb.append("onResume\n");
		super.onResume();
	}
	
	@Override
	public void onPause() {
		sb.append("onPause\n");
		super.onPause();
	}
	
	@Override
	public void onStop() {
		sb.append("onStop\n");
		super.onStop();
	}
	
	@Override
	public void onDestroyView() {
		sb.append("onDestroyView\n");
		super.onDestroyView();
	}
	
	@Override
	public void onDestroy() {
		sb.append("onDestroy\n");
		super.onDestroy();
	}
	
	@Override
	public void onDetach() {
		if(null!= sb){
			sb.append("onDetach\n");
			if(_context != null){
				/**
				 * You can remove below commented line to check Fragment life cycle.
				 * It will show toast message with all the method which executed in serial order   
				 */
//				Toast.makeText(_context, ""+sb, Toast.LENGTH_LONG).show();
				Toast.makeText(_context, FragmentOne.class.getSimpleName()+" is Detach", Toast.LENGTH_LONG).show();	
			}	
		}
		super.onDetach();
	}
}
