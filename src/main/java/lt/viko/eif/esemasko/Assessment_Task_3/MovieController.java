package lt.viko.eif.esemasko.Assessment_Task_3;

import java.util.Iterator;
import java.util.List;

import lt.viko.eif.esemasko.Assessment_Task_3.myschema.Actor;
import lt.viko.eif.esemasko.Assessment_Task_3.myschema.Movie;
import lt.viko.eif.esemasko.Assessment_Task_3.myschema.MovieReview;
import lt.viko.eif.esemasko.Assessment_Task_3.utils.ReviewUpdateDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;


/**
 * Controller class that handles all movie-related requests.
 */
@RestController
public class MovieController {
    /**
     * Repository for accessing the Movie database.
     */
    private final MovieRepository repository;

    /**
     * Constructor for creating a new MovieController.
     *
     * @param repository the MovieRepository
     */
    public MovieController(MovieRepository repository) {
        this.repository = repository;
    }

    /**
     * Get all movies.
     *
     * @return a list of all movies
     */
    @GetMapping("/movies")
    List<Movie> all() {
        return repository.findAll();
    }

    /**
     * Create a new movie.
     *
     * @return a new movie
     */
    @PostMapping("/movies")
    Movie newMovie(@RequestBody Movie newMovie) {
        return repository.save(newMovie);
    }

    /**
     * Gets a movie specified by movie id.
     *
     * @param id of the movie to find
     * @return the specified movie
     */
    @GetMapping("/movies/{id}")
    Movie one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    /**
     * Replaces a movie data specified by movie id.
     *
     * @param newMovie the new data of a movie
     * @param id of the movie to find
     * @return the movie with new data
     */
    @PutMapping("/movies/{id}")
    Movie replaceMovie(@RequestBody Movie newMovie, @PathVariable Long id) {

        return repository.findById(id)
                .map(movie -> {
                    movie.setTitle(newMovie.getTitle());
                    movie.setLength(newMovie.getLength());
                    movie.getDirectors().equals(newMovie.getDirectors());
                    movie.getCast().equals(newMovie.getCast());
                    movie.getClass().equals(newMovie.getDirectors());
                    movie.getGenres().equals(newMovie.getGenres());
                    movie.getReviews().equals(newMovie.getReviews());
                    return repository.save(movie);
                })
                .orElseGet(() -> {
                    newMovie.setId(id);
                    return repository.save(newMovie);
                });
    }

    /**
     * Deletes a movie specified by movie id.
     *
     * @param id of the movie to be deleted
     */
    @DeleteMapping("/movies/{id}")
    void deleteMovie(@PathVariable Long id) {
        repository.deleteById(id);
    }

    /**
     * Adds a new actor to the cast of a movie specified by movie id.
     *
     * @param newActor to be added to the cast of movie
     * @param id of the movie to be deleted
     * @return the updated movie data
     */
    @PostMapping("/movies/{id}")
    Movie newActorForMovie(@RequestBody Actor newActor, @PathVariable Long id) {

        return repository.findById(id)
                .map(movie -> {
                    movie.getCast().add(newActor);
                    return repository.save(movie);
                }).orElseThrow(() -> new MovieNotFoundException(id));
    }

    /**
     * Deletes a new actor from the cast of a movie specified by movie id and actors id.
     *
     * @param movieId of a movie from which actor is going to be deleted
     * @param actorId of an actor to be deleted from movie cast
     */
    @DeleteMapping("/movies/{movieId}/actors/{actorId}")
    void deleteActorFromMovie(@PathVariable Long movieId, @PathVariable Long actorId) {
        repository.findById(movieId)
                .map(movie -> {
                    Iterator<Actor> iterator = movie.getCast().iterator();
                    while(iterator.hasNext()) {
                        Actor actor = iterator.next();
                        if(actor.getId().equals(actorId)) {
                            iterator.remove();
                        }
                    }
                    repository.save(movie);
                    return movie;
                }).orElseThrow(() -> new MovieNotFoundException(movieId));
    }

    /**
     * Adds a new movie review specified by movie id.
     *
     * @param newReview to be added to the movie
     * @param id of the movie to which review is going to be added
     * @return the updated movie data
     */
    @PostMapping("/movies/{id}/review")
    Movie newMovieReview(@RequestBody MovieReview newReview, @PathVariable Long id) {
        return repository.findById(id)
                .map(movie -> {
                    movie.getReviews().add(newReview);
                    return repository.save(movie);
                }).orElseThrow(() -> new MovieNotFoundException(id));
    }

    /**
     * Changes data of a movie review specified by movie id and review id.
     *
     * @param newReview data to be added to the movie review
     * @param movieId of the movie to which review is going to be changed
     * @param reviewId of the review which is going to be changed
     */
    @PutMapping("/movies/{movieId}/reviews/{reviewId}")
    void changeMovieReviewCriticism(@RequestBody ReviewUpdateDTO newReview, @PathVariable Long movieId, @PathVariable Long reviewId) {

        repository.findById(movieId)
                .map(movie -> {
                    Iterator<MovieReview> iterator = movie.getReviews().iterator();
                    while(iterator.hasNext()) {
                        MovieReview movieReview = iterator.next();
                        if(movieReview.getId().equals(reviewId)) {
                            movieReview.setCriticism(newReview.newCriticism());
                            movieReview.setRating(newReview.newRating());
                        }
                    }
                    repository.save(movie);
                    return movie;
                }).orElseThrow(() -> new MovieNotFoundException(movieId));
    }

    /**
     * Deletes a review from movie specified by movie id and review id.
     *
     * @param movieId of movie from which review is going to be deleted
     * @param reviewId of a review to be deleted
     */
    @DeleteMapping("/movies/{movieId}/reviews/{reviewId}")
    void deleteReviewFromMovie(@PathVariable Long movieId, @PathVariable Long reviewId) {
        repository.findById(movieId)
                .map(movie -> {
                    Iterator<MovieReview> iterator = movie.getReviews().iterator();
                    while(iterator.hasNext()) {
                        MovieReview review = iterator.next();
                        if(review.getId().equals(reviewId)) {
                            iterator.remove();
                        }
                    }
                    repository.save(movie);
                    return movie;
                }).orElseThrow(() -> new MovieNotFoundException(movieId));
    }

    /**
     * Changes a title of a movie specified by movie id.
     *
     * @param newTitle to be added to the movie
     * @param id of the movie of which title is going to be changed
     * @return the updated movie data
     */
    @PostMapping("/movies/title/{id}")
    Movie changeMovieTitle(@RequestBody String newTitle, @PathVariable Long id) {
        return repository.findById(id)
                .map(movie -> {
                    movie.setTitle(newTitle);
                    return repository.save(movie);
                }).orElseThrow(() -> new MovieNotFoundException(id));
    }

    /**
     * Get an average rating from all movie reviews specified by movie id.
     *
     * @param id of the movie of which average rating is going to be returned
     * @return the average rating of a movie
     */
    @GetMapping("/movies/{id}/reviews")
    String getMovieAverageRating(@PathVariable Long id) {
        DecimalFormat df = new DecimalFormat("0.00");
        return repository.findById(id)
                .map(movie -> {
                    double rating = 0;
                    for(MovieReview review : movie.getReviews())
                        rating += review.getRating();
                    return movie.getTitle() + " average rating is " + df.format(rating / movie.getReviews().size());
                }).orElseThrow(() -> new MovieNotFoundException(id));
    }
}
