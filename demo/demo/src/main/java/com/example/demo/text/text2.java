package com.example.demo.text;

import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

/**
 * 
 */
@Entity
public class text2 {
    @Id
    private String idText; // Primary Key
    private String name;
    
    @OneToOne
    @JoinColumn(name = "idText") // Tham chiếu đến khóa chính của `text`
    private text text1;

    @OneToMany(mappedBy = "text2", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<text4> text4List;

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

	public text getText1() {
		return text1;
	}

	public void setText1(text text1) {
		this.text1 = text1;
	}

	public List<text4> getText4List() {
		return text4List;
	}

	public void setText4List(List<text4> text4List) {
		this.text4List = text4List;
	}

	public text2(String idText, String name, text text1, List<text4> text4List) {
		this.idText = idText;
		this.name = name;
		this.text1 = text1;
		this.text4List = text4List;
	}

	public text2() {
		super();
	}



}
