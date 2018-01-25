package jp.gr.conf_java.oleeapps.test03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // datas for the list
        String contents[] = {"おはよう", "こんにちは", "こんばんは", "寝る", "体調不良"};
        String timestamps[] = {"2018/01/26 00:58", "2018/01/23 12:34", "2018/01/19 11:11", "2018/01/15 15:32", "2018/01/11 09:31"};

        // put array -> HashMap
        ArrayList<HashMap<String, String>> data = new ArrayList<>();
        for (int i = 0; i < contents.length; i++) {
            HashMap<String, String> item = new HashMap<>();
            item.put("content", contents[i]);
            item.put("timestamp", timestamps[i]);
            data.add(item);
        }

        // set SimpleAdapter
        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.list_item,
                new String[] {"content", "timestamp"},
                new int[] {R.id.content, R.id.timestamp});

        // create List from SimpleAdapter
        ListView list = (ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
    }
}
