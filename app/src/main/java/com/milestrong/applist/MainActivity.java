package com.milestrong.applist;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Application> apps = new ArrayList<Application>();

        final PackageManager pm = getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> resolveInfos = pm.queryIntentActivities(intent, 0);

        for(ResolveInfo resolveInfo : resolveInfos) {
            String name = resolveInfo.activityInfo.loadLabel(pm).toString();
            Drawable icon = resolveInfo.activityInfo.loadIcon(pm);
            Application app = new Application(name, icon);
            apps.add(app);
        }

        adapter = new ListAdapter(this, apps);
        list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);
    }
}
