package br.com.stefanini.projetorelquatro.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPost;
	private String title;
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="post_id", referencedColumnName ="id")
	@JsonBackReference(value="posts")
	private Author author;
	
	public Post() {
		
	}
	
	public Post(Long idPost, String title, String description, Author author) {
		super();
		this.idPost = idPost;
		this.title = title;
		this.description = description;
		this.author = author;
	}

	@Override
	public String toString() {
		return "Post [idPost=" + idPost + ", title=" + title + ", description=" + description + ", author=" + author
				+ "]";
	}

	public Long getIdPost() {
		return idPost;
	}
	public void setIdPost(Long idPost) {
		this.idPost = idPost;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
}
