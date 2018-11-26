package com.blackspider.recyclerselectiondemo.ui.main.viewholder;
/*
 *  ****************************************************************************
 *  * Created by : Arhan Ashik on 11/26/2018 at 10:56 AM.
 *  * Email : ashik.pstu.cse@gmail.com
 *  *
 *  * Last edited by : Arhan Ashik on 11/26/2018.
 *  *
 *  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
 *  ****************************************************************************
 */

import android.view.View;

import com.blackspider.recyclerselectiondemo.R;
import com.blackspider.recyclerselectiondemo.data.artist.ArtistEntity;
import com.blackspider.recyclerselectiondemo.databinding.ItemRecylerBinding;
import com.blackspider.recyclerselectiondemo.ui.main.detailslookup.ArtistDetails;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import androidx.annotation.NonNull;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.widget.RecyclerView;

public class ArtistViewHolder extends RecyclerView.ViewHolder {
    private ItemRecylerBinding binding;
    private ArtistDetails artistDetails;
    private SelectionTracker<Long> mSelectionTracker;

    public ArtistViewHolder(@NonNull ItemRecylerBinding itemRecyclerBinding,
                            SelectionTracker<Long> selectionTracker) {
        super(itemRecyclerBinding.getRoot());
        binding = itemRecyclerBinding;
        artistDetails = new ArtistDetails();
        mSelectionTracker = selectionTracker;
    }

    public void bind(ArtistEntity artistEntity, int position) {
        artistDetails.setPosition(position);

        binding.setArtistEntity(artistEntity);
        Glide.with(binding.getRoot().getContext())
                .load(artistEntity.getArtistImg())
                .apply(new RequestOptions().error(R.drawable.ic_avater))
                .into(binding.imgUser);

        binding.executePendingBindings();
        if (mSelectionTracker != null && mSelectionTracker.getSelection().size() > 0) {
            binding.checkBox.setVisibility(View.VISIBLE);

            if (mSelectionTracker.isSelected(artistDetails.getSelectionKey())) {
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

    public ArtistDetails getItemDetails() {
        return artistDetails;
    }
}
