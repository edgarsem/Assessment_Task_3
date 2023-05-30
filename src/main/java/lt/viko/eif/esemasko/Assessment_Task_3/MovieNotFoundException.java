package lt.viko.eif.esemasko.Assessment_Task_3;

/**
 * Exception thrown when a movie is not found in the repository.
 */
class MovieNotFoundException extends RuntimeException {

	/**
	 * Constructs a MovieNotFoundException with an error message about the missing movie.
	 *
	 * @param id the ID of the movie that was not found
	 */
	MovieNotFoundException(Long id) {
		super("Could not find movie " + id);
	}
}
