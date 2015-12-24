package com.example.bulbulhossen.dse_project.Grid_view;

import android.graphics.Bitmap;

/**
 * Created by bulbulkhan on 10/25/2015.
 */
public class Gridview_ImageItem {
    private Bitmap image;
    private String title;

    public Gridview_ImageItem(Bitmap image, String title) {
        super();
        this.image = image;
        this.title = title;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
