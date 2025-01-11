package com.example.demo.text;

import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class text3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary Key
    private String name;

    @ManyToOne
    @JoinColumn(name = "idText") // Tham chiếu đến khóa chính của `text`
    private text text;

    @OneToMany(mappedBy = "text3", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<text4> text4List;

	public text3(Long id, String name, com.example.demo.text.text text, List<text4> text4List) {
		super();
		this.id = id;
		this.name = name;
		this.text = text;
		this.text4List = text4List;
	}

	public text3() {
		super();
	}

	

	
}
