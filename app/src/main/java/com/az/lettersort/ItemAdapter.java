package com.az.lettersort;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.az.lettersort.azList.AZBaseAdapter;
import com.az.lettersort.azList.BaseSortBean;

import java.util.List;


public class ItemAdapter extends AZBaseAdapter<String, ItemAdapter.ItemHolder> {

	public ItemAdapter(List<BaseSortBean> dataList) {
		super(dataList);
	}

	@Override
	public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new ItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adapter, parent, false));
	}

	@Override
	public void onBindViewHolder(ItemHolder holder, int position) {
		holder.mTextName.setText(mDataList.get(position).getName());
	}

	static class ItemHolder extends RecyclerView.ViewHolder {

		TextView mTextName;

		ItemHolder(View itemView) {
			super(itemView);
			mTextName = itemView.findViewById(R.id.text_item_name);
		}
	}
}
