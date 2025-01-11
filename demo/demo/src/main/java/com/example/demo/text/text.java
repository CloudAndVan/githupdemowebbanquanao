package com.example.demo.text;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class text {
    @Id
    private String idText; // Primary Key
    private String name;
    
    @OneToOne(mappedBy = "text1", cascade = CascadeType.ALL)
    private text2 text2;

    @OneToMany(mappedBy = "text", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<text3> text3List;

	public String getIdText() {
		return idText;
	}

	public void setIdText(String idText) {
		this.idText = idText;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public text2 getText2() {
		return text2;
	}

	public void setText2(text2 text2) {
		this.text2 = text2;
	}

	public List<text3> getText3List() {
		return text3List;
	}

	public void setText3List(List<text3> text3List) {
		this.text3List = text3List;
	}

	public text(String idText, String name, com.example.demo.text.text2 text2, List<text3> text3List) {
		super();
		this.idText = idText;
		this.name = name;
		this.text2 = text2;
		this.text3List = text3List;
	}

	public text() {
		super();
	}
    
    
}
