package io.github.anantharajuc.sbmwa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.anantharajuc.sbmwa.model.AttenceRecordCountEntity;
import io.github.anantharajuc.sbmwa.model.StaffsEntity;
import io.github.anantharajuc.sbmwa.model.StudentCountEntity;
import lombok.extern.log4j.Log4j2;



@Service
@Log4j2
public class CommonService  {

		
	@Autowired
	EntityManagerFactory entityFact ;
	
	public List<StudentCountEntity> studentDisplayDetails() {
		EntityManager entityManager = entityFact.createEntityManager();
		@SuppressWarnings("unchecked")
		List<StudentCountEntity> studList = entityManager.createNativeQuery("select COUNT(*) as tot,COUNT(case when studentdetail.gender='male' then 1 end)"
				+ " as male,COUNT(case when studentdetail.gender='female' then 1 end) as female from studentdetail where studentdetail.gender is not null;").getResultList();
		return studList ;
	}
	
	

	public List<AttenceRecordCountEntity> attendanceReport(String id) {
		EntityManager entityManager = entityFact.createEntityManager();
		@SuppressWarnings("unchecked")
		List<AttenceRecordCountEntity> studAttenList = entityManager.createNativeQuery("select COUNT(*) as totalDaysCount,COUNT(case when attendancestatus='present' then 1 end)" + 
				"as presentCount,COUNT(case when attendancestatus='Absent' then 1 end) as absentCount from " + 
				"studentattendance where studentid="+id+";").getResultList();
		return studAttenList;
	}



	/*public Object getClassByStudId(String classe, String section) {
		EntityManager entityManager = entityFact.createEntityManager();
		StaffsEntity staffsEntityList = (StaffsEntity) entityManager.createNativeQuery("SELECT * FROM  staffs where classe="+"'"+ classe+"'"+" and section="+"'"+section+"'"+";").getSingleResult();
		return staffsEntityList;

	}*/
}
