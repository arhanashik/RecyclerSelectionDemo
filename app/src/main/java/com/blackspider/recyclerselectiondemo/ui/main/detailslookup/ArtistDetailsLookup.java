package com.blackspider.recyclerselectiondemo.ui.main.detailslookup;
/*
 *  ****************************************************************************
 *  * Created by : Arhan Ashik on 11/20/2018 at 1:33 PM.
 *  * Email : ashik.pstu.cse@gmail.com
 *  *
 *  * Last edited by : Arhan Ashik on 11/20/2018.
 *  *
 *  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
 *  ****************************************************************************
 */

import android.view.MotionEvent;
import android.view.View;

import com.blackspider.recyclerselectiondemo.ui.main.viewholder.ArtistViewHolder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.widget.RecyclerView;

public class ArtistDetailsLookup extends ItemDetailsLookup<Long> {

    private RecyclerView recyclerView;

    public ArtistDetailsLookup(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    @Nullable
    @Override
    public ItemDetails<Long> getItemDetails(@NonNull MotionEvent e) {
        View view = recyclerView.findChildViewUnder(e.getX(), e.getY());
        if (view != null) {
            RecyclerView.ViewHolder viewHolder = recyclerView.getChildViewHolder(view);
            if (viewHolder instanceof ArtistViewHolder) {
                return ((ArtistViewHolder) viewHolder).getItemDetails();
            }
        }
        return null;
    }
}
