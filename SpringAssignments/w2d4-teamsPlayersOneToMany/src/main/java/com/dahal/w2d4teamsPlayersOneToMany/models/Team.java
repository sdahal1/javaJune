package com.dahal.w2d4teamsPlayersOneToMany.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="teams")
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=2, max=100, message= "Team name must be between 2-100 characters")
	private String name;
	
	@NotBlank(message = "City may not be null")
	private String city;
	
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	
	
	//one to many
//	@OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
//    private List<Ninja> ninjas;
	
	@OneToMany(mappedBy="team", fetch= FetchType.LAZY)
	private List<Player> players;
	
	
	
	
	
	//empty constructor
	public Team() {
		
	}
	
	//loaded constructor with the attributes
	public Team(String name, String city) {
		this.name = name;
		this.city = city;
	}
	
	
	
	//this is to auto-generate the created-at and updated-at
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    //ALL MY GETTERS AND SETTERS, NEED THIS TO WORK
    
    
    
	public Long getId() {
		return id;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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



//
//@Entity
//@Table(name="dojos")
//public class Dojo {
//    
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//    @Column(updatable=false)
//    private Date createdAt;
//    private Date updatedAt;
//    @OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
//    private List<Ninja> ninjas;
//    
//    public Dojo() {
//        
//    }
//    // ...
//    // getters and setters removed for brevity
//    // ...
//}