package com.example.web3_2;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Entity
public class Result implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "x", nullable = false)
    private Double x;
    @Column(name = "y", nullable = false)
    private Double y;
    @Column(name = "r", nullable = false)
    private Double r = 1D;
    @Column(name = "initTime", nullable = false)
    private ZonedDateTime initTime;
    @Column(name = "answer", nullable = false)
    private Boolean answer;
    @Column(name = "workTime", nullable = false)
    private Long workTime;



    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public Double getR() {
        return r;
    }

    public ZonedDateTime getInitTime() {
        return initTime;
    }

    public Boolean getAnswer() {
        return answer;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }

    public double getWorkTime() {
        return workTime;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public void setInitTime(ZonedDateTime initTime) {
        this.initTime = initTime;
    }


    public void setWorkTime(long workTime) {
        this.workTime = workTime;
    }

    /*private boolean topRight(double x, double y, double r) {
        return x >= 0 && x <= r/2 && y <= r - x * 2;
    }

    private boolean bottomLeft(double x, double y, double r) {
        return x <= 0 && x >= -r / 2 && y <= 0 && y >= -r/2 && x*x+y*y <= r*r/4;
    }

    private boolean bottomRight(double x, double y, double r) {
        return x >= 0 && x <= r && y <= 0 && y >= -r;
    }

    public void checkAll() {
        if (topRight(x, y, r) || bottomLeft(x, y, r) || bottomRight(x, y, r)) {
            answer = ;
        } else answer = "нет";
    }*/
}

