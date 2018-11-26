package com.blackspider.recyclerselectiondemo.ui.main;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.blackspider.recyclerselectiondemo.R;
import com.blackspider.recyclerselectiondemo.data.artist.ArtistEntity;
import com.blackspider.recyclerselectiondemo.databinding.ActivityMainBinding;
import com.blackspider.recyclerselectiondemo.ui.main.adapter.ArtistAdapter;
import com.blackspider.recyclerselectiondemo.ui.main.detailslookup.ArtistDetailsLookup;
import com.blackspider.recyclerselectiondemo.ui.main.selctionutil.SelectionKeyProvider;
import com.blackspider.recyclerselectiondemo.ui.main.selctionutil.SelectionPredicate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.selection.StorageStrategy;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

public class MainActivity extends AppCompatActivity implements ArtistAdapter.ArticleSelectEvent {

    private ArtistAdapter artistAdapter;
    private SelectionTracker<Long> selectionTracker;

    private Drawable selectedDrawable, deselectedDrawable;
    private ActionMode actionMode;
    private ActionMode.Callback actionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.action_menu_main, menu);
            actionMode = mode;
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            if(selectedDrawable == null) selectedDrawable = getResources().getDrawable(R.drawable.ic_selected);
            if(deselectedDrawable == null) deselectedDrawable = getResources().getDrawable(R.drawable.ic_deselected);

            menu.getItem(0).setIcon(deselectedDrawable);

            return true;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            if(item.getItemId() == R.id.action_toggle_selection){
                if(item.getIcon() == deselectedDrawable){
                    for(int i = 0; i < artistAdapter.getItemCount(); i++){
                        selectionTracker.select((long) i);
                    }
                }else {
                    actionMode.finish();
                }
            }

            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            selectionTracker.clearSelection();
            actionMode = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        artistAdapter = new ArtistAdapter();
        binding.recyclerView.setAdapter(artistAdapter);
        selectionTracker = new SelectionTracker.Builder<>("article_selection_tracker",
                binding.recyclerView,
                new SelectionKeyProvider(),
                new ArtistDetailsLookup(binding.recyclerView),
                StorageStrategy.createLongStorage())
                .withSelectionPredicate(new SelectionPredicate())
                .build();
        artistAdapter.setSelectionTracker(selectionTracker);
        artistAdapter.setListener(this);

        loadData();
    }

    private void loadData(){
        artistAdapter.setArtistEntities(ArtistEntity.getArticleEntities());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_select_all) {
            for(int i = 0; i < artistAdapter.getItemCount(); i++){
                selectionTracker.select((long) i);
            }

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSelectArticle(ArtistEntity artistEntity, int totalSelected) {
        if (totalSelected > 0) {
            if(actionMode == null) actionMode = startSupportActionMode(actionModeCallback);

            actionMode.setTitle(String.valueOf(totalSelected));

            MenuItem item = actionMode.getMenu().getItem(0);
            if(totalSelected == artistAdapter.getItemCount()) item.setIcon(selectedDrawable);
            else item.setIcon(deselectedDrawable);

        }else {
            if(actionMode != null) actionMode.finish();
        }
    }
}
