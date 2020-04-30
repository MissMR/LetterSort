package com.az.lettersort.azList;


import android.support.v7.widget.RecyclerView;

import java.util.List;

public abstract class AZBaseAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected List<BaseSortBean> mDataList;

    public AZBaseAdapter(List<BaseSortBean> dataList) {
        mDataList = dataList;
    }

    public List<BaseSortBean> getDataList() {
        return mDataList;
    }

    public void setDataList(List<BaseSortBean> dataList) {
        mDataList = dataList;
        notifyDataSetChanged();
    }

    public String getSortLetters(int position) {
        if (mDataList == null || mDataList.isEmpty()) {
            return null;
        }
        return mDataList.get(position).getInitials();
    }

    public int getSortLettersFirstPosition(String letters) {
        if (mDataList == null || mDataList.isEmpty()) {
            return -1;
        }
        int position = -1;
        for (int index = 0; index < mDataList.size(); index++) {
            if (mDataList.get(index).getInitials().equals(letters)) {
                position = index;
                break;
            }
        }
        return position;
    }

    public int getNextSortLetterPosition(int position) {
        if (mDataList == null || mDataList.isEmpty() || mDataList.size() <= position + 1) {
            return -1;
        }
        int resultPosition = -1;
        for (int index = position + 1; index < mDataList.size(); index++) {
            if (!mDataList.get(position).getInitials().equals(mDataList.get(index).getInitials())) {
                resultPosition = index;
                break;
            }
        }
        return resultPosition;
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }
}
