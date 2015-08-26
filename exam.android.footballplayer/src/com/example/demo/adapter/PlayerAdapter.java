/**
 * 
 */
package com.example.demo.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demo.customelistview.R;
import com.example.demo.entity.Player;

/**
 * @author VTMinh
 * 
 */
public class PlayerAdapter extends ArrayAdapter<Player> {

	Context mContext;
	ArrayList<Player> mLstPlayer = new ArrayList<Player>();

	public PlayerAdapter(Context context, int resource,
			ArrayList<Player> objects) {
		super(context, resource, objects);

		this.mContext = context;
		this.mLstPlayer = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View rowView = convertView;
		ViewHolder viewHolder = null;
		if (rowView == null) {
			LayoutInflater inflate = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rowView = inflate.inflate(R.layout.item_player, null);

			viewHolder = new ViewHolder();
			viewHolder.txtName = (TextView) rowView.findViewById(R.id.txtName);
			viewHolder.txtBirthday = (TextView) rowView
					.findViewById(R.id.txtBirthday);
			viewHolder.imgAva = (ImageView) rowView.findViewById(R.id.imgAva);
			viewHolder.imgFlag = (ImageView) rowView
					.findViewById(R.id.img_flag);

			rowView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		Player player = mLstPlayer.get(position);
		viewHolder.txtName.setText(player.getName());
		viewHolder.txtBirthday.setText(player.getBirthday());
		viewHolder.imgAva.setImageResource(player.getAvatar());
		viewHolder.imgFlag.setImageResource(player.getFlag());

		return rowView;
	}

	static class ViewHolder {
		TextView txtName;
		TextView txtBirthday;
		ImageView imgAva;
		ImageView imgFlag;
	}
}
