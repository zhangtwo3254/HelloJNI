package com.example.hellojni;

import com.example.hellojni.util.NumberUtil;
import com.example.hellojni.util.StringUtil;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

	private static final String TAG = MainActivity.class.getSimpleName();

	private TextView mTextView;
	private EditText mN1Edit;
	private EditText mN2Edit;
	private TextView mCalcResultText;
	private EditText mCountEdit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		initViews();

		initValues();
	}

	private void initValues() {
		mTextView.setText(StringUtil.getString("some strings"));
	}

	private void initViews() {
		mTextView = (TextView) findViewById(R.id.text);
		mN1Edit = (EditText) findViewById(R.id.n1);
		mN2Edit = (EditText) findViewById(R.id.n2);
		findViewById(R.id.calc).setOnClickListener(this);
		mCalcResultText = (TextView) findViewById(R.id.calcResult);
		mCountEdit = (EditText) findViewById(R.id.count);
		findViewById(R.id.intArray).setOnClickListener(this);
		findViewById(R.id.field).setOnClickListener(this);
	}

	private void calc() {
		if (mN1Edit.getText().toString().length() == 0 || mN2Edit.getText().toString().length() == 0) {
			Toast.makeText(this, "请输入数字", Toast.LENGTH_SHORT).show();
			return;
		}

		int n1 = Integer.valueOf(mN1Edit.getText().toString());
		int n2 = Integer.valueOf(mN2Edit.getText().toString());

		NumberUtil util = new NumberUtil();
		mCalcResultText.setText(String.valueOf(util.add(n1, n2)));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.calc:
			calc();
			break;
		case R.id.intArray:
			intArray();
			break;
		case R.id.field:
			field();
			break;
		}
	}

	private void field() {
		StringUtil util = new StringUtil();
		util.init();
		Log.i(TAG, "length: " + util.getS() + " - " + util.getLength());
	}

	private void intArray() {
		if (mCountEdit.getText().toString().length() == 0) {
			Toast.makeText(this, "请输入数字", Toast.LENGTH_SHORT).show();
			return;
		}

		int count = Integer.valueOf(mCountEdit.getText().toString());
		NumberUtil util = new NumberUtil();
		int[] arr = util.getNumbers(count);
		for (int i : arr) {
			Log.i(TAG, String.valueOf(i));
		}
	}
}
