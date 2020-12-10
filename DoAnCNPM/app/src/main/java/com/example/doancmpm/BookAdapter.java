package com.example.doancmpm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class BookAdapter extends BaseAdapter {

    private Context context;
    private List<Book> bookList;

    public BookAdapter(Context context, List<Book> bookList) {
        this.context = context;
        this.bookList = bookList;
    }
    public BookAdapter() {

    }
    @Override
    public int getCount() {
        return bookList.size();
    }

    @Override
    public Object getItem(int position) {
        return bookList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return bookList.get(position).get_id();
    }

    public class ViewHolder {
        TextView tenSach;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BookAdapter.ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_listsach, null);
            viewHolder = new BookAdapter.ViewHolder();

            viewHolder.tenSach = convertView.findViewById(R.id.tenSach);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (BookAdapter.ViewHolder) convertView.getTag();
        }
        Book sach = bookList.get(position);
        viewHolder.tenSach.setText(sach.get_tenSach());

        return convertView;
    }
}
