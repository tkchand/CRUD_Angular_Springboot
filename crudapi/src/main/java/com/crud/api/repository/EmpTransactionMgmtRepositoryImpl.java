package com.crud.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.crud.api.entity.Employees;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class EmpTransactionMgmtRepositoryImpl implements EmpTransactionMgmtRepository{

	   @PersistenceContext
	   EntityManager entityManager;
	
	    @Override
	    @Transactional
		public List<Employees> getAllEmployees() {
	    	List<Employees>  empList = null;
	    	try {
	    	 empList = entityManager.createNamedQuery("findAllEmployee").getResultList();
	    	}catch (Exception e) {
			 e.printStackTrace();
			}
	    	 
	    	 return empList;
		}
	    
	    @Override
	    public Employees getEmployeeById(int id) {
	    	Employees emp = (Employees)entityManager.createQuery("SELECT c FROM Employees c WHERE c.id="+id).getSingleResult();
	        return emp;
	    }
	    
	    @Override
	    @Transactional
	    public Long saveOrUpdate(Employees employee) {
	    	 entityManager.persist(employee);
	    	 Long id = employee.getId();
	    	 
	    	 return id;
	    }
	    
	    @Override	 
	    @Transactional
	    public int delete(Long id) {
	       
	    	Query query = entityManager.createQuery("Delete  from Employees c where c.id = :id");
	    	query.setParameter("id", id);
	    	int rows = query.executeUpdate();
	    	//entityManager.getTransaction().commit();
	    	
	     	
	    	return rows;
	    }
}
