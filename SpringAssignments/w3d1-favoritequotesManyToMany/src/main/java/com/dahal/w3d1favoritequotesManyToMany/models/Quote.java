package com.dahal.w3d1favoritequotesManyToMany.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="quotes")
public class Quote {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 
	@NotBlank(message="Quoted by is required")
	@Size(min=2, message="Name of quoter must be at least 2 characters")
	private String quotedBy;
	 
	 
	@NotBlank(message="Quote content is required")
	@Size(min=5, max= 100, message="Quote needs to be between 5-100 characters long. No more, no less.")
	private String content;
	
	
	private float rating;
	
	//creating a many to many relationship
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name= "users_favorite_quotes",
			joinColumns = @JoinColumn(name="quote_id"),
			inverseJoinColumns = @JoinColumn(name="user_id")
			)
	private List<User> usersWhoLike;

	
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	//auto generate the created at and updated at
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
	//empty constructor
    public Quote(){
    	
    }
    //loaded constructor
    public Quote(String quotedBy, String content, float rating) {
    	this.quotedBy= quotedBy;
    	this.content= content;
    	this.rating = rating;
    }
    
    
    //getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuotedBy() {
		return quotedBy;
	}
	public void setQuotedBy(String quotedBy) {
		this.quotedBy = quotedBy;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public List<User> getUsersWhoLike() {
		return usersWhoLike;
	}
	public void setUsersWhoLike(List<User> usersWhoLike) {
		this.usersWhoLike = usersWhoLike;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
    
    
	
    
    
	
	
	
	
	
	

}
