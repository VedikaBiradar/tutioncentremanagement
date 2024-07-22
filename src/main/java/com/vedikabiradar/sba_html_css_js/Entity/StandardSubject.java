package com.vedikabiradar.sba_html_css_js.Entity;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "standard_subjects",uniqueConstraints = @UniqueConstraint(columnNames = "standard")
)
@Data
@NoArgsConstructor
@AllArgsConstructor

@Getter
public class StandardSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String standard;

    @Column(nullable = false)
    private String subject;

    public StandardSubject(String standard, String subject) {
        this.standard = standard;
        this.subject = subject;
    }

    public String getStandard() {
        return standard;
    }

    public String getSubject() {
        return subject;
    }
}
