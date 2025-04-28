package service.market.authentication.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@Entity(name = "users")
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Represents a user in the system")
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the user", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name", nullable = true)
    @JsonProperty("first_name")
    private String firstName;

    @Column(name = "full_name", nullable = true)
    @JsonProperty("full_name")
    private String fullName;

    @CreatedDate
    @JsonProperty("created_at")
    @Column(name = "created_at")
    @JsonIgnore
    private LocalDateTime createdAt;

    @LastModifiedDate
    @JsonProperty("updated_at")
    @JsonIgnore
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}