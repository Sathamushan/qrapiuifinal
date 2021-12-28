package  io.github.anantharajuc.sbmwa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="books")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@FieldDefaults(level=AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin
public class BooksEntity extends AuditEntity
{
	
	private static final long serialVersionUID = 1L;

	/*@Column(name="bookid", nullable = true)
	int  bookid;*/
	
	/*@Column(name="studentname", nullable = true)
	String studentname;
	
	@Column(name="parentname", nullable = true)
	String parentname;*/
	
	@Column(name="title", nullable = true)
	String title;
	
	@Column(name="classe", nullable = true)
	String classe;
	
	/*@Column(name="section", nullable = true)
	String section;*/
	
	@Column(name="subject", nullable = true)
	String subject;
	
	@Column(name="downloadurl", nullable = true)
	String downloadurl;
	

/*
table: books
columns:
bookid int(11) ai pk 
class varchar(45) 
section varchar(45) 
subject varchar(45) 
downloadurl varchar(45)*/

	
}




