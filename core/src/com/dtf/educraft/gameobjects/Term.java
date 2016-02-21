
package com.example;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Term {

    private Integer id;
    private String term;
    private String definition;
    private Object image;
    private Integer rank;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    /**
     * 
     * @return
     *     The term
     */
    public String getTerm() {
        return term;
    }

    /**
     * 
     * @param term
     *     The term
     */
    public void setTerm(String term) {
        this.term = term;
    }

    /**
     * 
     * @return
     *     The definition
     */
    public String getDefinition() {
        return definition;
    }

    /**
     * 
     * @param definition
     *     The definition
     */
    public void setDefinition(String definition) {
        this.definition = definition;
    }

    /**
     * 
     * @return
     *     The image
     */
    public Object getImage() {
        return image;
    }

    /**
     * 
     * @param image
     *     The image
     */
    public void setImage(Object image) {
        this.image = image;
    }

    /**
     * 
     * @return
     *     The rank
     */
    public Integer getRank() {
        return rank;
    }

    /**
     * 
     * @param rank
     *     The rank
     */
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
