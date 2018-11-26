package com.blackspider.recyclerselectiondemo.ui.main.detailslookup;
/*
 *  ****************************************************************************
 *  * Created by : Arhan Ashik on 11/20/2018 at 1:59 PM.
 *  * Email : ashik.pstu.cse@gmail.com
 *  *
 *  * Last edited by : Arhan Ashik on 11/20/2018.
 *  *
 *  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
 *  ****************************************************************************
 */

import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.selection.ItemDetailsLookup;

public class ArtistDetails extends ItemDetailsLookup.ItemDetails<Long> {

    private long position;

    public void setPosition(long position) {
        this.position = position;
    }

    @Override
    public int getPosition() {
        return (int) position;
    }

    @Nullable
    @Override
    public Long getSelectionKey() {
        return position;
    }

    @Override
    public boolean inSelectionHotspot(@NonNull MotionEvent e) {
        return true;
    }
}
