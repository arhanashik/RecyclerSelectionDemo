package com.blackspider.recyclerselectiondemo.data.artist;
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

import java.util.ArrayList;
import java.util.List;

public class ArtistEntity {

    private int id;
    private String artistName;
    private String artistImg;
    private String artistQuotes;
    private String artistBirthday;

    public ArtistEntity(){

    }

    public ArtistEntity(int id, String artistName, String artistImg, String artistQuotes, String artistBirthday) {
        this.id = id;
        this.artistName = artistName;
        this.artistImg = artistImg;
        this.artistQuotes = artistQuotes;
        this.artistBirthday = artistBirthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistImg() {
        return artistImg;
    }

    public void setArtistImg(String artistImg) {
        this.artistImg = artistImg;
    }

    public String getArtistQuotes() {
        return artistQuotes;
    }

    public void setArtistQuotes(String artistQuotes) {
        this.artistQuotes = artistQuotes;
    }

    public String getArtistBirthday() {
        return artistBirthday;
    }

    public void setArtistBirthday(String artistBirthday) {
        this.artistBirthday = artistBirthday;
    }

    public static List<ArtistEntity> getArticleEntities() {
        List<ArtistEntity> list = new ArrayList<>();
        list.add(new ArtistEntity(1,
                "Johnny Depp",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSchhAFjjQSPAKiwf8weGt_QqzMe7YYaX5BG04-QpqohyZeqyoJ",
                "1. This is the day you will always remember as the day you almost caught " +
                        "Captain Jack Sparrow.\n\n" +
                        "2. I'm dishonest, and a dishonest man you can always trust to be " +
                        "dishonest.\n\n3. Wherever we want to go, we'll go.",
                "Birthday: June 9, 1963"));
        list.add(new ArtistEntity(2,
                "Tom hanks",
                "http://www.gstatic.com/tv/thumb/persons/62982/62982_v9_bb.jpg",
                "1. If it wasn't hard, everyone would do it. It's the hard that makes it " +
                        "great.\n\n2. From now on we live in a world where man has walked on the " +
                        "Moon. It's not a miracle; we just decided to go.\n\n3. Everybody has " +
                        "something that chews them up and, for me, that thing was always " +
                        "loneliness. The cinema has the power to make you not feel lonely, " +
                        "even when you are.",
                "Birthday: July 9, 1956"));
        list.add(new ArtistEntity(3,
                "Arnold Schwarzenegger",
                "http://www.gstatic.com/tv/thumb/v22vodart/7764/p7764_v_v8_ab.jpg",
                "1. Strength does not come from winning. Your struggles develop your " +
                        "strengths. When you go through hardships and decide not to surrender, " +
                        "that is strength.\n\n" +
                        "2. If it bleeds, we can kill it.\n\n" +
                        "3. The worst thing I can be is the same as everybody else. I hate that.",
                "Birthday: July 30, 1947"));
        list.add(new ArtistEntity(4,
                "Tom Cruise",
                "https://media.brstatic.com/2017/06/23134715/tom-cruise-networth-414x552.jpg",
                "1. Nothing ends nicely, that's why it ends. \n\n2. I disagree with people " +
                        "who think you learn more from getting beat up than you do from winning." +
                        "\n\n3. I always look for a challenge and something that's different.",
                "Birthday: July 3, 1962"));
        list.add(new ArtistEntity(5,
                "Harry Potter(Harry James Potter)",
                "https://m.media-amazon.com/images/M/MV5BMjIyZGU4YzUtNDkzYi00ZDRhLTljYzctYTMxMDQ4M2E0Y2YxXkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_.jpg",
                "1. It does not do to dwell on dreams and forget to live" +
                        "\n\n2. It takes a great deal of bravery to stand up to our enemies, " +
                        "but just as much to stand up to our friends\n\n3. It is our choices, " +
                        "Harry, that show what we truly are, far more than our abilities",
                "Birthday: July 31, 1980"));
        list.add(new ArtistEntity(6,
                "Rapunzel",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQtoablWo6Yff-dUs5rQv0F3owjQcpMeOMmt_l-eyWFc-KOvMDg",
                "1. The world is dark, and selfish, and cruel.\n\n2.  Did I ever tell you " +
                        "I have a thing for brunettes?\n\n3. Go, live your dream.",
                "Originally published: 1812. Author: Brothers Grimm"));

        return list;
    }
}
