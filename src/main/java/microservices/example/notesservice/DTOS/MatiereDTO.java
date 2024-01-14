package microservices.example.notesservice.DTOS;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatiereDTO {
    private Long id;
    private String nom;
    private int coefficient;
    private int nbHeures;
}
