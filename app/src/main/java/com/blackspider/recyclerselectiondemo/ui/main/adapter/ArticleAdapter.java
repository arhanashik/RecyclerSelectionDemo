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
import android.view.View;
import android.view.ViewGroup;

import com.blackspider.recyclerselectiondemo.data.article.ArticleEntity;
import com.blackspider.recyclerselectiondemo.databinding.ItemRecylerBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.MyViewHolder> {

    private final List<ArticleEntity> mArticleEntities;
    private SelectionTracker<Long> mSelectionTracker;

    public ArticleAdapter(List<ArticleEntity> articleEntities) {
        mArticleEntities = articleEntities;
    }

    public void setSelectionTracker(SelectionTracker<Long> selectionTracker) {
        mSelectionTracker = selectionTracker;

        mSelectionTracker.addObserver(new SelectionTracker.SelectionObserver() {
            @Override
            public void onItemStateChanged(@NonNull Object key, boolean selected) {
                super.onItemStateChanged(key, selected);

                if(mSelectionTracker.getSelection().size() == 0){
                    notifyDataSetChanged();
                }
            }
        });
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemRecylerBinding binding;
        private ArticleDetails articleDetails;

        MyViewHolder(@NonNull ItemRecylerBinding itemRecyclerBinding) {
            super(itemRecyclerBinding.getRoot());
            binding = itemRecyclerBinding;
            articleDetails = new ArticleDetails();
        }

        void bind(ArticleEntity articleEntity, int position) {
            articleDetails.setPosition(position);
            binding.setArticleEntity(articleEntity);
            binding.executePendingBindings();
            if (mSelectionTracker != null && mSelectionTracker.getSelection().size() > 0) {
                binding.checkBox.setVisibility(View.VISIBLE);

                if (mSelectionTracker.isSelected(articleDetails.getSelectionKey())) {
                    binding.checkBox.setChecked(true);
                    binding.getRoot().setActivated(true);
                } else {
                    binding.checkBox.setChecked(false);
                    binding.getRoot().setActivated(false);
                }
            }else {
                binding.checkBox.setVisibility(View.INVISIBLE);
            }
        }

        ArticleDetails getItemDetails() {
            return articleDetails;
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(
                ItemRecylerBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(mArticleEntities.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mArticleEntities.size();
    }
}
