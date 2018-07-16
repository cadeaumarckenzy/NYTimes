package e.elkulep10.nytimessearch;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

public class ArticleArrayAdapter extends ArrayAdapter <Article> {

    public ArticleArrayAdapter (Context context, List<Article> articles){
        super(context, android.R.layout.simple_list_item_1, articles);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);


    }
}
