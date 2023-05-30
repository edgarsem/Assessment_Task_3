package lt.viko.eif.esemasko.Assessment_Task_3;

import lt.viko.eif.esemasko.Assessment_Task_3.myschema.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for accessing Movie data.
 * It extends Spring Data JPA's JpaRepository, specifying the domain type as Movie and the ID type as Long.
 */
interface MovieRepository extends JpaRepository<Movie, Long> {

}
