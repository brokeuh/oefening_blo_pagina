package petit.jochem.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank ( message = "Gelieve je post een titel te geven..")
    private String titel;
    @NotBlank (message = "Gelieve de blog een inhoud te geven ..")
    private String postInhoud;
    private LocalDate date;
    @Size (min=4, max=20, message = "Naam moet tussen de 4-20 tekens bevatten..")
    private String naam;

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Blog() {
        date=LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getPostInhoud() {
        return postInhoud;
    }

    public void setPostInhoud(String postInhoud) {
        this.postInhoud = postInhoud;
    }
}
