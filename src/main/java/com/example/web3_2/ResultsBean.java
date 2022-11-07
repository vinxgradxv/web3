package com.example.web3_2;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class ResultsBean implements Serializable {

    private Result result = new Result();

    private DataBase dataBase;

    private List<Result> resultList = new ArrayList<>();

    @PostConstruct
    public void postConstruct() {
        resultList = dataBase.getResultsFromDB();
    }

    public boolean isHit (Result result) {
        return result.getAnswer();
    }

    public void addResult () throws HeuristicRollbackException, SystemException, HeuristicMixedException, NotSupportedException, RollbackException {
        result.setInitTime(ZonedDateTime.now());
        long startTime = System.nanoTime();
        double x = result.getX();
        double y = result.getY();
        double r = result.getR();
        if (topRight(x, y, r) || bottomRight(x, y, r) || bottomLeft(x, y, r)) {
            result.setAnswer(true);
        }
        else result.setAnswer(false);
        resultList.add(result);
        dataBase.addResultToDB(result);
        result.setWorkTime(System.nanoTime() - startTime);
        result = new Result();
    }

    public void clearResultList() {
        resultList = new ArrayList<>();
        result = new Result();
    }

    private boolean topRight(double x, double y, double r) {
        return x >= 0 && x <= r/2 && y <= r - x * 2 && y >=0;
    }

    private boolean bottomLeft(double x, double y, double r) {
        return x <= 0 && x >= -r / 2 && y <= 0 && y >= -r/2 && x*x+y*y <= r*r/4;
    }

    private boolean bottomRight(double x, double y, double r) {
        return x >= 0 && x <= r && y <= 0 && y >= -r;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public List<Result> getResultList() {
        return resultList;
    }

    public void setResultList(List<Result> resultList) {
        this.resultList = resultList;
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }
}
