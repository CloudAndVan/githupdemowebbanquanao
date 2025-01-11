package com.example.demo.text;

import jakarta.persistence.*;

@Entity
public class text4 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary Key

    @ManyToOne
    @JoinColumn(name = "text3_id")
    private text3 text3;

    @ManyToOne
    @JoinColumn(name = "text2_id")
    private text2 text2;

    private String additionalInfo; // Thông tin bổ sung nếu cần

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public text3 getText3() {
        return text3;
    }

    public void setText3(text3 text3) {
        this.text3 = text3;
    }

    public text2 getText2() {
        return text2;
    }

    public void setText2(text2 text2) {
        this.text2 = text2;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public text4(text3 text3, text2 text2, String additionalInfo) {
        super();
        this.text3 = text3;
        this.text2 = text2;
        this.additionalInfo = additionalInfo;
    }

    public text4() {
        super();
    }
}
