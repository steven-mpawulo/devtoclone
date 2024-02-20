package com.example.devtoclone.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(
            nullable = false,
            unique = true
    )
    private String email;
    private String profilePicUrl;
    private String location;
    private String education;
    private String briefDescription;
    private String work;
    @OneToMany
    private List<Article> articles;
    @OneToMany
    private List<Follower> followers;
    @OneToMany
    private List<SocialUrl> socialUrls;
    @OneToMany
    private List<Skill> skills;
    @OneToMany
    private List<Learning> learningList;
    @OneToMany
    private List<Badge> badges;
    @OneToMany
    private List<Organization> organizations;
    @OneToMany
    private List<Comment> comments;
    @CreationTimestamp
    private Date createdOn;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @UpdateTimestamp
    private Date updatedOn;

    protected User() {
    }

    public User(String firstName, String lastName, String email, String profilePicUrl, String location, String education, String briefDescription, String work, List<Article> articles, List<Follower> followers, List<SocialUrl> socialUrls, List<Skill> skills, List<Learning> learningList, List<Badge> badges, List<Organization> organizations, Date createdOn, Date updatedOn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.profilePicUrl = profilePicUrl;
        this.location = location;
        this.education = education;
        this.briefDescription = briefDescription;
        this.work = work;
        this.articles = articles;
        this.followers = followers;
        this.socialUrls = socialUrls;
        this.skills = skills;
        this.learningList = learningList;
        this.badges = badges;
        this.organizations = organizations;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getBriefDescription() {
        return briefDescription;
    }

    public void setBriefDescription(String briefDescription) {
        this.briefDescription = briefDescription;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Follower> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Follower> followers) {
        this.followers = followers;
    }

    public List<SocialUrl> getSocialUrls() {
        return socialUrls;
    }

    public void setSocialUrls(List<SocialUrl> socialUrls) {
        this.socialUrls = socialUrls;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Learning> getLearningList() {
        return learningList;
    }

    public void setLearningList(List<Learning> learningList) {
        this.learningList = learningList;
    }

    public List<Badge> getBadges() {
        return badges;
    }

    public void setBadges(List<Badge> badges) {
        this.badges = badges;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", profilePicUrl='" + profilePicUrl + '\'' +
                ", location='" + location + '\'' +
                ", education='" + education + '\'' +
                ", briefDescription='" + briefDescription + '\'' +
                ", work='" + work + '\'' +
                ", articles=" + articles +
                ", followers=" + followers +
                ", socialUrls=" + socialUrls +
                ", skills=" + skills +
                ", learningList=" + learningList +
                ", badges=" + badges +
                ", organizations=" + organizations +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }


}
