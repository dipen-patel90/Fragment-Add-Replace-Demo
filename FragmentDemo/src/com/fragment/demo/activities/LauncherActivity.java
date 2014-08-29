package com.fragment.demo.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.fragment.demo.R;
import com.fragment.demo.fragments.FragmentOne;
import com.fragment.demo.fragments.FragmentThree;
import com.fragment.demo.fragments.FragmentTwo;

/**
 * @author dipenp
 *
 */
public class LauncherActivity extends Activity {
	
	private Button replaceFragmentButton, addFragmentButton;
	private static int FRAGMENT_ONE_POSITION = 0, FRAGMENT_TWO_POSITION = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		/**************************************************
		 * Adding layout with two Button & two Fragment.
		 * One button to "Replace" fragment in first fragment & one button to "Add" fragment in second fragment.
		 * We have added same layout with different structure in different folder one in layout & one in layout-land(to display when device in landscape mode)
		 **************************************************/
		setContentView(R.layout.activity_launcher);
	
		replaceFragmentButton = (Button)findViewById(R.id.buttonOne);
		addFragmentButton = (Button)findViewById(R.id.buttonTwo);
		
		/**
		 * When we click on this button it will "Replace" existing fragment and add new one. 
		 */
		replaceFragmentButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FragmentTransaction fragmentOneTransaction = getFragmentManager().beginTransaction();				
				
				switch (FRAGMENT_ONE_POSITION) {
				case 0:
					FRAGMENT_ONE_POSITION++;
					fragmentOneTransaction.replace(R.id.fragment_one_holder, new FragmentOne(LauncherActivity.this));
					break;
				case 1:
					FRAGMENT_ONE_POSITION++;
					fragmentOneTransaction.replace(R.id.fragment_one_holder, new FragmentTwo(LauncherActivity.this));
					break;
				case 2:
					FRAGMENT_ONE_POSITION = 0;
					fragmentOneTransaction.replace(R.id.fragment_one_holder, new FragmentThree(LauncherActivity.this));
					break;
				default:
					break;
				}
				
//				fragmentOneTransaction.addToBackStack(null);
				fragmentOneTransaction.commit();
			}
		});
		
		
		/**
		 * When we click on this button it will "Add" new fragment. 
		 */
		addFragmentButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FragmentTransaction fragmentTwoTransaction = getFragmentManager().beginTransaction();
				
				switch (FRAGMENT_TWO_POSITION) {
				case 0:
					FRAGMENT_TWO_POSITION++;
					fragmentTwoTransaction.add(R.id.fragment_two_holder, new FragmentOne(LauncherActivity.this));
					break;
				case 1:
					FRAGMENT_TWO_POSITION++;
					fragmentTwoTransaction.add(R.id.fragment_two_holder, new FragmentTwo(LauncherActivity.this));
					break;
				case 2:
					FRAGMENT_TWO_POSITION = 0;
					fragmentTwoTransaction.add(R.id.fragment_two_holder, new FragmentThree(LauncherActivity.this));
					break;
				default:
					break;
				}

				/**
				 * Adding current fragment to back stack which can be pop back when we need.
				 * We can add name to this back stack and we can access this fragment by name later.
				 */
				fragmentTwoTransaction.addToBackStack(null);
				fragmentTwoTransaction.commit();
			}
		});
	}
	
	/**************************************
	 * Overriding onBackPressed button and pop backStack fragment. 
	 * 
	 **************************************/
	@Override
	public void onBackPressed() {
		FragmentManager fm = getFragmentManager();
		if (fm.getBackStackEntryCount() > 0) {
			fm.popBackStack();
		} else {
			super.onBackPressed();
		}
	}
}
