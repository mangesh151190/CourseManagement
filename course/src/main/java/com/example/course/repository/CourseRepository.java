package com.example.course.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.course.entity.Course;
@Repository

public class CourseRepository {
	
	@Autowired
	EntityManager em;
	
	public Course findById(Long id){
		return em.find(Course.class, id);
		
	}
	
	@Transactional
	public List<Course> remove(Long l) {
		Course course=findById(l);
		em.remove(course);
		List<Course> temp = findAll();
		for(Course c:temp){
			if(c.getId()>l){
				Course course2=findById(c.getId());
				em.remove(course2);
			}
		}
		Long i=l;
		for(Course c:temp){
			if(c.getId()>i){
				add(new Course(l,c.getName()));
				l++;
			}
		}
		
		System.out.println(getMaxId());
		return findAll();		
	}
	
	public Long getMaxId(){
		return (Long) em.createQuery("select max(e.id) from Course e ")
		  .getSingleResult();
	}


	public List<Course> findAll() {
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
//        Root<Course> rootEntry = cq.from(Course.class);
//        CriteriaQuery<Course> all = cq.select(rootEntry);
//        TypedQuery<Course> allQuery = em.createQuery(all);
//        return allQuery.getResultList();
		return  em.createQuery("select e from Course e ")
				  .getResultList();
	}

	@Transactional
	public List<Course> add(Course course) {
		if(course.getId()==null){
			em.persist(course);
		}else{
			em.merge(course);
		}
		return findAll();
	}

}
