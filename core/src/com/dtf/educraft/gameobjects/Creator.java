
package com.example;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Creator {

    private String username;
    private String accountType;
    private String profileImage;
    private Integer id;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @param username
     *     The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * @return
     *     The accountType
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * 
     * @param accountType
     *     The account_type
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * 
     * @return
     *     The profileImage
     */
    public String getProfileImage() {
        return profileImage;
    }

    /**
     * 
     * @param profileImage
     *     The profile_image
     */
    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
