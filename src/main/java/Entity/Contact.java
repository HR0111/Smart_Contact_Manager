package Entity;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contact {

    @Id
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    @Column(length=1000)
    private String description;
    private boolean favorite=false;
    private String websiteLink;
    private String linkedInLink;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy="contact" , cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true )   // one user can have many contact
    private List<SocialLink> links = new ArrayList<>();

}
