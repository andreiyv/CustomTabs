package tabs.custom;


import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class CustomTab extends TabActivity {

	private TabHost tabHost;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main); 
        tabHost = getTabHost();
        TabSpec spec; 
        Intent intent; 
        View view;
        tabHost.getTabWidget().setDividerDrawable(R.drawable.divider);
        view = createTabView(tabHost.getContext(), "Tab 1");
        intent = new Intent().setClass(this, SomeClass1.class);
        spec = tabHost.newTabSpec("tab1").setIndicator(view).setContent(intent);
        tabHost.addTab(spec);
        intent = new Intent().setClass(this, SomeClass2.class);
        view = createTabView(tabHost.getContext(), "Tab 2");
        spec = tabHost.newTabSpec("tab2").setIndicator(view).setContent(intent);
        tabHost.addTab(spec);
        intent = new Intent().setClass(this, SomeClass3.class);
        view = createTabView(tabHost.getContext(), "Tab 3");
        spec = tabHost.newTabSpec("tab3").setIndicator(view).setContent(intent);        
        tabHost.addTab(spec);
	}
	


	private static View createTabView(final Context context, final String text) {
		View view = LayoutInflater.from(context).inflate(R.layout.tab_bg, null);
		TextView tv = (TextView) view.findViewById(R.id.tabsText);
		tv.setText(text);
		return view;
	}

}
