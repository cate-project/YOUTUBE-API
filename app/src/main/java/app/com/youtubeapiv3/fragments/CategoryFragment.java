package app.com.youtubeapiv3.fragments;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import app.com.youtubeapiv3.DetailsActivity;
import app.com.youtubeapiv3.MainActivity;
import app.com.youtubeapiv3.R;
import app.com.youtubeapiv3.adapters.CategoryAdapter;
import app.com.youtubeapiv3.models.CategoryModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends ListFragment {

    private CategoryAdapter adapter = null;
    private MainActivity mainActivity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Adapter 생성 및 Adapter 지정.
        adapter = new CategoryAdapter();
        mainActivity = (MainActivity)getActivity();
        setListAdapter(adapter) ;

        // 첫 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.share),
                "액션 롤플레잉 게임", "액션 롤플레잉 게임", "PLHRoF1XPhCHXQhWkViQveuVa-k6P8_aD2") ;
        // 두 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.share),
                "음악" , "음악", "PLFgquLnL59al_vjBToIrYqC2l-CiO78U6") ;
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.share),
                "스포츠", "스포츠", "UCUnSTiCHiHgZA9NQUG6lZkQ") ;

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //아이템 클릭 이벤트
    @Override
    public void onListItemClick (ListView l, View v, int position, long id) {
        // get TextView's Text.
        CategoryModel item = (CategoryModel) l.getItemAtPosition(position) ;
        mainActivity.PLAYLIST_ID = item.getChannelId();
        mainActivity.PLAYLIST_GET_URL = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=" + mainActivity.PLAYLIST_ID + "&maxResults=20&key=" + mainActivity.GOOGLE_YOUTUBE_API_KEY + "";
        String titleStr = item.getTitle() ;
        String descStr = item.getDesc() ;
        Drawable iconDrawable = item.getIcon() ;
        String channelStr = item.getChannelId() ;
        // TODO : use item data.
    }

    public void addItem(Drawable icon, String title, String desc, String channel) {
        adapter.addItem(icon, title, desc, channel) ;
    }

}