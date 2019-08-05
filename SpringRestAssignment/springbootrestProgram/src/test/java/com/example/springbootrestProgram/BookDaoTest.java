package com.example.springbootrestProgram;

import java.util.Date;
import java.util.Optional;

import javax.persistence.Column;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

import com.example.springbootrestProgram.dao.BooksDao;
import com.example.springbootrestProgram.entity.Books;
import com.example.springbootrestProgram.entity.Subject;
import com.fasterxml.jackson.annotation.JsonFormat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BookDaoTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private BooksDao bookDao;

	@Test
	public void BookDaoTestOne() throws Exception
	{
		this.entityManager.persist(new Books (6,"Book-6",20,3,new Date("12/12/2019"),new Subject(1,"subject-1",20)));
		Optional<Books> book = this.bookDao.findById(Long.parseLong("6"));
		assertThat(book.get().getTitle()).isEqualTo("Book-6");
		assertThat(book.get().getVolume()).isEqualTo(20);
		
		
	}
	
	

}
