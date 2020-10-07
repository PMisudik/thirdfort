package sk.misudik.thirdfort.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.misudik.thirdfort.entities.Note;

@Repository
public interface NotesRepository extends JpaRepository<Note, Long> {
}
