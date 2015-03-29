package com.studio.bakti.newpesanhotel.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bakti on 3/28/15.
 */
public class SearchResult extends BaseModel {


    @SerializedName("results")
    searchWrapper wrapper;

    public List<SearchItem> getItems(){
        return wrapper.getResult();
    }
    private class searchWrapper implements Serializable{
        @SerializedName("result")
        List<SearchItem> result;

        public List<SearchItem> getResult() {
            return result;
        }

        public void setResult(List<SearchItem> result) {
            this.result = result;
        }
    }

    public class SearchItem implements Serializable{
        @SerializedName("id")
        private String id;
        @SerializedName("name")
        private String name;
        @SerializedName("price")
        private String price;
        @SerializedName("photo_primary")
        private String photoPrimary;

        @SerializedName("address")
        private String address;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getPhotoPrimary() {
            return photoPrimary;
        }

        public void setPhotoPrimary(String photoPrimary) {
            this.photoPrimary = photoPrimary;
        }
    }
}
