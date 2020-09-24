package com.gugunner.microservice.spring.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(
        name = "comments_model",
        indexes = {
                @Index(name = "idx_pageId",
                    columnList = "pageId")
        }
)
public class Comment implements Serializable {

    @Id
    @Column(length = 36)
    private String id;

    @Version
    private Integer version;

    @Column(columnDefinition = "TEXT")
    private String comment;

    @Column(length = 32)
    private String pageId;

    @Column(length = 32)
    private String username;

    @Column(length = 32)
    private String emailAddress;

    @Column
    private boolean spam;

    private Instant lastModification;

    private Instant creationDate;
}
