package com.cloudbees.oauth;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 *
 * @author Vivek Pandey
 */
public class OauthToken {
    @JsonProperty("access_token")
    public String accessToken;

    @JsonProperty("token_type")
    public String tokenType;

    @JsonProperty("expires_in")
    public int expiresIn;

    @JsonProperty("client_id")
    public String clientId;

    @JsonProperty("uid")
    public String uid;

    @JsonProperty("email")
    public String email;

    @JsonProperty("accounts")
    public String[] accounts;

    @JsonProperty("scope")
    public String scope;

    @JsonIgnore
    public String[] getScopes(){
        if(scope == null){
            return new String[0];
        }

        return scope.split(" ");
    }

    public boolean isScopeApproved(String scope){
        if(scope == null){
            return false;
        }
        for(String s: getScopes()){
            if(s.trim().equals(scope)){
                return true;
            }
        }
        return false;
    }
}
