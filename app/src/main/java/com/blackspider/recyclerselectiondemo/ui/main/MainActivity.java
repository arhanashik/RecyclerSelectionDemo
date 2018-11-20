package com.blackspider.recyclerselectiondemo.ui.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.selection.StorageStrategy;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.blackspider.recyclerselectiondemo.R;
import com.blackspider.recyclerselectiondemo.data.article.ArticleEntity;
import com.blackspider.recyclerselectiondemo.databinding.ActivityMainBinding;
import com.blackspider.recyclerselectiondemo.ui.main.adapter.ArticleAdapter;
import com.blackspider.recyclerselectiondemo.ui.main.adapter.ArticleDetailsLookup;
import com.blackspider.recyclerselectiondemo.ui.main.selctionutil.SelectionKeyProvider;
import com.blackspider.recyclerselectiondemo.ui.main.selctionutil.SelectionPredicate;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ArticleEntity> articleEntities;
    private SelectionTracker<Long> selectionTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setSupportActionBar(binding.toolbar);

        articleEntities = ArticleEntity.getArticleEntities();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        ArticleAdapter articleAdapter = new ArticleAdapter(articleEntities);
        binding.recyclerView.setAdapter(articleAdapter);
        selectionTracker = new SelectionTracker.Builder<>("article_selection_tracker",
                binding.recyclerView,
                new SelectionKeyProvider(),
                new ArticleDetailsLookup(binding.recyclerView),
                StorageStrategy.createLongStorage())
                .withSelectionPredicate(new SelectionPredicate())
                .build();
        articleAdapter.setSelectionTracker(selectionTracker);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_selection) {
            Toast.makeText(this, selectionTracker.getSelection().toString(), Toast.LENGTH_LONG).show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
