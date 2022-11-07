package com.example.web3_2;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.*;
import java.util.List;

public class DataBase {

    @PersistenceContext(unitName = "postgres")
    private EntityManager em;

    @Resource
    private UserTransaction userTransaction;

    public List<Result> getResultsFromDB() {
        Query query = em.createQuery("select r from Result r");
        return query.getResultList();
    }

    public void addResultToDB(Result result) throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        userTransaction.begin();
        em.persist(result);
        userTransaction.commit();
    }
}
