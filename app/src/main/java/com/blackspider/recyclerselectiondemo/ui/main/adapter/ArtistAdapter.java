package com.blackspider.recyclerselectiondemo.ui.main.adapter;
/*
 *  ****************************************************************************
 *  * Created by : Arhan Ashik on 11/19/2018 at 5:48 PM.
 *  * Email : ashik.pstu.cse@gmail.com
 *  *
 *  * Last edited by : Arhan Ashik on 11/19/2018.
 *  *
 *  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
 *  ****************************************************************************
 */

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.blackspider.recyclerselectiondemo.data.artist.ArtistEntity;
import com.blackspider.recyclerselectiondemo.databinding.ItemRecylerBinding;
import com.blackspider.recyclerselectiondemo.ui.main.viewholder.ArtistViewHolder;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.widget.RecyclerView;

public class ArtistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ArtistEntity> mArtistEntities;
    private SelectionTracker<Long> mSelectionTracker;
    private ArticleSelectEvent mListener;

    public ArtistAdapter() {
        mArtistEntities = new ArrayList<>();
    }

    public void setArtistEntities(List<ArtistEntity> artistEntities) {
        mArtistEntities = artistEntities;
        notifyDataSetChanged();
    }

    public void setSelectionTracker(SelectionTracker<Long> selectionTracker) {
        mSelectionTracker = selectionTracker;

        mSelectionTracker.addObserver(new SelectionTracker.SelectionObserver() {
            @Override
            public void onItemStateChanged(@NonNull Object key, boolean selected) {
                super.onItemStateChanged(key, selected);

                int totalSelected = mSelectionTracker.getSelection().size();

                mListener.onSelectArticle(mArtistEntities.get(Integer.valueOf(String.valueOf(key)))
                        , totalSelected);

                if(totalSelected == 0){
                    notifyDataSetChanged();
                }
            }
        });
    }

    public void setListener(ArticleSelectEvent listener) {
        this.mListener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecylerBinding binding = ItemRecylerBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new ArtistViewHolder(binding, mSelectionTracker);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ArtistViewHolder) holder).bind(mArtistEntities.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mArtistEntities.size();
    }

    public interface ArticleSelectEvent {
        void onSelectArticle(ArtistEntity artistEntity, int totalSelected);
    }
}
