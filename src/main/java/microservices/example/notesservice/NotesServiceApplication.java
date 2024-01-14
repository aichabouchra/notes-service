package microservices.example.notesservice;

import microservices.example.notesservice.Entities.Note;
import microservices.example.notesservice.Repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class NotesServiceApplication implements CommandLineRunner{
	@Autowired
	NoteRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(NotesServiceApplication.class, args);
	}
	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Override
	public void run(String... args) throws Exception {
		Note note1 = Note.builder().note(17).idEtudiant(2L).idMatiere(1L).build();
		Note note2 = Note.builder().note(10).idEtudiant(1L).idMatiere(2L).build();

		repository.save(note1);
		repository.save(note2);
	}
}
