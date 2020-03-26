package com.example.searchviewws;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.searchviewws.adapters.CountryListAdapter;
import com.example.searchviewws.entities.Countries;
import com.example.searchviewws.services.APIClient;
import com.example.searchviewws.services.CountryService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView listViewCountries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewCountries= findViewById(R.id.listViewCountries);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_view_menu, menu);
        final SearchView searchView= (SearchView) menu.findItem(R.id.searchView).getActionView();
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                CountryService countryService= APIClient.getClient().create(CountryService.class);
                Call call= countryService.search(s);
                call.enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) {
                        List<Countries> countries= (List<Countries>) response.body();
                        CountryListAdapter countryListAdapter= new CountryListAdapter(getApplicationContext(),countries);
                        listViewCountries.setAdapter(countryListAdapter);
                    }

                    @Override
                    public void onFailure(Call call, Throwable t) {
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }
}
