package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.revature.models.Post;

@Component("images")//generic stereotype for any spring managed component
@Scope("prototype")
@Entity
@Table(name = "IMAGES")
public class Image {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="imageSequence")
    @SequenceGenerator(name="imageSequence", sequenceName="IMAGE_SEQ", allocationSize=1)
	@Column(name="IMAGE_ID")
	private int imageId;
	
	@Column(name="IMAGE")
	private String image;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="POST_ID")
	private Post post;

	public Image() {
		super();
	}

	public Image(int imageId, String image) {
		super();
		this.imageId = imageId;
		this.image = image;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Image [imageId=" + imageId + ", image=" + image + "]";
	}

}
