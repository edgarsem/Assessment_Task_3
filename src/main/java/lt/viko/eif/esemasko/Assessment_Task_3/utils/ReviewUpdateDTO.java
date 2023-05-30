package lt.viko.eif.esemasko.Assessment_Task_3.utils;

/**
 * Data Transfer Object (DTO) class for updating movie reviews.
 */
public class ReviewUpdateDTO {

    /**
     * The new criticism for the review.
     */
    private String newCriticism;

    /**
     * The new rating for the review.
     */
    private int newRating;

    /**
     * Returns the new criticism for the review.
     *
     * @return the new criticism
     */
    public String newCriticism() {
        return newCriticism;
    }

    /**
     * The new criticism for the review.
     *
     * @param newCriticism allowed object is
     *              {@link String }
     */
    public void setNewCriticism(String newCriticism) {
        this.newCriticism = newCriticism;
    }

    /**
     * Returns the new rating for the review.
     *
     * @return the new rating
     */
    public int newRating() {
        return newRating;
    }

    /**
     * The new rating for the review.
     *
     * @param newRating allowed object is int
     *
     */
    public void setNewRating(int newRating) {
        this.newRating = newRating;
    }
}
