package com.amr.gharseldin.viewholderpattern;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private ListView listView;
    private TextView listItemText;
    private ImageView listItemImage;
    private ArrayList<Integer> imageArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.list);
        imageArray = new ArrayList<>();
        imageArray.add(R.drawable.pic1);
        imageArray.add(R.drawable.pic2);
        imageArray.add(R.drawable.pic3);
        imageArray.add(R.drawable.pic4);
        imageArray.add(R.drawable.pic5);
        imageArray.add(R.drawable.pic6);

        listView.setAdapter(new HolderPatternAdapter());
    }

    private class HolderPatternAdapter extends BaseAdapter{

        private class ViewHolder{
            TextView title;
            ImageView image;

            ViewHolder(View view){
                this.title = (TextView)view.findViewById(R.id.list_item_text);
                this.image = (ImageView)view.findViewById(R.id.list_item_image);
            }
        }

        @Override
        public int getCount() {
            return 20;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View row = convertView;

            if(row==null){
                row = getLayoutInflater().inflate(R.layout.list_item, parent, false);
                ViewHolder holder = new ViewHolder(row);
                row.setTag(holder);
            }

            ViewHolder holder = (ViewHolder)row.getTag();

            holder.title .setText(Html.fromHtml("<B>This</B> is cell no " + position));
            holder.image.setImageResource(imageArray.get(position%6));

            return row;
        }
    }
}
