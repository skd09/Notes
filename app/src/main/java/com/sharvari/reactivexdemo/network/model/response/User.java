package com.sharvari.reactivexdemo.network.model.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sharvari on 19-Jun-18.
 */

public class User extends BaseResponse{
    @SerializedName("api_key")
    String apiKey;

    public String getApiKey() {
        return apiKey;
    }
}
