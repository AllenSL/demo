package com.example.mongo;

import com.example.base.AbstractBaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;


/**
 * @ClassName MongoJpaTest
 * @Description TODO
 * @Autor ansonglin
 * @Date 2019/7/3 11:42
 * @Version 1.0
 **/
public class MongoJpaTest extends AbstractBaseTest {

//    @Autowired
//    User2Repository user2Repository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    public void test1(){

//        user.setAge(10);
//        user.setId(123l);
//        user.setName("allen");
//        User save = user2Repository.save(user);
//        user2Repository.
//        System.out.println(save);

//        List<Word> words = new ArrayList<>();
//        words.add(new Word(1,0));
//        words.add(new Word(2,0));
//        List<Box> boxs = new ArrayList<>();
//        boxs.add(new Box(1,words));
//        List<Book> books = new ArrayList<>();
//        books.add(new Book(1,boxs));
//        user2Repository.save(new User(1,1,books));



//
//        Query query = new Query(Criteria.where("userId").is(1).and("book.box.boxid").is(1).and("book.box.boxid.word.wordid").is(2));
//        Update update = Update.update("book.box.boxid.word.meaning", "test");
//        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, User.class);



    }


}















