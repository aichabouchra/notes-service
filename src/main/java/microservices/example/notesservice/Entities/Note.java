package microservices.example.notesservice.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import microservices.example.notesservice.DTOS.EtudiantDTO;
import microservices.example.notesservice.DTOS.MatiereDTO;

@NoArgsConstructor
@ToString
@AllArgsConstructor
@Data
@Builder
@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int note;
    private Long idEtudiant;
    private Long idMatiere;
    @Transient
    private EtudiantDTO etudiantDTO;
    @Transient
    private MatiereDTO matiereDTO;

}
