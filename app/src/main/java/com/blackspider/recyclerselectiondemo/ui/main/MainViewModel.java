package com.blackspider.recyclerselectiondemo.ui.main;
/*
 *  ****************************************************************************
 *  * Created by : Arhan Ashik on 11/19/2018 at 5:46 PM.
 *  * Email : ashik.pstu.cse@gmail.com
 *  *
 *  * Last edited by : Arhan Ashik on 11/19/2018.
 *  *
 *  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
 *  ****************************************************************************
 */

import com.blackspider.recyclerselectiondemo.R;
import com.blackspider.recyclerselectiondemo.data.artist.ArtistEntity;

import androidx.databinding.ObservableInt;

public class MainViewModel {

    private ArtistEntity artistEntity;

    public final ObservableInt textColor = new ObservableInt(R.color.colorPrimary);

    public MainViewModel(ArtistEntity artistEntity) {
        this.artistEntity = artistEntity;
    }
}
