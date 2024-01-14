package microservices.example.notesservice.Controllers;

import java.util.List;

import microservices.example.notesservice.DTOS.EtudiantDTO;
import microservices.example.notesservice.DTOS.MatiereDTO;
import microservices.example.notesservice.Entities.Note;
import microservices.example.notesservice.Repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    NoteRepository repository;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping
    public List<Note> getAllNotes() {
        List<Note> listeNotes = repository.findAll();
        for (Note note : listeNotes) {

            ResponseEntity<EtudiantDTO> response = restTemplate.getForEntity("http://localhost:8181/etudiants/" + note.getIdEtudiant(), EtudiantDTO.class);
            ResponseEntity<MatiereDTO> response2 = restTemplate.getForEntity("http://localhost:8282/matieres/" + note.getIdMatiere(), MatiereDTO.class);

            note.setEtudiantDTO(response.getBody());
            note.setMatiereDTO(response2.getBody());
        }
        return listeNotes;
    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable("id") Long x) {

        Note note = repository.findById(x).get();

        ResponseEntity<EtudiantDTO> response = restTemplate.getForEntity("http://localhost:8181/etudiants/" + note.getIdEtudiant(), EtudiantDTO.class);
        ResponseEntity<MatiereDTO> response2 = restTemplate.getForEntity("http://localhost:8282/matieres/" + note.getIdMatiere(), MatiereDTO.class);

        note.setEtudiantDTO(response.getBody());
        note.setMatiereDTO(response2.getBody());

        return note;
    }

    @PostMapping
    public Note saveNote(@RequestBody Note e) {
        return repository.save(e);
    }
}