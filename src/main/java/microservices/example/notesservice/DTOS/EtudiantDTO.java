package microservices.example.notesservice.DTOS;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EtudiantDTO {
    private Long id;
    private String nom;
    private int age;
    private String email;
}
