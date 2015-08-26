package com.example.demo.activity;

import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.example.demo.adapter.PlayerAdapter;
import com.example.demo.customelistview.R;
import com.example.demo.entity.Player;

public class MainActivity extends Activity {

	ArrayList<Player> mLstPlayer = new ArrayList<Player>();
	PlayerAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);
		
		doCreateFakeData();

		// Lấy Listview từ layout xuống
		ListView listLegend = (ListView) findViewById(R.id.lstFootballLegend);

		// Tạo Adapter
		adapter = new PlayerAdapter(MainActivity.this, R.layout.item_player,
				mLstPlayer);

		// Đổ dữ liệu lên ListView
		listLegend.setAdapter(adapter);
	}

	public void onClickAdd(View view) {
		Player p1 = new Player();
		p1.setName("Aguero");
		p1.setBirthday(Calendar.getInstance().getTime().toLocaleString());
		p1.setAvatar(R.drawable.ava_messi);
		p1.setFlag(R.drawable.ar);
		mLstPlayer.add(p1);

		adapter.notifyDataSetChanged();
	}

	public void onClickUpdate(View view) {
		Player p1 = mLstPlayer.get(0);
		String strDate = Calendar.getInstance().getTime().toLocaleString();
		p1.setBirthday(strDate);

		adapter.notifyDataSetChanged();
	}

	public void onClickDelete(View view) {
		mLstPlayer.remove(mLstPlayer.size() - 1);

		adapter.notifyDataSetChanged();
	}

	private void addNewItem() {

	}

	private void doCreateFakeData() {
		// Cầu thủ 1
		Player p1 = new Player();
		p1.setName("Leo Messi");
		p1.setBirthday("1985-05-20");
		p1.setAvatar(R.drawable.ava_messi);
		p1.setFlag(R.drawable.ar);

		// Cầu thủ 2
		Player p2 = new Player();
		p2.setName("C Ronaldo");
		p2.setBirthday("1986-10-20");
		p2.setAvatar(R.drawable.ava_ronaldo);
		p2.setFlag(R.drawable.pt);

		// Cầu thủ 3
		Player p3 = new Player();
		p3.setName("Thery Henry");
		p3.setBirthday("1982-09-15");
		p3.setAvatar(R.drawable.ava_henry);
		p3.setFlag(R.drawable.fr);

		mLstPlayer.add(p1);
		mLstPlayer.add(p2);
		mLstPlayer.add(p3);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
