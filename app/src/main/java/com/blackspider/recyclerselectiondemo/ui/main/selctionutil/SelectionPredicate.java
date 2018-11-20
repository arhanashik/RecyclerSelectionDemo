package com.blackspider.recyclerselectiondemo.ui.main.selctionutil;
/*
 *  ****************************************************************************
 *  * Created by : Arhan Ashik on 11/20/2018 at 1:54 PM.
 *  * Email : ashik.pstu.cse@gmail.com
 *  *
 *  * Last edited by : Arhan Ashik on 11/20/2018.
 *  *
 *  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
 *  ****************************************************************************
 */

import androidx.annotation.NonNull;
import androidx.recyclerview.selection.SelectionTracker;

public class SelectionPredicate extends SelectionTracker.SelectionPredicate<Long> {

    @Override
    public boolean canSetStateForKey(@NonNull Long key, boolean nextState) {
        return true;
    }

    @Override
    public boolean canSetStateAtPosition(int position, boolean nextState) {
        return true;
    }

    @Override
    public boolean canSelectMultiple() {
        return true;
    }
}
