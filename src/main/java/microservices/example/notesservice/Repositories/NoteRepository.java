package microservices.example.notesservice.Repositories;

import microservices.example.notesservice.Entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
