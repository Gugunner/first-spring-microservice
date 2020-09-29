package com.gugunner.microservices.model;

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

    public Comment() {}

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public String getComment() {
        return this.comment;
    }

    public void setSpam(boolean spam) {
        this.spam = spam;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setLastModificationDate(Instant lastModificationDate) {
        this.lastModification = lastModificationDate;
    }

    public void setCreationDate(Instant creationDate) {
        System.out.println("Creation Date " + creationDate);
        this.creationDate = creationDate;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }


    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPageId() {
        return this.pageId;
    }

    public Instant getLastModificationDate() {
        return this.lastModification;
    }

    public Instant getCreationDate() {
        return this.creationDate;
    }

    public boolean isSpam() {
        return spam;
    }
}
