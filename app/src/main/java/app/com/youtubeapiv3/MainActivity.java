package app.com.youtubeapiv3;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout = null;
    private ViewPager viewPager = null;

    public String GOOGLE_YOUTUBE_API_KEY = "AIzaSyDDNXQW5vUsBy91h_swoSAc_uFFAG14Clo";  //here you should use your api key for testing purpose you can use this api also
    public String CHANNEL_ID = "UCoMdktPbSTixAyNGwb-UYkQ";  //here you should use your channel id for testing purpose you can use this api also
    public String CHANNLE_GET_URL = "https://www.googleapis.com/youtube/v3/search?part=snippet&type=video&channelId=" + CHANNEL_ID + "&eventType=live&maxResults=20&key=" + GOOGLE_YOUTUBE_API_KEY + "";
    public String PLAYLIST_ID = "PLFgquLnL59al_vjBToIrYqC2l-CiO78U6";//here you should use your playlist id for testing purpose you can use this api also
    public String PLAYLIST_GET_URL = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=" + PLAYLIST_ID + "&maxResults=20&key=" + GOOGLE_YOUTUBE_API_KEY + "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        //setting the tabs title
        tabLayout.addTab(tabLayout.newTab().setText("Channel"));
        tabLayout.addTab(tabLayout.newTab().setText("PlayList"));
        tabLayout.addTab(tabLayout.newTab().setText("Live"));
        tabLayout.addTab(tabLayout.newTab().setText("Category"));

        //setup the view pager
        final PagerAdapter adapter = new app.com.youtubeapiv3.adapters.PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




    }
}
