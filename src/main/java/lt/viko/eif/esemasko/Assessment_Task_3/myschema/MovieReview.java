//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.04.28 at 07:39:20 PM EEST 
//


package lt.viko.eif.esemasko.Assessment_Task_3.myschema;


import jakarta.persistence.*;

import java.util.Objects;

/**
 * <p>Java class for movieReview complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="movieReview"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *         &lt;element name="criticism" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="rating" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *         &lt;element name="user" type="{http://spring.io/guides/gs-producing-web-service}user"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@Entity
public class MovieReview {

    private @Id
    @GeneratedValue Long id;

    protected String criticism;
    protected int rating;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "moviereview_user",
            joinColumns = @JoinColumn(name = "moviereview_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    protected User user;

    /**
     * Gets the value of the id property.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the criticism property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCriticism() {
        return criticism;
    }

    /**
     * Sets the value of the criticism property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCriticism(String value) {
        this.criticism = value;
    }

    /**
     * Gets the value of the rating property.
     */
    public int getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     */
    public void setRating(int value) {
        this.rating = value;
    }

    /**
     * Gets the value of the user property.
     *
     * @return possible object is
     * {@link User }
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     *
     * @param value allowed object is
     *              {@link User }
     */
    public void setUser(User value) {
        this.user = value;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * The equals method implements an equivalence relation on non-null object references.
     *
     * @param o the reference object with which to compare
     * @return true if this object is the same as the object argument; false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieReview that = (MovieReview) o;
        return rating == that.rating && Objects.equals(id, that.id) && Objects.equals(criticism, that.criticism) && Objects.equals(user, that.user);
    }

    /**
     * Returns a hash code value for the object.
     * This method is supported for the benefit of hash tables such as those provided by java.util.HashMap.
     *
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, criticism, rating, user);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return "MovieReview{" +
                "id=" + id +
                ", criticism='" + criticism + '\'' +
                ", rating=" + rating +
                ", user=" + user +
                '}';
    }
}
