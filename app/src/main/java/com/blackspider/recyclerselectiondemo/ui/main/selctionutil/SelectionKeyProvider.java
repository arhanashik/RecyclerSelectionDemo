package com.blackspider.recyclerselectiondemo.ui.main.selctionutil;
/*
 *  ****************************************************************************
 *  * Created by : Arhan Ashik on 11/20/2018 at 1:31 PM.
 *  * Email : ashik.pstu.cse@gmail.com
 *  *
 *  * Last edited by : Arhan Ashik on 11/20/2018.
 *  *
 *  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
 *  ****************************************************************************
 */

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.selection.ItemKeyProvider;

public class SelectionKeyProvider extends ItemKeyProvider<Long> {

    public SelectionKeyProvider() {
        super(ItemKeyProvider.SCOPE_MAPPED);
    }

    @Nullable
    @Override
    public Long getKey(int position) {
        return (long) position;
    }

    @Override
    public int getPosition(@NonNull Long key) {
        long value = key;
        return (int) value;
    }
}
